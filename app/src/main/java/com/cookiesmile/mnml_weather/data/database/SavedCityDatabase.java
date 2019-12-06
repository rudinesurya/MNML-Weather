package com.cookiesmile.mnml_weather.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cookiesmile.mnml_weather.data.model.SavedCity;

@Database(entities = SavedCity.class, version = 1)
public abstract class SavedCityDatabase extends RoomDatabase {

  public abstract SavedCityDao savedCityDao();
}
