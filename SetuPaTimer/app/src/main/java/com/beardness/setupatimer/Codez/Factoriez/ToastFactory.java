package com.beardness.setupatimer.Codez.Factoriez;

import android.content.Context;
import android.widget.Toast;

// Factory for Toast
public class ToastFactory {
  
  private ToastFactory(){}
  
  // Simple Toast
  public static void makeToast(Context context, String text) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }
}
