package com.beardness.setupatimer.Codez.Factoriez;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastFactory {
  
  private ToastFactory(){}
  
  public static void makeToast(Context context, String text) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }
}
