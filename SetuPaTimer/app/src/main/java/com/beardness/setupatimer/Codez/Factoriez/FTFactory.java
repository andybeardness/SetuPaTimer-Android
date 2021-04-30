package com.beardness.setupatimer.Codez.Factoriez;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.beardness.setupatimer.FragmentAppTitle;
import com.beardness.setupatimer.FragmentInfo;
import com.beardness.setupatimer.FragmentJokesList;
import com.beardness.setupatimer.R;

public class FTFactory {
  
  private FTFactory(){}
  
  public static void setAppTitle(FragmentManager manager) {
    FTFactory.replaceFragment(
            manager,
            R.id.joke_choosen,
            new FragmentAppTitle());
  }
  
  public static void setAppTitle(FragmentManager manager, String type) {
    FTFactory.replaceFragment(
            manager,
            R.id.joke_choosen,
            new FragmentAppTitle(type));
  }
  public static void setJoke(FragmentManager manager, Fragment joke) {
    FTFactory.replaceFragmentWithoutBackStack(
            manager,
            R.id.joke_choosen,
            joke);
  }
  
  public static void setJokesList(FragmentManager manager, String type) {
    FTFactory.replaceFragment(
            manager,
            R.id.jokes_list,
            new FragmentJokesList(type));
  }
  
  public static void setInfoContent(FragmentManager manager) {
    FTFactory.replaceFragment(
            manager,
            R.id.jokes_list,
            new FragmentInfo());
  }
  
  
  private static void replaceFragment(FragmentManager fragmentManager,
                                     int resFrameID,
                                     Fragment fragment) {
    fragmentManager
      .beginTransaction()
      .replace(resFrameID, fragment, null)
      .commit();
  }
  
  private static void replaceFragmentWithoutBackStack(FragmentManager fragmentManager,
                                                     int resFrameID,
                                                     Fragment fragment) {
    fragmentManager
      .beginTransaction()
      .replace(resFrameID, fragment)
      .addToBackStack(null)
      .commit();
  }
  
}
