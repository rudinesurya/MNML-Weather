package com.cookiesmile.mnml_weather.data.api.response.future;

import com.cookiesmile.mnml_weather.data.api.response.future.inner.City;
import com.cookiesmile.mnml_weather.data.api.response.future.inner.List;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;


@AutoValue
public abstract class ForecastWeatherResponse {

  public static JsonAdapter<ForecastWeatherResponse> jsonAdapter(Moshi moshi) {
    return new AutoValue_ForecastWeatherResponse.MoshiJsonAdapter(moshi);
  }

  @Json(name = "cod")
  public abstract String cod();

  @Json(name = "message")
  public abstract long message();

  @Json(name = "cnt")
  public abstract long cnt();

  @Json(name = "list")
  public abstract java.util.List<List> list();

  @Json(name = "city")
  public abstract City city();

}
