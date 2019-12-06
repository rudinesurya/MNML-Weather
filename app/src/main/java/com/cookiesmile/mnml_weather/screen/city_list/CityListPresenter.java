package com.cookiesmile.mnml_weather.screen.city_list;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.di.ScreenScope;

import javax.inject.Inject;

@ScreenScope
public class CityListPresenter {

  @Inject
  CityListPresenter(CityListViewModel viewModel, WeatherRepository repository) {

  }
}
