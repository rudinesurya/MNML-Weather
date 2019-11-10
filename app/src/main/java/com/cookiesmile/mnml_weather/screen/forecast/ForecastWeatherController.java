package com.cookiesmile.mnml_weather.screen.forecast;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;
import com.cookiesmile.mnml_weather.data.model.ForecastWeatherItem;
import com.cookiesmile.mnml_weather.screen.forecast.utils.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ForecastWeatherController extends BaseController {

  @Inject
  ForecastWeatherViewModel viewModel;
  @Inject
  ForecastWeatherPresenter presenter;

  @BindView(R.id.loading_indicator)
  View loadingView;
  @BindView(R.id.tv_error)
  TextView errorText;
  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;

  @Override
  protected int layoutRes() {
    return R.layout.screen_forecast_weather;
  }

  @Override
  protected void onViewBound(View view) {
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

    List<ForecastWeatherItem> dummy = new ArrayList<>();
    dummy.add(ForecastWeatherItem.create(0, 123, 280, "Rainy", "01n"));
    dummy.add(ForecastWeatherItem.create(1, 143, 290, "Rainy", "01n"));

    ((MyListAdapter) recyclerView.getAdapter()).setData(dummy);
  }
}
