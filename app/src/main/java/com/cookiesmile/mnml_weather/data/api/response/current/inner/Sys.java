package com.cookiesmile.mnml_weather.data.api.response.current.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Sys {

  public static JsonAdapter<Sys> jsonAdapter(Moshi moshi) {
    return new AutoValue_Sys.MoshiJsonAdapter(moshi);
  }

  @Json(name = "type")
  public abstract long type();

  @Json(name = "id")
  public abstract long id();

  @Json(name = "message")
  public abstract double message();

  @Json(name = "country")
  public abstract String country();

  @Json(name = "sunrise")
  public abstract long sunrise();

  @Json(name = "sunset")
  public abstract long sunset();
}
