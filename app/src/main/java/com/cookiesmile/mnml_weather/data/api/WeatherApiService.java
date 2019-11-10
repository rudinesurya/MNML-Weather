package com.cookiesmile.mnml_weather.data.api;

import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WeatherApiService {

  @GET("weather?q=London,uk&appid=ac9835cb622906b6984abff688c81034")
  Single<CurrentWeatherResponse> getCurrentWeather();

  @GET("forecast?q=London,uk&appid=ac9835cb622906b6984abff688c81034")
  Single<ForecastWeatherResponse> getForecastWeather();
}
