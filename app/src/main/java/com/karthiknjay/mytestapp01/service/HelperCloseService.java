package com.karthiknjay.mytestapp01.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

import com.karthiknjay.mytestapp01.Utils;

/**
 * Created by karthik on 28-02-2017.
 */

public class HelperCloseService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action= (String) intent.getExtras().get("DO");
        Log.d("myTestApp01", "in service2 : " + action);
        if(action.equals("Close")){
            Log.d("myTest", "in close2");
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancel(Utils.NOTIFICATION_ID); // to hide notification

            //System.exit(0);
        }

        return flags;
    }
}
