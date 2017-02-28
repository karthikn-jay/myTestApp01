package com.karthiknjay.mytestapp01.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by karthik on 28-02-2017.
 */

public class HelperNextService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action= (String) intent.getExtras().get("DO");
        Log.d("myTestApp01", "in service:: " + action);
        if(action.equals("Next")){
            Log.d("myTest", "in next");

            // call vid stop service
        }

        return flags;
    }
}
