package com.cookiesmile.mnml_weather.data;

import com.cookiesmile.mnml_weather.data.api.WeatherApiServiceRequester;
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

  private final Provider<WeatherApiServiceRequester> weatherApiServiceRequesterProvider;
  private final Scheduler scheduler;

  @Inject
  WeatherRepository(Provider<WeatherApiServiceRequester> weatherApiServiceRequesterProvider,
      @Named("network_scheduler") Scheduler scheduler) {
    this.weatherApiServiceRequesterProvider = weatherApiServiceRequesterProvider;
    this.scheduler = scheduler;
  }

  public Single<CurrentWeatherResponse> getCurrentWeather() {
    return weatherApiServiceRequesterProvider.get().getCurrentWeather().subscribeOn(scheduler);
  }

  public Single<ForecastWeatherResponse> getForecastWeather() {
    return weatherApiServiceRequesterProvider.get().getForecastWeather().subscribeOn(scheduler);
  }
}
