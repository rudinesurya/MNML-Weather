package com.cookiesmile.mnml_weather.data;

import com.cookiesmile.mnml_weather.data.api.WeatherApiService;
import com.cookiesmile.mnml_weather.data.api.response.CurrentWeatherResponse;
import com.cookiesmile.mnml_weather.data.api.response.ForecastWeatherResponse;
import com.cookiesmile.mnml_weather.data.database.SavedCityDao;
import com.cookiesmile.mnml_weather.data.model.SavedCity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import timber.log.Timber;

@Singleton
public class WeatherRepository {

  private final Provider<WeatherApiService> serviceProvider;
  private final Provider<SavedCityDao> savedCityDaoProvider;
  private final Scheduler scheduler;

  @Inject
  WeatherRepository(Provider<WeatherApiService> serviceProvider,
      Provider<SavedCityDao> savedCityDaoProvider,
      @Named("network_scheduler") Scheduler scheduler) {
    this.serviceProvider = serviceProvider;
    this.savedCityDaoProvider = savedCityDaoProvider;
    this.scheduler = scheduler;
  }

  public Single<CurrentWeatherResponse> getCurrentWeather(String cityName) {
    return serviceProvider.get().getCurrentWeather(cityName).subscribeOn(scheduler);
  }

  public Single<ForecastWeatherResponse> getForecastWeather(long id) {
    return serviceProvider.get().getForecastWeather(id).subscribeOn(scheduler);
  }

  public Single<List<SavedCity>> getAllSavedCity() {
    return savedCityDaoProvider.get().getAllSavedCity().subscribeOn(scheduler);
  }

  public void addCity(SavedCity city) {
    runDbAction(() -> {
      savedCityDaoProvider.get().addCity(city);
    });
  }

  public void deleteCity(SavedCity city) {
    runDbAction(() -> {
      savedCityDaoProvider.get().deleteCity(city);
    });
  }

  private void runDbAction(Action action) {
    Completable.fromAction(action)
        .subscribeOn(scheduler)
        .subscribe(() -> {
        }, throwable -> {
          Timber.e(throwable, "Error performing database action");
        });
  }
}
