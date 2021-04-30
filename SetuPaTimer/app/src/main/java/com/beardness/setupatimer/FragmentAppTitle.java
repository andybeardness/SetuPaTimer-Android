package com.beardness.setupatimer;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentAppTitle extends Fragment {
  
  public static final String TITLE_TYPE_DEFAULT = "app_title_default";
  public static final String TITLE_TYPE_INFO = "app_title_info";

  private View view;
  private String type;
  
  private ConstraintLayout appTitleBackground;
  private TextView appTitle;
  
  public FragmentAppTitle() {
    this.type = TITLE_TYPE_DEFAULT;
  }
  
  public FragmentAppTitle(String type) {
    this.type = TITLE_TYPE_INFO;
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
    
    view = inflater.inflate(R.layout.fragment_app_title, container, false);
    
    appTitleBackground = (ConstraintLayout) view.findViewById(R.id.app_title_background);
    appTitle = (TextView) view.findViewById(R.id.app_title);
    
    if (type.equals(TITLE_TYPE_INFO)) {
      appTitleBackground.setBackgroundResource(R.drawable.border_filled_purple);
      appTitle.setTextColor(ContextCompat.getColor(view.getContext(), R.color.purple));
    }
    
    return view;
  }
  
}