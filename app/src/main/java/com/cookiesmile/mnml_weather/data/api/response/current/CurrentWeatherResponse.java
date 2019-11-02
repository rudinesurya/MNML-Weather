package com.cookiesmile.mnml_weather.data.api.response.current;

import com.cookiesmile.mnml_weather.data.api.response.current.inner.Clouds;
import com.cookiesmile.mnml_weather.data.api.response.current.inner.Coord;
import com.cookiesmile.mnml_weather.data.api.response.current.inner.Main;
import com.cookiesmile.mnml_weather.data.api.response.current.inner.Sys;
import com.cookiesmile.mnml_weather.data.api.response.current.inner.Weather;
import com.cookiesmile.mnml_weather.data.api.response.current.inner.Wind;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class CurrentWeatherResponse {

  public static JsonAdapter<CurrentWeatherResponse> jsonAdapter(Moshi moshi) {
    return new AutoValue_CurrentWeatherResponse.MoshiJsonAdapter(moshi);
  }

  @Json(name = "coord")
  public abstract Coord coord();

  @Json(name = "weather")
  public abstract List<Weather> weather();

  @Json(name = "main")
  public abstract Main main();

  @Json(name = "visibility")
  public abstract long visibility();

  @Json(name = "wind")
  public abstract Wind wind();

  @Json(name = "clouds")
  public abstract Clouds clouds();

  @Json(name = "dt")
  public abstract long dt();

  @Json(name = "sys")
  public abstract Sys sys();

  @Json(name = "id")
  public abstract long id();

  @Json(name = "name")
  public abstract String name();

  @Json(name = "cod")
  public abstract long cod();
}
