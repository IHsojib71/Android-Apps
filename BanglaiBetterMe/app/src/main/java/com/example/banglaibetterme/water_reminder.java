package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class water_reminder extends AppCompatActivity {
    private Button button;
    private EditText Rtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder);
        button=findViewById(R.id.reminderbutton);
        Rtime=findViewById(R.id.reminderTime);
        creatNotificationChannel();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(water_reminder.this, ReminderBoard.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(water_reminder.this, 0, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                String gettime=Rtime.getText().toString();
                if(gettime.isEmpty())
                {
                    Rtime.setError("সময় দিন!");
                    Rtime.requestFocus();
                    return;
                }
                else{
                    Toast.makeText(water_reminder.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
                }
                long minutes=Long.parseLong(gettime);

                long timeAtButtonClick = System.currentTimeMillis();


                long tenSecondInMillis = 1000 * minutes * 60;
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSecondInMillis, pendingIntent);

            }
        });
    }

    private void creatNotificationChannel(){
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            CharSequence name ="WaterReminderChannel";
            String description = "Channel for Water Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyme",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}