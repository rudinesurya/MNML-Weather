package com.cookiesmile.mnml_weather.screen.forecast;

import com.cookiesmile.mnml_weather.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface ForecastWeatherComponent extends
    AndroidInjector<ForecastWeatherController> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<ForecastWeatherController> {

    @Override
    public void seedInstance(ForecastWeatherController instance) {
    }
  }
}
