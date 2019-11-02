package com.cookiesmile.mnml_weather.base;

import android.app.Application;

import com.cookiesmile.mnml_weather.BuildConfig;
import com.cookiesmile.mnml_weather.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class MyApplication extends Application {

  protected ApplicationComponent component;
  @Inject
  ActivityInjector activityInjector;

  @Override
  public void onCreate() {
    super.onCreate();

    component = initComponent();
    component.inject(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugTree());
    }
  }

  protected ApplicationComponent initComponent() {
    return DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ActivityInjector getActivityInjector() {
    return activityInjector;
  }
}
