package com.cookiesmile.mnml_weather.screen.city_list.utils;

import androidx.recyclerview.widget.DiffUtil;

import com.cookiesmile.mnml_weather.data.model.SavedCity;

import java.util.List;

public class MyDiffCallback extends DiffUtil.Callback {

  private final List<SavedCity> oldList;
  private final List<SavedCity> newList;

  public MyDiffCallback(List<SavedCity> oldList, List<SavedCity> newList) {
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
    return oldList.get(oldItemPosition).getCity() == newList.get(newItemPosition).getCity();
  }

  @Override
  public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
    return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
  }
}