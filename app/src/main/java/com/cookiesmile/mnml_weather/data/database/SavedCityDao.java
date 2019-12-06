package com.cookiesmile.mnml_weather.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cookiesmile.mnml_weather.data.model.SavedCity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface SavedCityDao {

  @Query("select * from savedcity")
  Flowable<List<SavedCity>> getAllSavedCity();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void addCity(SavedCity item);

  @Delete
  void deleteCity(SavedCity item);
}
