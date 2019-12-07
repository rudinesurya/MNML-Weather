package com.cookiesmile.mnml_weather.screen.city_list;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.di.ScreenScope;

import javax.inject.Inject;

import timber.log.Timber;

@ScreenScope
public class CityListPresenter {

  @Inject
  CityListPresenter(CityListViewModel viewModel, WeatherRepository repository) {
    repository.getAllSavedCity()
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(r -> {
          Timber.d("result size: " + r.size());
          viewModel.resultUpdated();
        }, viewModel.onError());
  }
}
