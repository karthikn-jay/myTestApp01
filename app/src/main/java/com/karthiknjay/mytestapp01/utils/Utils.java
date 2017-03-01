package com.karthiknjay.mytestapp01.utils;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.karthiknjay.mytestapp01.R;
import com.karthiknjay.mytestapp01.service.HelperService;

/**
 * Created by karthik on 28-02-2017.
 */

public final class Utils {

    public static final int NOTIFICATION_ID = 101;

    public static void showNotification(Context context, Activity activity) {
        try {

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_layout);

            Intent intentServicePrev = new Intent(activity, HelperService.class);
            intentServicePrev.putExtra("DO", "Prev");
            intentServicePrev.setAction("notif_prev");
            PendingIntent prevPendingIntent = PendingIntent.getService(context, 0, intentServicePrev,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            Intent intentServiceNext = new Intent(activity, HelperService.class);
            intentServiceNext.putExtra("DO", "Next");
            intentServiceNext.setAction("notif_next");
            PendingIntent nextPendingIntent = PendingIntent.getService(context, 0, intentServiceNext,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            Intent intentServiceClose = new Intent(activity, HelperService.class);
            intentServiceClose.putExtra("DO", "Close");
            intentServiceClose.setAction("notif_close");
            PendingIntent closePendingIntent = PendingIntent.getService(context, 0, intentServiceClose,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder nBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(activity)
                    .setContentTitle("Test app title")
                    .setContentText("Test app content")
                    .setSmallIcon(R.drawable.ic_free_breakfast_white_24dp) // mandatory
                    .setOngoing(true) // disable swipe hide
                    .addAction(R.drawable.ic_free_breakfast_white_24dp,"Prev", prevPendingIntent)
                    .addAction(R.drawable.ic_free_breakfast_white_24dp, "Next", nextPendingIntent)
                    .addAction(R.drawable.ic_free_breakfast_white_24dp, "Close", closePendingIntent);
            //.setContent(remoteViews);

            NotificationManager notificationManager = (NotificationManager) activity.getSystemService(activity.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFICATION_ID, nBuilder.build());

            //notificationManager.cancel(NOTIFICATION_ID); // to hide notification
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("myTestApp01", e.getMessage());
        }
    }
    
}
