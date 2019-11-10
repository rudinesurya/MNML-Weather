package com.cookiesmile.mnml_weather.data.api.response.forecast;

import com.cookiesmile.mnml_weather.data.api.response.forecast.inner.City;
import com.cookiesmile.mnml_weather.data.api.response.forecast.inner.ListItem;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class ForecastWeatherResponse {

  public static JsonAdapter<ForecastWeatherResponse> jsonAdapter(Moshi moshi) {
    return new AutoValue_ForecastWeatherResponse.MoshiJsonAdapter(moshi);
  }

  @Json(name = "cod")
  public abstract String cod();

  @Json(name = "cnt")
  public abstract long cnt();

  @Json(name = "list")
  public abstract List<ListItem> list();

  @Json(name = "city")
  public abstract City city();
}
