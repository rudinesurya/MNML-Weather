package com.cookiesmile.mnml_weather.model.current.helper;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Main {

  public static JsonAdapter<Main> jsonAdapter(Moshi moshi) {
    return new AutoValue_Main.MoshiJsonAdapter(moshi);
  }

  @Json(name = "temp")
  public abstract double temp();

  @Json(name = "pressure")
  public abstract long pressure();

  @Json(name = "humidity")
  public abstract long humidity();

  @Json(name = "temp_min")
  public abstract double tempMin();

  @Json(name = "temp_max")
  public abstract double tempMax();
}
