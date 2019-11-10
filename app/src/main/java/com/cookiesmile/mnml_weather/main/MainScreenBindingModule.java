package com.cookiesmile.mnml_weather.main;

import com.bluelinelabs.conductor.Controller;
import com.cookiesmile.mnml_weather.di.ControllerKey;
import com.cookiesmile.mnml_weather.screen.current.CurrentWeatherComponent;
import com.cookiesmile.mnml_weather.screen.current.CurrentWeatherController;
import com.cookiesmile.mnml_weather.screen.forecast.ForecastWeatherComponent;
import com.cookiesmile.mnml_weather.screen.forecast.ForecastWeatherController;
import com.cookiesmile.mnml_weather.screen.main.MainController;
import com.cookiesmile.mnml_weather.screen.main.MainControllerComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
    MainControllerComponent.class,
    CurrentWeatherComponent.class,
    ForecastWeatherComponent.class,
})
abstract class MainScreenBindingModule {

  @Binds
  @IntoMap
  @ControllerKey(MainController.class)
  abstract AndroidInjector.Factory<? extends Controller> bindMainControllerInjector(
      MainControllerComponent.Builder builder);

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
}