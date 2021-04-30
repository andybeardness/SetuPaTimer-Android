package com.beardness.setupatimer.Codez.Factoriez;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.core.app.NotificationCompat;

import com.beardness.setupatimer.R;

import java.util.Random;

// Factory notifications (doesn't use yet)
public class NotificationFactory {
  
  public static final String NOTIFICATION_CHANEL_ID = "punchline_chanel_id";
  public static final String NOTIFICATION_CHANEL_NAME = "punchline_chanel_name";
  public static final int NOTIFICATION_ID = 1488;
  
  private static final Random random = new Random();
  
  private NotificationFactory(){}
  
  // Send notification
  public static void sendDelayedNotification(Context context, String setUp, String punchline) {
    long delay = (long) (random.nextInt(2000) + 1000);
    Handler handler = new Handler(Looper.myLooper());
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
  
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
          NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANEL_ID, NOTIFICATION_CHANEL_NAME, NotificationManager.IMPORTANCE_HIGH);
          notificationManager.createNotificationChannel(notificationChannel);
        }
  
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANEL_ID)
          .setSmallIcon(R.drawable.ic_send_punchline)
          .setContentText(punchline)
          .setStyle(new NotificationCompat.BigTextStyle().bigText(punchline))
          .setPriority(NotificationCompat.PRIORITY_HIGH)
          .setVibrate(new long[]{ 1000 })
          .setCategory(NotificationCompat.CATEGORY_ALARM);
  
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
      }
    }, 0);
  }
}