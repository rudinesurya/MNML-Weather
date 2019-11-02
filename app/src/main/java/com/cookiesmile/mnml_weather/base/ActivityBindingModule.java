package com.cookiesmile.mnml_weather.base;

import android.app.Activity;

import com.cookiesmile.mnml_weather.di.ActivityKey;
import com.cookiesmile.mnml_weather.main.MainActivity;
import com.cookiesmile.mnml_weather.main.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
    MainActivityComponent.class,
})
public abstract class ActivityBindingModule {

  @Binds
  @IntoMap
  @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(
      MainActivityComponent.Builder builder);
}
