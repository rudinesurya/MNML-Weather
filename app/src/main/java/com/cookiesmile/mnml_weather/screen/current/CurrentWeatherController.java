package com.cookiesmile.mnml_weather.screen.current;

import android.view.View;
import android.widget.TextView;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class CurrentWeatherController extends BaseController {

  @Inject
  CurrentWeatherViewModel viewModel;
  @Inject
  CurrentWeatherPresenter presenter;

  @BindView(R.id.loading_indicator)
  View loadingView;
  @BindView(R.id.tv_error)
  TextView errorText;
  @BindView(R.id.tv_result)
  TextView resultText;

  @Override
  protected int layoutRes() {
    return R.layout.screen_current_weather;
  }

  @Override
  protected Disposable[] subscriptions() {
    return new Disposable[]{
        viewModel.loading()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(loading -> {
          loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
          resultText.setVisibility(loading ? View.GONE : View.VISIBLE);
          errorText.setVisibility(loading ? View.GONE : errorText.getVisibility());
        }),
        viewModel.result()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(result ->
            resultText.setText(result.toString())
        ),
        viewModel.error()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(errorRes -> {
          if (errorRes == -1) {
            errorText.setText(null);
            errorText.setVisibility(View.GONE);
          } else {
            errorText.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.GONE);
            errorText.setText(errorRes);
          }
        })
    };
  }
}
