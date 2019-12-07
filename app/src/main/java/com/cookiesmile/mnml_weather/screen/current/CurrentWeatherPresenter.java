package com.cookiesmile.mnml_weather.screen.current;

import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.data.model.SavedCity;
import com.cookiesmile.mnml_weather.di.ScreenScope;
import com.cookiesmile.mnml_weather.navigation.ScreenNavigation;

import javax.inject.Inject;

import timber.log.Timber;

@ScreenScope
public class CurrentWeatherPresenter implements OnMenuItemClickListener {

  private final CurrentWeatherViewModel viewModel;
  private final WeatherRepository repository;
  private final ScreenNavigation screenNavigation;

  private long cityId = -1;
  private String cityName = "London, UK";

  @Inject
  CurrentWeatherPresenter(CurrentWeatherViewModel viewModel, WeatherRepository repository,
      ScreenNavigation screenNavigation) {
    this.viewModel = viewModel;
    this.repository = repository;
    this.screenNavigation = screenNavigation;

    repository.addCity(new SavedCity("London, UK"));
    repository.addCity(new SavedCity("Dublin, IE"));

    repository.getCurrentWeather(cityName)
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(result -> {
          cityId = result.getId();
          Timber.d("city id = " + cityId);
          viewModel.resultUpdated().accept(result);
        }, viewModel.onError());
  }

  @Override
  public boolean onMenuItemClick(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.forecast:
        screenNavigation.goToForecast(cityId);
        return true;

      case R.id.cityList:
        screenNavigation.goToSavedCity();
        return true;

      case R.id.settings:
        screenNavigation.goToSettings();
        return true;
    }
    return false;
  }
}