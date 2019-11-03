package com.cookiesmile.mnml_weather.data.api.response.future.inner;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class City {

  public static JsonAdapter<City> jsonAdapter(Moshi moshi) {
    return new AutoValue_City.MoshiJsonAdapter(moshi);
  }

  @Json(name = "id")
  public abstract long id();

  @Json(name = "name")
  public abstract String name();

  @Json(name = "coord")
  public abstract Coord coord();

  @Json(name = "country")
  public abstract String country();

  @Json(name = "population")
  public abstract long population();

  @Json(name = "timezone")
  public abstract long timezone();

  @Json(name = "sunrise")
  public abstract long sunrise();

  @Json(name = "sunset")
  public abstract long sunset();
}
