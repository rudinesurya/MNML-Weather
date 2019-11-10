package com.cookiesmile.mnml_weather.data.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ForecastWeatherItem {

  public static Builder builder() {
    return new AutoValue_ForecastWeatherItem.Builder();
  }

  public abstract long id();

  public abstract String date();

  public abstract double temp_k();

  public abstract String condition();

  public abstract String icon();

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder id(long value);

    public abstract Builder date(String value);

    public abstract Builder temp_k(double value);

    public abstract Builder condition(String value);

    public abstract Builder icon(String value);

    public abstract ForecastWeatherItem build();
  }
}
