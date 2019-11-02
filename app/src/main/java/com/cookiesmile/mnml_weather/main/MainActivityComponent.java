package com.cookiesmile.mnml_weather.main;

import com.cookiesmile.mnml_weather.di.ActivityScope;
import com.cookiesmile.mnml_weather.navigation.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
    MainScreenBindingModule.class,
    NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    @Override
    public void seedInstance(MainActivity instance) {
    }
  }
}
