package com.beardness.setupatimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.beardness.setupatimer.Codez.Databasez.JokeDB;
import com.beardness.setupatimer.Codez.Factoriez.FTFactory;
import com.beardness.setupatimer.Codez.Factoriez.ListenerFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityMain extends AppCompatActivity {
  
  private BottomNavigationView bottomNavigation;
  
  FragmentManager manager;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    manager = getSupportFragmentManager();
    
    JokeDB.updateDB(this);
  
    FTFactory.setAppTitle(manager);
    FTFactory.setJokesList(manager, JokeDB.CURSOR_TYPE_ALL);
  
    bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    bottomNavigation.setOnNavigationItemSelectedListener(ListenerFactory.getBottomNavigationListener(manager));
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
    JokeDB.closeAll();
  }
}