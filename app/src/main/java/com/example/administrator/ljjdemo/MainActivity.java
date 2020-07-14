package com.example.administrator.ljjdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    /**
     * 主路径
     */
    private static final String MAIN_DIR = Environment.getExternalStorageDirectory() + "/AAA_mesh/LogUtil";

    /**
     * 保存Log的文件
     */
    private static final String LOG_FILE = MAIN_DIR + "/log.txt";

    private final static String LOG_FOR_QA = "[log4qa] ";
    private final static String LOG_FOR_DADIAN = "[log4dadian] ";
    /**
     * 通知栏Notification
     */
    private NotificationManager mManager;
    private Notification mNotification;
    private PendingIntent mIntent;
    private String cll;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cll = "test!";
//        ButterKnife.bind(this);
        init();
        LogManager.getInstance().init(LOG_FILE);

        LogUtil.e("start");
        LogUtil.e(LOG_FILE,"start");
        btn_send =findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             show();
                LogUtil.e("show");
            }
        });
    }
    private void init() {
        //初始化通知栏管理者
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //意图数组
        Intent[] intents = {new Intent(this, NotificationAcitivity.class)};
        //待处理意图对象
        mIntent = PendingIntent.getActivities(this, 0, intents, 0);
        //消息栏通知对象
        mNotification = new Notification();
    }
    public void show() {
        //设置在通知栏的消息图标
        mNotification.icon = R.mipmap.ic_launcher_round;
        //设置在通知栏的信息内容
        mNotification.tickerText = "重大消息";
        //设置默认的声音,此外还可以设置震动（需加入权限）
        mNotification.defaults = Notification.DEFAULT_SOUND;
        //添加灯光
// mNotification.defaults=Notification.DEFAULT_LIGHTS;
        //不能删除
        mNotification.flags = Notification.FLAG_NO_CLEAR;
        //设置下拉时的显示布局
        RemoteViews convertView = new RemoteViews(getPackageName(), R.layout.layout_content);
        convertView.setImageViewResource(R.id.img, R.mipmap.ic_launcher);
        convertView.setTextViewText(R.id.txt, cll);
        mNotification.contentView = convertView;
        mNotification.contentIntent = mIntent;
        //发送通知
        // 第一个参数唯一的标识该Notification，第二个参数就是Notification对象
        mManager.notify(1, mNotification);
    }
}
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//    }
//    @Override
//    public void onContentChanged() {
//        super.onContentChanged();
//        init();
//    }
//
//    @OnClick(R.id.btn_create)
