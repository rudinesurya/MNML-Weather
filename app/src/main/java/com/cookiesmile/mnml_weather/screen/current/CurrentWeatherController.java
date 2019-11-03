package com.cookiesmile.mnml_weather.screen.current;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;
import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;

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
  @BindView(R.id.tv_city)
  TextView cityText;
  @BindView(R.id.icon)
  ImageView icon;
  @BindView(R.id.tv_temperature)
  TextView temperatureText;
  @BindView(R.id.tv_description)
  TextView descriptionText;

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

          if (loading) {
            HideWeatherInfo();
          } else {
            ShowWeatherInfo();
          }

          errorText.setVisibility(loading ? View.GONE : errorText.getVisibility());
        }),
        viewModel.result()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::PopulateWeatherInfo),
        viewModel.error()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(errorRes -> {
          if (errorRes == -1) {
            errorText.setText(null);
            errorText.setVisibility(View.GONE);
          } else {
            errorText.setVisibility(View.VISIBLE);
            HideWeatherInfo();
            errorText.setText(errorRes);
          }
        })
    };
  }

  private void HideWeatherInfo() {
    cityText.setVisibility(View.GONE);
    icon.setVisibility(View.GONE);
    temperatureText.setVisibility(View.GONE);
    descriptionText.setVisibility(View.GONE);
  }

  private void ShowWeatherInfo() {
    cityText.setVisibility(View.VISIBLE);
    icon.setVisibility(View.VISIBLE);
    temperatureText.setVisibility(View.VISIBLE);
    descriptionText.setVisibility(View.VISIBLE);
  }

  private void PopulateWeatherInfo(CurrentWeatherResponse weather) {
    String iconUrl =
        "https://openweathermap.org/img/wn/" + weather.weather().get(0).icon() + "@2x.png";
    Glide.with(this.getApplicationContext()).load(iconUrl).into(icon);

    cityText.setText(weather.name());
    double temp = KelvinToCelsius(weather.main().temp());
    String tempString = String.format("%.1f\u00B0c", temp);
    temperatureText.setText(tempString);
    descriptionText.setText(weather.weather().get(0).description());
  }

  private double KelvinToCelsius(double kelvin) {
    return kelvin - 273.15;
  }
}
