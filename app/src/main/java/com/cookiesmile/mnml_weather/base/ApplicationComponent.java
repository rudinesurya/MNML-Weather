package com.cookiesmile.mnml_weather.base;

import com.cookiesmile.mnml_weather.data.api.WeatherApiServiceModule;
import com.cookiesmile.mnml_weather.data.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class,
    ActivityBindingModule.class,
    ServiceModule.class,
    WeatherApiServiceModule.class,
})
public interface ApplicationComponent {

  void inject(MyApplication myApplication);
}
