package com.cookiesmile.mnml_weather.screen.forecast;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;
import com.cookiesmile.mnml_weather.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import timber.log.Timber;

public class ForecastWeatherViewModelTest {

  private ForecastWeatherViewModel viewModel;

  @Before
  public void setUp() throws Exception {
    viewModel = new ForecastWeatherViewModel();
  }

  @Test
  public void loading() throws Exception {
    viewModel.loadingUpdated().accept(true);

    viewModel.loading().test().assertValue(true);
  }

  @Test
  public void loading_false() throws Exception {
    viewModel.loadingUpdated().accept(false);

    viewModel.loading().test().assertValue(false);
  }

  @Test
  public void result() throws Exception {
    ForecastWeatherResponse weather = TestUtils
        .loadJson("mock/forecast_weather.json", ForecastWeatherResponse.class);

    Timber.d(weather.toString());

    viewModel.resultUpdated().accept(weather);

    viewModel.result().test().assertValue(weather);
    viewModel.error().test().assertValue(-1);
  }

  @Test
  public void error() throws Exception {
    viewModel.onError().accept(new IOException());

    viewModel.error().test().assertValue(R.string.api_error_fetch_weather);
  }
}
