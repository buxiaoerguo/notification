package com.example.administrator.ljjdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

/**
 *
 *@作者 ljj
 *
 *@创建时间 2020/7/16 15:09
 *
 * Notification 通知栏 通知消息
 */
public class NotificationUtil extends ContextWrapper {

    private NotificationManager mManager;
    public static final String sID = "channel_1";
    public static final String sName = "channel_name_1";

    public NotificationUtil(Context context) {
        super(context);
    }

    public void sendNotification(String title, String content,int id) {
        LogUtil.e("SDK_INT", Build.VERSION.SDK_INT + "");
        if (Build.VERSION.SDK_INT >= 26) {
            LogUtil.e("SDK_INT1", Build.VERSION.SDK_INT + "");
            createNotificationChannel();
            Notification notification = getNotification_26(title, content).build();
            //意图数组
            Intent[] intents = {new Intent(this, NotificationAcitivity.class)};
            //待处理意图对象
            PendingIntent mIntent;
            mIntent = PendingIntent.getActivities(this, 0, intents, 0);
            notification.contentIntent = mIntent;
            getmManager().notify(id, notification);
        } else {
            LogUtil.e("SDK_INT2", Build.VERSION.SDK_INT + "");
            Notification notification = getNotification_25(title, content).build();
            gotoActivity(notification);
            getmManager().notify(id, notification);
        }
    }

    private void gotoActivity(Notification notification) {
        //意图数组
        Intent[] intents = {new Intent(this, NotificationAcitivity.class)};
//        Intent[] intents = {new Intent(this, NotificationAcitivity.class)};
        //待处理意图对象
        PendingIntent mIntent;
        mIntent = PendingIntent.getActivities(this, 0, intents, 0);
        notification.contentIntent = mIntent;
    }

    private NotificationManager getmManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(sID, sName, NotificationManager.IMPORTANCE_HIGH);
        getmManager().createNotificationChannel(channel);
    }

    public NotificationCompat.Builder getNotification_25(String title, String content) {

        // 以下是展示大图的通知
        android.support.v4.app.NotificationCompat.BigPictureStyle style = new android.support.v4.app.NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("具体内容标题！");
        style.setSummaryText("具体内容！");
        style.bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        // 以下是展示多文本通知
        android.support.v4.app.NotificationCompat.BigTextStyle style1 = new android.support.v4.app.NotificationCompat.BigTextStyle();
        style1.setBigContentTitle(title);
        style1.bigText(content);
        return new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                .setStyle(style)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getNotification_26(String title, String content) {
        return new Notification.Builder(getApplicationContext(), sID)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round)))
                .setNumber(10)
                .setAutoCancel(true);
    }
}