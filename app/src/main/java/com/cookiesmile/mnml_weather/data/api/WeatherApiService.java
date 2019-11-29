package com.cookiesmile.mnml_weather.data.api;

import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

  @GET("weather")
  Single<CurrentWeatherResponse> getCurrentWeather(@Query("q") String cityName);

  @GET("forecast")
  Single<ForecastWeatherResponse> getForecastWeather(@Query("id") long id);
}
