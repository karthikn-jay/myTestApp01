package com.karthiknjay.mytestapp01;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);

        showNotification();
    }

    private void showNotification() {
        try {
            NotificationCompat.Builder nBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setContentTitle("Test app title")
                    .setContentText("Test app content")
                    .setSmallIcon(R.drawable.notification_icon);

            int nId = 101;
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(nId, nBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("myTestApp01", e.getMessage());
        }
    }
}






