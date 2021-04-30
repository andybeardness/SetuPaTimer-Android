package com.beardness.setupatimer.Codez.Factoriez;

import com.beardness.setupatimer.Codez.Helperz.RecyclerJokesAdapter;

// Factory adapters
public class AdapterFactory {
  
  private AdapterFactory() {}
  
  // For RecyclerView
  public static RecyclerJokesAdapter getJokesListAdapter(String type) {
    return new RecyclerJokesAdapter(type);
  }
  
}

