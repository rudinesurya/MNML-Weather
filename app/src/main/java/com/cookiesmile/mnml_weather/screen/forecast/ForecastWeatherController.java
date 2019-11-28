package com.cookiesmile.mnml_weather.screen.forecast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluelinelabs.conductor.Controller;
import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;
import com.cookiesmile.mnml_weather.data.api.response.forecast.inner.ListItem;
import com.cookiesmile.mnml_weather.data.model.ForecastWeatherItem;
import com.cookiesmile.mnml_weather.navigation.ScreenNavigation;
import com.cookiesmile.mnml_weather.screen.forecast.utils.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ForecastWeatherController extends BaseController {

  static final String CITY_ID_KEY = "city_id";

  @Inject
  ForecastWeatherViewModel viewModel;
  @Inject
  ForecastWeatherPresenter presenter;
  @Inject
  ScreenNavigation screenNavigation;

  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.loading_indicator)
  View loadingView;
  @BindView(R.id.tv_error)
  TextView errorText;
  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;

  public ForecastWeatherController(Bundle bundle) {
    super(bundle);
  }

  public static Controller newInstance(long id) {
    Bundle bundle = new Bundle();
    bundle.putLong(CITY_ID_KEY, id);
    return new ForecastWeatherController(bundle);
  }

  @Override
  protected int layoutRes() {
    return R.layout.screen_forecast_weather;
  }

  @Override
  protected void onViewBound(View view) {
    toolbar.setNavigationIcon(R.drawable.ic_back);
    toolbar.setNavigationOnClickListener(v -> screenNavigation.pop());

    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.setAdapter(new MyListAdapter());
  }

  @Override
  protected Disposable[] subscriptions() {
    return new Disposable[]{
        viewModel.loading()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(loading -> {
          loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
          recyclerView.setVisibility(loading ? View.GONE : View.VISIBLE);
          errorText.setVisibility(loading ? View.GONE : errorText.getVisibility());
        }),

        viewModel.result()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::PopulateRecyclerView),

        viewModel.error()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(errorRes -> {
          if (errorRes == -1) {
            errorText.setText(null);
            errorText.setVisibility(View.GONE);
          } else {
            errorText.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            errorText.setText(errorRes);
          }
        })
    };
  }

  private void PopulateRecyclerView(ForecastWeatherResponse forecastWeatherResponse) {

    List<ForecastWeatherItem> data = new ArrayList<>();

    int count = forecastWeatherResponse.list().size();
    for (int i = 0; i < count; ++i) {
      ListItem item = forecastWeatherResponse.list().get(i);
      String date = item.dtTxt();
      double temp_k = item.main().temp();
      String condition = item.weather().get(0).main();
      String icon = item.weather().get(0).icon();

      data.add(ForecastWeatherItem.builder()
          .id(i)
          .date(date)
          .temp_k(temp_k)
          .condition(condition)
          .icon(icon)
          .build());
    }

    ((MyListAdapter) recyclerView.getAdapter()).setData(data);
  }
}
