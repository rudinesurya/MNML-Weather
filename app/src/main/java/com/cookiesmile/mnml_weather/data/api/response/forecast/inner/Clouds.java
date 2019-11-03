package com.cookiesmile.mnml_weather.data.api.response.forecast.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Clouds {

  public static JsonAdapter<Clouds> jsonAdapter(Moshi moshi) {
    return new AutoValue_Clouds.MoshiJsonAdapter(moshi);
  }

  @Json(name = "all")
  public abstract double all();
}
