package com.cookiesmile.mnml_weather.screen.city_list;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.base.BaseController;
import com.cookiesmile.mnml_weather.navigation.ScreenNavigation;

import javax.inject.Inject;

import butterknife.BindView;

public class CityListController extends BaseController {

  @Inject
  CityListViewModel viewModel;
  @Inject
  CityListPresenter presenter;
  @Inject
  ScreenNavigation screenNavigation;

  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.loading_indicator)
  View loadingView;
  @BindView(R.id.tv_error)
  TextView errorText;
  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;

  @Override
  protected int layoutRes() {
    return R.layout.screen_city_list;
  }

  @Override
  protected void onViewBound(View view) {
    toolbar.setNavigationIcon(R.drawable.ic_back);
    toolbar.setNavigationOnClickListener(v -> screenNavigation.pop());

    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//    recyclerView.setAdapter(new MyListAdapter());
  }
}
