package com.cookiesmile.mnml_weather.data.api;

import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherApiServiceRequester {

  private final WeatherApiService service;

  @Inject
  WeatherApiServiceRequester(WeatherApiService service) {
    this.service = service;
  }

  public Single<CurrentWeatherResponse> getCurrentWeather() {
    return service.getCurrentWeather();
  }
}