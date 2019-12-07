package com.cookiesmile.mnml_weather.main;

import com.bluelinelabs.conductor.Controller;
import com.cookiesmile.mnml_weather.di.ControllerKey;
import com.cookiesmile.mnml_weather.screen.city_list.CityListComponent;
import com.cookiesmile.mnml_weather.screen.city_list.CityListController;
import com.cookiesmile.mnml_weather.screen.current.CurrentWeatherComponent;
import com.cookiesmile.mnml_weather.screen.current.CurrentWeatherController;
import com.cookiesmile.mnml_weather.screen.forecast.ForecastWeatherComponent;
import com.cookiesmile.mnml_weather.screen.forecast.ForecastWeatherController;
import com.cookiesmile.mnml_weather.screen.settings.SettingsComponent;
import com.cookiesmile.mnml_weather.screen.settings.SettingsController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
    CurrentWeatherComponent.class,
    ForecastWeatherComponent.class,
    CityListComponent.class,
    SettingsComponent.class,
})
abstract class MainScreenBindingModule {

  @Binds
  @IntoMap
  @ControllerKey(CurrentWeatherController.class)
  abstract AndroidInjector.Factory<? extends Controller> bindCurrentWeatherInjector(
      CurrentWeatherComponent.Builder builder);

  @Binds
  @IntoMap
  @ControllerKey(ForecastWeatherController.class)
  abstract AndroidInjector.Factory<? extends Controller> bindForecastWeatherInjector(
      ForecastWeatherComponent.Builder builder);

  @Binds
  @IntoMap
  @ControllerKey(CityListController.class)
  abstract AndroidInjector.Factory<? extends Controller> bindCityListInjector(
      CityListComponent.Builder builder);

  @Binds
  @IntoMap
  @ControllerKey(SettingsController.class)
  abstract AndroidInjector.Factory<? extends Controller> bindSettingsInjector(
      SettingsComponent.Builder builder);
}