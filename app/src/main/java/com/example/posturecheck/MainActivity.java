package com.example.posturecheck;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.intervals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        final Button startBtn = findViewById(R.id.start_btn);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPostureChecking(spinner);
                Log.i("button", "button pressed");
            }
        });
    }


    void startPostureChecking(final Spinner spinner) {
        long intervalLength = 0;
        String interval = spinner.getSelectedItem().toString();
        switch (interval) {
            case "15 Minutes":
                intervalLength = 900000;
                break;
            case "30 Minutes":
                intervalLength = 1800000;
                break;
            case "1 Hour":
                intervalLength = 3600000;
                break;
        }


        CountDownTimer countDownTimer = new CountDownTimer(intervalLength, 1000) {
            @Override
            public void onTick(long l) {
                // Log.i("timer", Long.toString(l));
            }

            @Override
            public void onFinish() {
                /*TODO Add variety of random different messages*/
                showNotification("Posture Check!", "Roll your shoulders back and sit straight up!");
                startPostureChecking(spinner);
            }
        };

        countDownTimer.start();
        /*TODO Figure out how to only have one timer going at once*/
    }


    void showNotification(String title, String message) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("YOUR_CHANNEL_ID",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext(), "YOUR_CHANNEL_ID")
                        .setSmallIcon(R.drawable.ic_action_name) // notification icon
                        .setContentTitle(title) // title for notification
                        .setContentText(message)// message for notification
                        .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
