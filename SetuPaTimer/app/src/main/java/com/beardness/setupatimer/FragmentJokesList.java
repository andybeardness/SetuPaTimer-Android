package com.beardness.setupatimer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beardness.setupatimer.Codez.Databasez.JokeDB;
import com.beardness.setupatimer.Codez.Factoriez.AdapterFactory;

public class FragmentJokesList extends Fragment {
  
  private View view;
  private RecyclerView jokesList;
  private String type;
  
  public FragmentJokesList(String type) {
    this.type = type;
    JokeDB.updateListJokesCursor(type);
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    
    view = inflater.inflate(R.layout.fragment_jokes_list, container, false);
  
    jokesList = view.findViewById(R.id.recycle_joke_list);
    jokesList.setAdapter(AdapterFactory.getJokesListAdapter(type));
    
    return view;
  }
}