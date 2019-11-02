package com.cookiesmile.mnml_weather.base;

import com.cookiesmile.mnml_weather.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class,
    ActivityBindingModule.class,
    ServiceModule.class,
})
public interface ApplicationComponent {

  void inject(MyApplication myApplication);
}
