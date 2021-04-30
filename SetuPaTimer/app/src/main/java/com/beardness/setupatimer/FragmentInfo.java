package com.beardness.setupatimer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.beardness.setupatimer.Codez.Factoriez.ListenerFactory;

public class FragmentInfo extends Fragment {
  
  public static final String URL_SOURCE = "https://github.com/andybeardness/Android-SetuPaTimer";
  public static final String URL_INSTAGRAM = "https://www.instagram.com/beardness.andy/";
  public static final String URL_TELEGRAM = "https://t.me/beardness_andy";
  
  public static final String INSTAGRAM_PACKAGE = "com.instagram.android";
  public static final String TELEGRAM_PACKAGE = "org.telegram.messenger";
  
  View view;
  
  ImageButton source;
  ImageButton instagram;
  ImageButton telegram;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    
    view =  inflater.inflate(R.layout.fragment_info, container, false);
    
    source = (ImageButton) view.findViewById(R.id.info_source);
    source.setOnClickListener(ListenerFactory.getSourceCodeListener(view.getContext()));
    
    instagram = (ImageButton) view.findViewById(R.id.info_instagram);
    instagram.setOnClickListener(ListenerFactory.getInstagramListener(view.getContext()));
    
    telegram = (ImageButton) view.findViewById(R.id.info_telegram);
    telegram.setOnClickListener(ListenerFactory.getTelegramListener(view.getContext()));
    
    return view;
  }
}