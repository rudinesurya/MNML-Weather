package com.cookiesmile.mnml_weather.screen.settings;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;
import com.cookiesmile.mnml_weather.navigation.ScreenNavigation;

import javax.inject.Inject;

import butterknife.BindView;

public class SettingsController extends BaseController {

  @Inject
  ScreenNavigation screenNavigation;

  @BindView(R.id.toolbar)
  Toolbar toolbar;

  @Override
  protected int layoutRes() {
    return R.layout.screen_settings;
  }

  @Override
  protected void onViewBound(View view) {
    toolbar.setTitle("Settings");
    toolbar.setNavigationIcon(R.drawable.ic_back);
    toolbar.setNavigationOnClickListener(v -> screenNavigation.pop());
  }
}