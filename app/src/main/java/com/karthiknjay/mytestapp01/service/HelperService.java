package com.karthiknjay.mytestapp01.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.karthiknjay.mytestapp01.utils.Utils;
import com.karthiknjay.mytestapp01.utils.Constants;

/**
 * Created by karthik on 28-02-2017.
 */

public class HelperService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(intent != null) {
            String action = (String) intent.getExtras().get("DO");
            Log.d(Constants.APP_TITLE, "in helperservice : " + action);
            if (action.equals("Close")) {
                Log.d(Constants.APP_TITLE, "in close");
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancel(Utils.NOTIFICATION_ID); // to hide notification

                //System.exit(0);
            } else if (action.equals("Prev")) {
                Log.d(Constants.APP_TITLE, "in prev");

                // call vid start service
            } else if (action.equals("Next")) {
                Log.d(Constants.APP_TITLE, "in next");

                // call vid stop service
            } else {
                Log.d(Constants.APP_TITLE, "invalid action");
            }
        } else {
            Log.d(Constants.APP_TITLE, "intent is null");
        }

        return flags;
    }

}
