package com.cookiesmile.mnml_weather.screen.forecast;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.di.ScreenScope;

import javax.inject.Inject;

@ScreenScope
public class ForecastWeatherPresenter {

  @Inject
  ForecastWeatherPresenter(ForecastWeatherViewModel viewModel, WeatherRepository repository) {
    repository.getForecastWeather()
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(viewModel.resultUpdated(), viewModel.onError());
  }
}
