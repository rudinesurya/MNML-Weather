package com.cookiesmile.mnml_weather.screen.current;

import android.view.View;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;
import com.cookiesmile.mnml_weather.data.WeatherRepository;

import javax.inject.Inject;

import timber.log.Timber;

public class CurrentWeatherController extends BaseController {

  @Inject
  WeatherRepository weatherRepository;

  @Override
  protected void onViewBound(View view) {
    weatherRepository.getCurrentWeather()
        .subscribe(currentWeather ->
                Timber.d(currentWeather.toString())
            , err ->
                Timber.e(err)
        );
  }

  @Override
  protected int layoutRes() {
    return R.layout.screen_current_weather;
  }
}
