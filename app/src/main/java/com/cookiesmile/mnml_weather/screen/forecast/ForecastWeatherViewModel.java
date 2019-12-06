package com.cookiesmile.mnml_weather.screen.forecast;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.api.response.ForecastWeatherResponse;
import com.cookiesmile.mnml_weather.di.ScreenScope;
import com.jakewharton.rxrelay2.BehaviorRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class ForecastWeatherViewModel {

  private final BehaviorRelay<ForecastWeatherResponse> resultRelay = BehaviorRelay.create();
  private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
  private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

  @Inject
  ForecastWeatherViewModel() {

  }

  Observable<Boolean> loading() {
    return loadingRelay;
  }

  Observable<ForecastWeatherResponse> result() {
    return resultRelay;
  }

  Observable<Integer> error() {
    return errorRelay;
  }

  Consumer<Boolean> loadingUpdated() {
    return loadingRelay;
  }

  Consumer<ForecastWeatherResponse> resultUpdated() {
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
