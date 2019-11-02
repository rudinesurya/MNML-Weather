package com.cookiesmile.mnml_weather.navigation;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

  @Binds
  abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
