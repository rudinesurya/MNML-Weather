package com.cookiesmile.mnml_weather.screen.current;

import com.cookiesmile.mnml_weather.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface CurrentWeatherComponent extends
    AndroidInjector<CurrentWeatherController> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<CurrentWeatherController> {

    @Override
    public void seedInstance(CurrentWeatherController instance) {
    }
  }
}