package com.cookiesmile.mnml_weather.screen.settings;

import com.cookiesmile.mnml_weather.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface SettingsComponent extends
    AndroidInjector<SettingsController> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<SettingsController> {

    @Override
    public void seedInstance(SettingsController instance) {
    }
  }
}