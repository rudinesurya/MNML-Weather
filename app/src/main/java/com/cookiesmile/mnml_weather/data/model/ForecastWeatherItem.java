package com.cookiesmile.mnml_weather.data.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ForecastWeatherItem {

  public static ForecastWeatherItem create(long id, long timestamp, double temp_k, String condition,
      String icon) {
    return new AutoValue_ForecastWeatherItem(id, timestamp, temp_k, condition, icon);
  }

  public abstract long id();

  public abstract long timestamp();

  public abstract double temp_k();

  public abstract String condition();

  public abstract String icon();
}
