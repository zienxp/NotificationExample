package com.example.notificationexample;

import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

public class RemoteReciver extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_reciver);

        textView = findViewById(R.id.text_display);
        Bundle remoteReply = RemoteInput.getResultsFromIntent(getIntent());

        if (remoteReply != null){
            String message = remoteReply.getCharSequence(MainActivity.TEXT_REPLY).toString();
            textView.setText(message);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);

    }
}
