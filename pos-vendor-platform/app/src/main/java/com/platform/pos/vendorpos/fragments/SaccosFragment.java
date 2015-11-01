package com.platform.pos.vendorpos.fragments;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.platform.pos.vendorpos.R;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SaccosFragment extends Fragment {

  //@Bind(R.id.login_btn)
  //Button loginButton;

  public SaccosFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.saccos_fragment, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
    AppCompatActivity activity = (AppCompatActivity) getActivity();
    toolbar.inflateMenu(R.menu.menu_main);
    TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
    mTitle.setText("Saccos");
    activity.setSupportActionBar(toolbar);
    activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    activity.getSupportActionBar().setHomeButtonEnabled(true);
    activity.getSupportActionBar().setTitle(null);

    final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
    activity.getSupportActionBar().setHomeAsUpIndicator(upArrow);

    /*loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Create the transaction
        FragmentTransaction mainActivity = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace the content of the container
        mainActivity.replace(R.id.container, new MainActivityFragment());
        // Append this transaction to the backstack
        mainActivity.addToBackStack("Main Activity Fragment");
        // Commit the changes
        mainActivity.commit();
      }
    });*/
  }
}
