package com.cookiesmile.mnml_weather.data.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class WeatherApiServiceModule {

  @Provides
  @Singleton
  static WeatherApiService provideWeatherApiService(Retrofit retrofit) {
    return retrofit.create(WeatherApiService.class);
  }
}
