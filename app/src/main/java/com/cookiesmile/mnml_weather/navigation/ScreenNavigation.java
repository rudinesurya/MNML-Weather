package com.cookiesmile.mnml_weather.navigation;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.cookiesmile.mnml_weather.di.ActivityScope;
import com.cookiesmile.mnml_weather.screen.forecast.ForecastWeatherController;
import com.cookiesmile.mnml_weather.screen.settings.SettingsController;

import javax.inject.Inject;

@ActivityScope
public class ScreenNavigation {

  private Router router;

  @Inject
  ScreenNavigation() {

  }

  public void initWithRouter(Router router, Controller rootScreen) {
    this.router = router;
    if (!router.hasRootController()) {
      router.setRoot(RouterTransaction.with(rootScreen));
    }
  }

  public boolean pop() {
    return router != null && router.handleBack();
  }

  public void goToForecast(long id) {
    if (router != null) {
      router.pushController(RouterTransaction.with(
          ForecastWeatherController.newInstance(id))
          .pushChangeHandler(new FadeChangeHandler())
          .popChangeHandler(new FadeChangeHandler()));
    }
  }

  public void goToSettings() {
    if (router != null) {
      router.pushController(RouterTransaction.with(
          new SettingsController())
          .pushChangeHandler(new FadeChangeHandler())
          .popChangeHandler(new FadeChangeHandler()));
    }
  }

  public void clear() {
    router = null;
  }
}