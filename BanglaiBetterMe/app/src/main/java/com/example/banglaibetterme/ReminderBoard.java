package com.example.banglaibetterme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBoard extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notifyme")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("পানি পান করুন!")
                .setContentText("আপনার পানি পান করার সময় হয়েছে!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);
        notificationManager.notify(200,builder.build());


    }
}
