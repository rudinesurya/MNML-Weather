package com.cookiesmile.mnml_weather.screen.city_list;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.cookiesmile.mnml_weather.data.WeatherRepository;
import com.cookiesmile.mnml_weather.data.model.SavedCity;
import com.cookiesmile.mnml_weather.di.ScreenScope;
import com.cookiesmile.mnml_weather.navigation.ScreenNavigation;
import com.cookiesmile.mnml_weather.screen.city_list.utils.MyListAdapter;

import javax.inject.Inject;

@ScreenScope
public class CityListPresenter implements MyListAdapter.ItemClickListener {

  private final WeatherRepository repository;
  private final ScreenNavigation screenNavigation;
  @Inject
  Context context;

  @Inject
  CityListPresenter(CityListViewModel viewModel, WeatherRepository repository,
      ScreenNavigation screenNavigation) {
    this.repository = repository;
    this.screenNavigation = screenNavigation;
    repository.getAllSavedCity()
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(viewModel.resultUpdated(), viewModel.onError());
  }


  @Override
  public void onItemClickListener(SavedCity city) {
    Toast.makeText(context, "clicked item: " + city.getCity(), Toast.LENGTH_SHORT).show();
    SharedPreferences sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("selected_city", city.getCity());
    editor.commit();

    screenNavigation.goToCurrent();
  }

  @Override
  public void onDeleteItemClickListener(SavedCity city) {
    repository.deleteCity(city);
    Toast.makeText(context, "deleted item: " + city.getCity(), Toast.LENGTH_SHORT).show();
  }
}
