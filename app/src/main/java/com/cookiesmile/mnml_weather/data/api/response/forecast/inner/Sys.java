package com.cookiesmile.mnml_weather.data.api.response.forecast.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Sys {

  public static JsonAdapter<Sys> jsonAdapter(Moshi moshi) {
    return new AutoValue_Sys.MoshiJsonAdapter(moshi);
  }

  @Json(name = "pod")
  public abstract String pod();
}
