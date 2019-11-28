package com.cookiesmile.mnml_weather.screen.forecast;

import com.cookiesmile.mnml_weather.di.ScreenScope;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface ForecastWeatherComponent extends
    AndroidInjector<ForecastWeatherController> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<ForecastWeatherController> {

    @BindsInstance
    public abstract void bindCityName(@Named("city_id") long id);

    @Override
    public void seedInstance(ForecastWeatherController instance) {
      bindCityName(instance.getArgs().getLong(ForecastWeatherController.CITY_ID_KEY));
    }
  }
}
