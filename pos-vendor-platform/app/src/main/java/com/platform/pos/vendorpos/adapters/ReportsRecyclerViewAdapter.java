package com.platform.pos.vendorpos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platform.pos.vendorpos.R;
import com.platform.pos.vendorpos.data.MenuItemData;
import com.platform.pos.vendorpos.util.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by pnardos on 10/3/15.
 */
public class ReportsRecyclerViewAdapter extends RecyclerView.Adapter<ReportsRecyclerViewAdapter.ViewHolder> {


  private ArrayList<MenuItemData> menuItemDatas;
  private Context context;

  public ReportsRecyclerViewAdapter(Context context, ArrayList<MenuItemData> menuItemDatas) {
    this.menuItemDatas = menuItemDatas;
    this.context = context;
  }

  @Override
  public ReportsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.menu_card_item, parent, false);
    return new ReportsRecyclerViewAdapter.ViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(ReportsRecyclerViewAdapter.ViewHolder holder, int position) {
    MenuItemData menuItemData = menuItemDatas.get(position);

    holder.menu_icon.setImageResource(menuItemData.menuIcon);
    holder.menu_name.setText(menuItemData.menuName);

    holder.setClickListener(new ItemClickListener() {
      @Override
      public void onClick(View view, int position, boolean isLongClick) {

      }
    });
  }

  public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemClickListener clickListener;

    public ImageView menu_icon;
    public TextView menu_name;

    public ViewHolder(View itemView) {

      super(itemView);
      this.menu_icon = (ImageView) itemView.findViewById(R.id.menu_icon);
      this.menu_name = (TextView) itemView.findViewById(R.id.menu_name);

      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      clickListener.onClick(v, getLayoutPosition(), false);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
      this.clickListener = itemClickListener;
    }
  }

  @Override
  public int getItemCount() {
    return menuItemDatas.size();
  }
}
