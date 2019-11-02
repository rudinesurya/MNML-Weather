package com.cookiesmile.mnml_weather.data.api;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Module
public abstract class WeatherApiServiceModule {

  @Provides
  @Singleton
  static WeatherApiService provideWeatherApiService(Retrofit retrofit) {
    return retrofit.create(WeatherApiService.class);
  }

  @Provides
  @Named("network_scheduler")
  static Scheduler provideNetworkScheduler() {
    return Schedulers.io();
  }
}
