package com.karthiknjay.mytestapp01.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.karthiknjay.mytestapp01.Utils;

/**
 * Created by karthik on 28-02-2017.
 */

public class HelperPrevService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action= (String) intent.getExtras().get("DO");
        Log.d("myTestApp01", "in service:: " + action);
        if(action.equals("Prev")){
            Log.d("myTest", "in prev");

            // call vid start service
        }

        return flags;
    }
}
