package com.cookiesmile.mnml_weather.data.utils;

import com.cookiesmile.mnml_weather.data.AutoValueMoshi_AdapterFactory;
import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

@MoshiAdapterFactory
public abstract class AdapterFactory implements JsonAdapter.Factory {

  public static JsonAdapter.Factory create() {
    return new AutoValueMoshi_AdapterFactory();
  }
}