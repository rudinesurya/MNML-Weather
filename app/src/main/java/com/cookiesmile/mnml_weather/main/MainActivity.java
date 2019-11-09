package com.cookiesmile.mnml_weather.main;

import com.bluelinelabs.conductor.Controller;
import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseActivity;
import com.cookiesmile.mnml_weather.screen.main.MainController;

public class MainActivity extends BaseActivity {

  @Override
  protected int layoutRes() {
    return R.layout.activity_main;
  }

  @Override
  protected Controller initialScreen() {
    return new MainController();
  }
}
