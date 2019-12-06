package com.cookiesmile.mnml_weather.screen.city_list;

import com.cookiesmile.mnml_weather.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface CityListComponent extends
    AndroidInjector<CityListController> {

  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<CityListController> {

    @Override
    public void seedInstance(CityListController instance) {
    }
  }
}