package com.cookiesmile.mnml_weather.data.api.response.current.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Weather {

  public static JsonAdapter<Weather> jsonAdapter(Moshi moshi) {
    return new AutoValue_Weather.MoshiJsonAdapter(moshi);
  }

  @Json(name = "id")
  public abstract long id();

  @Json(name = "main")
  public abstract String main();

  @Json(name = "description")
  public abstract String description();

  @Json(name = "icon")
  public abstract String icon();
}
