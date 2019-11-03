package com.cookiesmile.mnml_weather.data.api.response.future.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class List {

  public static JsonAdapter<List> jsonAdapter(Moshi moshi) {
    return new AutoValue_List.MoshiJsonAdapter(moshi);
  }

  @Json(name = "dt")
  public abstract long dt();

  @Json(name = "main")
  public abstract Main main();

  @Json(name = "weather")
  public abstract java.util.List<Weather> weather();

  @Json(name = "clouds")
  public abstract Clouds clouds();

  @Json(name = "wind")
  public abstract Wind wind();

  @Json(name = "rain")
  public abstract Rain rain();

  @Json(name = "sys")
  public abstract Sys sys();

  @Json(name = "dt_txt")
  public abstract String dtTxt();
}
