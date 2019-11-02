package com.cookiesmile.mnml_weather.screen.current;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;
import com.cookiesmile.mnml_weather.di.ScreenScope;
import com.jakewharton.rxrelay2.BehaviorRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class CurrentWeatherViewModel {

  private final BehaviorRelay<CurrentWeatherResponse> resultRelay = BehaviorRelay.create();
  private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
  private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

  @Inject
  CurrentWeatherViewModel() {

  }

  Observable<Boolean> loading() {
    return loadingRelay;
  }

  Observable<CurrentWeatherResponse> result() {
    return resultRelay;
  }

  Observable<Integer> error() {
    return errorRelay;
  }

  Consumer<Boolean> loadingUpdated() {
    return loadingRelay;
  }

  Consumer<CurrentWeatherResponse> resultUpdated() {
    errorRelay.accept(-1);
    return resultRelay;
  }

  Consumer<Throwable> onError() {
    return throwable -> {
      Timber.e(throwable, "Error fetching weather data");
      errorRelay.accept(R.string.api_error_fetch_weather);
    };
  }
}
