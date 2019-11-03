package com.cookiesmile.mnml_weather.screen.current;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;
import com.cookiesmile.mnml_weather.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CurrentWeatherViewModelTest {

  private CurrentWeatherViewModel viewModel;

  @Before
  public void setUp() throws Exception {
    viewModel = new CurrentWeatherViewModel();
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
    CurrentWeatherResponse weather = TestUtils
        .loadJson("mock/current_weather.json", CurrentWeatherResponse.class);
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
