package com.platform.pos.vendorpos.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.platform.pos.vendorpos.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

  @Bind(R.id.login_btn)
  Button loginButton;
  
  public LoginFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.login_fragment, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Create the transaction
        FragmentTransaction mainMenuFragment = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace the content of the container
        mainMenuFragment.replace(R.id.container, new MainMenuFragment());
        // Append this transaction to the backstack
        mainMenuFragment.addToBackStack("Main Menu Fragment");
        // Commit the changes
        mainMenuFragment.commit();
      }
    });
  }
}
