package com.cookiesmile.mnml_weather.main;

import com.bluelinelabs.conductor.Controller;
import com.cookiesmile.mnml_weather.di.ControllerKey;
import com.cookiesmile.mnml_weather.screen.current.CurrentWeatherComponent;
import com.cookiesmile.mnml_weather.screen.current.CurrentWeatherController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
    CurrentWeatherComponent.class,
})
public abstract class MainScreenBindingModule {

  @Binds
  @IntoMap
  @ControllerKey(CurrentWeatherController.class)
  abstract AndroidInjector.Factory<? extends Controller> bindCurrentWeatherInjector(
      CurrentWeatherComponent.Builder builder);
}