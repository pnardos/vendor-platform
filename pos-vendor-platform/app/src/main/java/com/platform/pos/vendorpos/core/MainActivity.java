package com.platform.pos.vendorpos.core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.platform.pos.vendorpos.R;
import com.platform.pos.vendorpos.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentByTag("loginFragment");
    if (fragment == null) {
      FragmentTransaction ft = fm.beginTransaction();
      fragment =new LoginFragment();
      ft.add(R.id.container,fragment,"loginFragment");
      ft.commit();
    }

    // Create the transaction
    //android.support.v4.app.FragmentTransaction login = getSupportFragmentManager().beginTransaction();
    // Replace the content of the container
    //login.replace(R.id.container, new LoginFragment());
    // Append this transaction to the backstack
    //login.addToBackStack("Login Fragment");
    // Commit the changes
    //login.commit();

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    switch(item.getItemId()){
      case android.R.id.home:
        onBackPressed();
    }
    //int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    //if (id == R.id.action_settings) {
    //  return false;
    //}

    return super.onOptionsItemSelected(item);
  }
}
