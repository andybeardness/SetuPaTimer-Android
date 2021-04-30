package com.beardness.setupatimer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.beardness.setupatimer.Codez.Databasez.JokeDB;
//import com.beardness.setupatimer.Codez.Factoriez.CursorFactory;
import com.beardness.setupatimer.Codez.Factoriez.ListenerFactory;
import com.beardness.setupatimer.Codez.Helperz.RecyclerJokesAdapter;

public class FragmentChoosenJoke extends Fragment {
  
  public static final String BUNDLE_JOKE_ID = "bundle_joke_id";
  public static final String BUNDLE_JOKE_POSITION = "bundle_joke_position";
  
  private RecyclerJokesAdapter adapter;
  private View view;
  private Bundle bundle;
  
  public TextView jokeText;
  public ImageButton makeFavorite;
  public ImageButton sendPunchline;
  
  public int itemID;
  public int position;
  public String setUp;
  public String punchline;
  public int isFavorite;
  
  public FragmentChoosenJoke(RecyclerJokesAdapter adapter) {
    this.adapter = adapter;
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
    
    view = inflater.inflate(R.layout.fragment_choosen_joke, container, false);
    
    bundle = this.getArguments();
    itemID = bundle != null ? bundle.getInt(BUNDLE_JOKE_ID) : 1;
    position = bundle != null ? bundle.getInt(BUNDLE_JOKE_POSITION) : 0;
    
    Log.d("ITEM_ID", "" + itemID);
    Log.d("POSITION", "" + position);
    
    JokeDB.cursor().moveToPosition(position);
  
    setUp = JokeDB.cursor().getString(JokeDB.cursor().getColumnIndex(JokeDB.COL_SET_UP));
    punchline = JokeDB.cursor().getString(JokeDB.cursor().getColumnIndex(JokeDB.COL_PUNCHLINE));
    isFavorite = JokeDB.cursor().getInt(JokeDB.cursor().getColumnIndex(JokeDB.COL_IS_FAVORITE));
  
    jokeText = (TextView) view.findViewById(R.id.joke_set_up);
    jokeText.setText(setUp);
    
    sendPunchline = (ImageButton) view.findViewById(R.id.send_punchline);
    sendPunchline.setOnClickListener(ListenerFactory.getSendPunchlineListener(this, adapter, JokeDB.idToPos(itemID)));
    
    makeFavorite = (ImageButton) view.findViewById(R.id.make_favorite);
    makeFavorite.setOnClickListener(ListenerFactory.getMakeFavoriteListener(this, adapter,  JokeDB.idToPos(itemID)));
  
    if (isFavorite == 1) {
      makeFavorite.setImageResource(R.drawable.ic_favorite_true);
    }
    
    return view;
  }
  
  public int getIsFavorite() {
    return isFavorite;
  }
  
  public void reverseIsFavorite() {
    isFavorite = isFavorite == 0 ? 1 : 0;
  }
}