package com.cookiesmile.mnml_weather.screen.city_list.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cookiesmile.mnml_weather.R;
import com.cookiesmile.mnml_weather.data.model.SavedCity;
import com.cookiesmile.mnml_weather.screen.city_list.utils.MyListAdapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyListAdapter extends RecyclerView.Adapter<ViewHolder> {

  private final ItemClickListener listener;
  private final List<SavedCity> data = new ArrayList<>();

  public MyListAdapter(ItemClickListener listener) {
    this.listener = listener;
    setHasStableIds(true);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater
        .from(parent.getContext()).inflate(R.layout.item_saved_city, parent, false);
    return new ViewHolder(itemView, listener);
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
    return data.get(position).hashCode();
  }

  public void setData(List<SavedCity> newData) {
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

  public interface ItemClickListener {

    void onItemClickListener(SavedCity item);

    void onDeleteItemClickListener(SavedCity item);
  }

  static final class ViewHolder extends
      RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {

    Context context;
    @BindView(R.id.tv_city)
    TextView cityText;
    @BindView(R.id.btn_menu)
    ImageButton menuBtn;

    private SavedCity city;
    private ItemClickListener listener;

    ViewHolder(@NonNull View itemView, ItemClickListener listener) {
      super(itemView);
      context = itemView.getContext();
      ButterKnife.bind(this, itemView);

      this.listener = listener;

      itemView.setOnClickListener(v -> {
        if (city != null) {
          listener.onItemClickListener(city);
        }
      });

      menuBtn.setOnClickListener(v -> {
        if (city != null) {
          showPopupMenu(menuBtn);
        }
      });
    }

    private void showPopupMenu(View view) {
      // inflate menu
      PopupMenu popup = new PopupMenu(context, view);
      MenuInflater inflater = popup.getMenuInflater();
      inflater.inflate(R.menu.popup_menu, popup.getMenu());
      popup.setOnMenuItemClickListener(this);
      popup.show();
    }

    void bind(SavedCity city) {
      this.city = city;
      cityText.setText(city.getCity());
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
      switch (item.getItemId()) {
        case R.id.delete:
          listener.onDeleteItemClickListener(city);
          return true;
      }
      return false;
    }
  }
}
