package com.example.administrator.ljjdemo;

import android.app.Activity;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationAcitivity extends AppCompatActivity {

    private NotificationManager mManager;
    private int index = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_acitivity);
        //初始化通知栏管理者
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        index = 2;
        mManager.cancelAll();
    }
}