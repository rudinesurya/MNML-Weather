package com.cookiesmile.mnml_weather.screen.city_list;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.model.SavedCity;
import com.cookiesmile.mnml_weather.di.ScreenScope;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class CityListViewModel {

  private final BehaviorRelay<List<SavedCity>> resultRelay = BehaviorRelay.create();
  private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
  private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

  @Inject
  CityListViewModel() {
  }

  Observable<Boolean> loading() {
    return loadingRelay;
  }

  Observable<List<SavedCity>> result() {
    return resultRelay;
  }

  Observable<Integer> error() {
    return errorRelay;
  }

  Consumer<Boolean> loadingUpdated() {
    return loadingRelay;
  }

  Consumer<List<SavedCity>> resultUpdated() {
    errorRelay.accept(-1);
    return resultRelay;
  }

  Consumer<Throwable> onError() {
    return throwable -> {
      Timber.e(throwable, "Error fetching city list");
      errorRelay.accept(R.string.api_error_fetch_city_list);
    };
  }
}
