package com.cookiesmile.mnml_weather.screen.forecast.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.model.ForecastWeather;
import com.cookiesmile.mnml_weather.screen.forecast.utils.MyListAdapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyListAdapter extends RecyclerView.Adapter<ViewHolder> {

  private final List<ForecastWeather> data = new ArrayList<>();

  public MyListAdapter() {
    setHasStableIds(true);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater
        .from(parent.getContext()).inflate(R.layout.item_forecast_weather, parent, false);
    return new ViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(data.get(position));
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  @Override
  public long getItemId(int position) {
    return data.get(position).getId();
  }

  public void setData(List<ForecastWeather> newData) {
    if (newData != null) {
      DiffUtil.DiffResult diffResult = DiffUtil
          .calculateDiff(new MyDiffCallback(data, newData));
      data.clear();
      data.addAll(newData);
      diffResult.dispatchUpdatesTo(this);
    } else {
      data.clear();
      notifyDataSetChanged();
    }
  }

  static final class ViewHolder extends RecyclerView.ViewHolder {

    Context context;
    @BindView(R.id.tv_date)
    TextView dateText;
    @BindView(R.id.tv_temperature)
    TextView temperatureText;
    @BindView(R.id.tv_condition)
    TextView conditionText;
    @BindView(R.id.icon)
    ImageView icon;

    ViewHolder(@NonNull View itemView) {
      super(itemView);
      context = itemView.getContext();
      ButterKnife.bind(this, itemView);
    }

    void bind(ForecastWeather weather) {
      dateText.setText(weather.getDate());
      double temp = KelvinToCelsius(weather.getTemp());
      String tempString = String.format("%.1f\u00B0c", temp);
      temperatureText.setText(tempString);
      conditionText.setText(weather.getCondition());

      String iconUrl =
          "https://openweathermap.org/img/wn/" + weather.getIcon() + "@2x.png";
      Glide.with(context).load(iconUrl).into(icon);
    }

    private double KelvinToCelsius(double kelvin) {
      return kelvin - 273.15;
    }
  }
}
