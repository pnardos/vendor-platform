package com.platform.pos.vendorpos.fragments;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.platform.pos.vendorpos.R;
import com.platform.pos.vendorpos.adapters.MenuItemRecyclerViewAdapter;
import com.platform.pos.vendorpos.data.MenuItemData;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainMenuFragment extends Fragment {



  public MainMenuFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.main_menu_fragment, container, false);
    return view;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
    AppCompatActivity activity = (AppCompatActivity) getActivity();
    toolbar.inflateMenu(R.menu.menu_main);
    TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
    mTitle.setText("Menu");
    activity.setSupportActionBar(toolbar);
    activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    activity.getSupportActionBar().setHomeButtonEnabled(true);
    activity.getSupportActionBar().setTitle(null);

    final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
    activity.getSupportActionBar().setHomeAsUpIndicator(upArrow);

    RecyclerView menuItemRv = (RecyclerView) view.findViewById(R.id.menu_rv);
    MenuItemRecyclerViewAdapter adapter = new MenuItemRecyclerViewAdapter(getActivity(), getMenuItems());

    menuItemRv.setAdapter(adapter);
    final GridLayoutManager manager = new GridLayoutManager(getContext().getApplicationContext(), 2);
    menuItemRv.setLayoutManager(manager);
  }




  private ArrayList<MenuItemData> getMenuItems() {
    ArrayList<MenuItemData> menuItems = new ArrayList<>();
    menuItems.add(new MenuItemData(R.drawable.stack_icon, "Airtime"));
    menuItems.add(new MenuItemData(R.drawable.tokens_icon, "Tokens"));
    menuItems.add(new MenuItemData(R.drawable.phone_icon, "Mobile Money"));
    menuItems.add(new MenuItemData(R.drawable.saccos_icon, "Saccos"));
    menuItems.add(new MenuItemData(R.drawable.reports_icon, "Reports"));
    menuItems.add(new MenuItemData(R.drawable.profile_icon, "Profile"));
    return menuItems;
  }
}
