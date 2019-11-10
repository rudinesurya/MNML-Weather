package com.cookiesmile.mnml_weather.data.api.response.forecast.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Wind {

  public static JsonAdapter<Wind> jsonAdapter(Moshi moshi) {
    return new AutoValue_Wind.MoshiJsonAdapter(moshi);
  }

  @Json(name = "speed")
  public abstract double speed();

  @Json(name = "deg")
  public abstract double deg();
}
