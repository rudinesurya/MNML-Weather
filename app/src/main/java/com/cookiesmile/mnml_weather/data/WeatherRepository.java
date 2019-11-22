package com.cookiesmile.mnml_weather.data;

import com.cookiesmile.mnml_weather.data.api.WeatherApiService;
import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.Single;

@Singleton
public class WeatherRepository {

  private final Provider<WeatherApiService> serviceProvider;
  private final Scheduler scheduler;

  @Inject
  WeatherRepository(Provider<WeatherApiService> serviceProvider,
      @Named("network_scheduler") Scheduler scheduler) {
    this.serviceProvider = serviceProvider;
    this.scheduler = scheduler;
  }

  public Single<CurrentWeatherResponse> getCurrentWeather() {
    return serviceProvider.get().getCurrentWeather().subscribeOn(scheduler);
  }

  public Single<ForecastWeatherResponse> getForecastWeather() {
    return serviceProvider.get().getForecastWeather().subscribeOn(scheduler);
  }
}
