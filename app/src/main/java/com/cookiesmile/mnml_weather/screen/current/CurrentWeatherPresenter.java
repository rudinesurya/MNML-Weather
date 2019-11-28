package com.cookiesmile.mnml_weather.screen.current;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.di.ScreenScope;
import com.cookiesmile.mnml_weather.navigation.ScreenNavigation;

import javax.inject.Inject;

@ScreenScope
public class CurrentWeatherPresenter {

  private final ScreenNavigation screenNavigation;

  @Inject
  CurrentWeatherPresenter(CurrentWeatherViewModel viewModel, WeatherRepository repository,
      ScreenNavigation screenNavigation) {
    this.screenNavigation = screenNavigation;

    repository.getCurrentWeather()
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(viewModel.resultUpdated(), viewModel.onError());
  }
}