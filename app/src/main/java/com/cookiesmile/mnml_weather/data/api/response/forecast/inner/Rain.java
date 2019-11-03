package com.cookiesmile.mnml_weather.data.api.response.forecast.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Rain {

  public static JsonAdapter<Rain> jsonAdapter(Moshi moshi) {
    return new AutoValue_Rain.MoshiJsonAdapter(moshi);
  }

  @Json(name = "3h")
  public abstract double _3h();
}
