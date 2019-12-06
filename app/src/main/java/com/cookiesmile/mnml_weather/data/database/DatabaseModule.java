package com.cookiesmile.mnml_weather.data.database;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DatabaseModule {

  @Provides
  @Singleton
  static SavedCityDatabase provideSavedCityDatabase(Context context) {
    return Room.databaseBuilder(context, SavedCityDatabase.class, "saved-city-database")
        .build();
  }

  @Provides
  @Singleton
  static SavedCityDao provideSavedCityDao(SavedCityDatabase database) {
    return database.savedCityDao();
  }
}
