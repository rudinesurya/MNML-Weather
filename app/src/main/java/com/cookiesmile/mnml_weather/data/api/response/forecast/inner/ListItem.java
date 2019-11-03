package com.cookiesmile.mnml_weather.data.api.response.forecast.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class ListItem {

  public static JsonAdapter<ListItem> jsonAdapter(Moshi moshi) {
    return new AutoValue_ListItem.MoshiJsonAdapter(moshi);
  }

  @Json(name = "dt")
  public abstract long dt();

  @Json(name = "main")
  public abstract Main main();

  @Json(name = "weather")
  public abstract List<Weather> weather();

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
