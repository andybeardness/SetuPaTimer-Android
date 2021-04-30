package com.beardness.setupatimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.beardness.setupatimer.Codez.Databasez.JokeDB;
import com.beardness.setupatimer.Codez.Factoriez.FTFactory;
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
    bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

          case R.id.bottom_bar_btn_all:
            Log.d("BOTTOM_BAR", "ALL");
            FTFactory.setAppTitle(manager);
            FTFactory.setJokesList(manager, JokeDB.CURSOR_TYPE_ALL);
            return true;

          case R.id.bottom_bar_btn_unwatched:
            Log.d("BOTTOM_BAR", "UNWATCHED");
            FTFactory.setAppTitle(manager);
            FTFactory.setJokesList(manager, JokeDB.CURSOR_TYPE_UNWATCHED);
            return true;

          case R.id.bottom_bar_btn_favorite:
            Log.d("BOTTOM_BAR", "FAVORITES");
            FTFactory.setAppTitle(manager);
            FTFactory.setJokesList(manager, JokeDB.CURSOR_TYPE_FAVORITE);
            return true;

          case R.id.bottom_bar_btn_watched:
            Log.d("BOTTOM_BAR", "WATCHED");
            FTFactory.setAppTitle(manager);
            FTFactory.setJokesList(manager, JokeDB.CURSOR_TYPE_WATCHED);
            return true;

          case R.id.bottom_bar_btn_info:
            Log.d("BOTTOM_BAR", "INFO");
            FTFactory.setAppTitle(manager, FragmentAppTitle.TITLE_TYPE_INFO);
            FTFactory.setInfoContent(manager);
            return true;

          default:
            Log.d("BOTTOM_BAR", "DEFAULT");
            FTFactory.setAppTitle(manager);
            FTFactory.setJokesList(manager, JokeDB.CURSOR_TYPE_ALL);
            return false;
        }

      }
    });
    
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
    
    JokeDB.closeAll();
  }
}