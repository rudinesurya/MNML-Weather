package com.cookiesmile.mnml_weather.screen.main;

import com.cookiesmile.mnml_weather.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface MainControllerComponent extends
    AndroidInjector<MainController> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<MainController> {

    @Override
    public void seedInstance(MainController instance) {
    }
  }
}