package com.beardness.setupatimer.Codez.Factoriez;

import com.beardness.setupatimer.Codez.Helperz.RecyclerJokesAdapter;

public class AdapterFactory {
  
  private AdapterFactory() {}
  
  public static RecyclerJokesAdapter getJokesListAdapter(String type) {
    return new RecyclerJokesAdapter(type);
  }
  
}

