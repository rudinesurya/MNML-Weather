package com.cookiesmile.mnml_weather.screen.forecast.utils;

import androidx.recyclerview.widget.DiffUtil;

import com.cookiesmile.mnml_weather.data.model.ForecastWeatherItem;

import java.util.List;

public class MyDiffCallback extends DiffUtil.Callback {

  private final List<ForecastWeatherItem> oldList;
  private final List<ForecastWeatherItem> newList;

  public MyDiffCallback(List<ForecastWeatherItem> oldList, List<ForecastWeatherItem> newList) {
    this.oldList = oldList;
    this.newList = newList;
  }

  @Override
  public int getOldListSize() {
    return oldList.size();
  }

  @Override
  public int getNewListSize() {
    return newList.size();
  }

  @Override
  public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
    return oldList.get(oldItemPosition).id() == newList.get(newItemPosition).id();
  }

  @Override
  public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
    return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
  }
}