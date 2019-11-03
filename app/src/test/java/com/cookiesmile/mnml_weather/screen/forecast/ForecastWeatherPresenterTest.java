package com.cookiesmile.mnml_weather.screen.forecast;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.data.api.response.forecast.ForecastWeatherResponse;
import com.cookiesmile.mnml_weather.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class ForecastWeatherPresenterTest {

  @Mock
  WeatherRepository repository;
  @Mock
  ForecastWeatherViewModel viewModel;
  @Mock
  Consumer<Throwable> onErrorConsumer;
  @Mock
  Consumer<ForecastWeatherResponse> onSuccessConsumer;
  @Mock
  Consumer<Boolean> loadingConsumer;

  private ForecastWeatherPresenter presenter;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    when(viewModel.loadingUpdated()).thenReturn(loadingConsumer);
    when(viewModel.onError()).thenReturn(onErrorConsumer);
    when(viewModel.resultUpdated()).thenReturn(onSuccessConsumer);
  }

  @Test
  public void weatherLoaded() throws Exception {
    ForecastWeatherResponse weather = setUpSuccess();
    initializePresenter();

    verify(repository).getForecastWeather();
    verify(onSuccessConsumer).accept(weather);
    verifyZeroInteractions(onErrorConsumer);
  }

  @Test
  public void weatherLoadedError() throws Exception {
    Throwable error = setUpError();
    initializePresenter();

    verify(onErrorConsumer).accept(error);
    verifyZeroInteractions(onSuccessConsumer);
  }

  @Test
  public void loadingSuccess() throws Exception {
    setUpSuccess();
    initializePresenter();

    InOrder inOrder = Mockito.inOrder(loadingConsumer);
    inOrder.verify(loadingConsumer).accept(true);
    inOrder.verify(loadingConsumer).accept(false);
  }

  @Test
  public void loadingError() throws Exception {
    //noinspection ThrowableNotThrown
    setUpError();
    initializePresenter();

    InOrder inOrder = Mockito.inOrder(loadingConsumer);
    inOrder.verify(loadingConsumer).accept(true);
    inOrder.verify(loadingConsumer).accept(false);
  }

  //  Helper methods
  private void initializePresenter() {
    presenter = new ForecastWeatherPresenter(viewModel, repository);
  }

  private ForecastWeatherResponse setUpSuccess() {
    ForecastWeatherResponse weather = TestUtils
        .loadJson("mock/forecast_weather.json", ForecastWeatherResponse.class);

    when(repository.getForecastWeather()).thenReturn(Single.just(weather));

    return weather;
  }

  private Throwable setUpError() {
    Throwable error = new IOException();
    when(repository.getForecastWeather()).thenReturn(Single.error(error));

    return error;
  }
}
