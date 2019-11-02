package com.cookiesmile.mnml_weather.screen.current;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.di.ScreenScope;

import javax.inject.Inject;

@ScreenScope
public class CurrentWeatherPresenter {

  @Inject
  CurrentWeatherPresenter(CurrentWeatherViewModel viewModel, WeatherRepository repository) {
    repository.getCurrentWeather()
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(viewModel.resultUpdated(), viewModel.onError());
  }
}