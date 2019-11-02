package com.cookiesmile.mnml_weather.navigation;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

public interface ScreenNavigator {

  void initWithRouter(Router router, Controller rootScreen);

  boolean pop();

  void clear();
}
