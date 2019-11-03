package com.cookiesmile.mnml_weather.data.api.response.future.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Coord {

  public static JsonAdapter<Coord> jsonAdapter(Moshi moshi) {
    return new AutoValue_Coord.MoshiJsonAdapter(moshi);
  }

  @Json(name = "lon")
  public abstract double lon();

  @Json(name = "lat")
  public abstract double lat();
}
