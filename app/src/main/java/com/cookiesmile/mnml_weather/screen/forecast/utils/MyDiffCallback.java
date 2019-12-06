package com.cookiesmile.mnml_weather.screen.forecast.utils;

import androidx.recyclerview.widget.DiffUtil;

import com.cookiesmile.mnml_weather.data.model.ForecastWeather;

import java.util.List;

public class MyDiffCallback extends DiffUtil.Callback {

  private final List<ForecastWeather> oldList;
  private final List<ForecastWeather> newList;

  public MyDiffCallback(List<ForecastWeather> oldList, List<ForecastWeather> newList) {
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
    return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
  }

  @Override
  public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
    return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
  }
}