package com.cookiesmile.mnml_weather.screen.current;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.data.api.response.current.CurrentWeatherResponse;
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

public class CurrentWeatherPresenterTest {

  @Mock
  WeatherRepository repository;
  @Mock
  CurrentWeatherViewModel viewModel;
  @Mock
  Consumer<Throwable> onErrorConsumer;
  @Mock
  Consumer<CurrentWeatherResponse> onSuccessConsumer;
  @Mock
  Consumer<Boolean> loadingConsumer;

  private CurrentWeatherPresenter presenter;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    when(viewModel.loadingUpdated()).thenReturn(loadingConsumer);
    when(viewModel.onError()).thenReturn(onErrorConsumer);
    when(viewModel.resultUpdated()).thenReturn(onSuccessConsumer);
  }

  @Test
  public void weatherLoaded() throws Exception {
    CurrentWeatherResponse weather = setUpSuccess();
    initializePresenter();

    verify(repository).getCurrentWeather();
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
    presenter = new CurrentWeatherPresenter(viewModel, repository);
  }

  private CurrentWeatherResponse setUpSuccess() {
    CurrentWeatherResponse weather = TestUtils
        .loadJson("mock/current_weather.json", CurrentWeatherResponse.class);

    when(repository.getCurrentWeather()).thenReturn(Single.just(weather));

    return weather;
  }

  private Throwable setUpError() {
    Throwable error = new IOException();
    when(repository.getCurrentWeather()).thenReturn(Single.error(error));

    return error;
  }
}
