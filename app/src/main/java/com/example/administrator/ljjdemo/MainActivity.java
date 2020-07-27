package com.example.administrator.ljjdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    Button btn_send,btn_send2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_send =findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil notificationUtils = new NotificationUtil(MainActivity.this);
                notificationUtils.sendNotification("Testsss", "测试sss",1);
                LogUtil.e("show");
            }
        });
        btn_send2 =findViewById(R.id.btn_send2);
        btn_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil notificationUtils = new NotificationUtil(MainActivity.this);
                notificationUtils.sendNotification("Test", "测试",2);
            }
        });

    }



//    WindowManager wm;
//    WindowManager.LayoutParams params;
//    private void initWindowManager(){
// wm = (WindowManager) getApplicationContext().getSystemService(
//     Context.WINDOW_SERVICE);
// params = new WindowManager.LayoutParams();
// // 设置window type
// params.type = WindowManager.LayoutParams.TYPE_PHONE;
// /*
//  * 如果设置为params.type = WindowManager.LayoutParams.TYPE_PHONE; 那么优先级会降低一些,
//  * 即拉下通知栏不可见
//  */
// params.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
// // 设置Window flag
// params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//     | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//     | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
// /*
//  * 下面的flags属性的效果形同“锁定”。 悬浮窗不可触摸，不接受任何事件,同时不影响后面的事件响应。
//  * wmParams.flags=LayoutParams.FLAG_NOT_TOUCH_MODAL |
//  * LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_NOT_TOUCHABLE;
//  */
// // 设置悬浮窗的长得宽
// params.width = wm.getDefaultDisplay().getWidth();
// params.height = 200;
// params.gravity = Gravity.LEFT | Gravity.TOP;}
//private void createFloatView(String str) {
// if (btn_floatView == null){
//   btn_floatView = new Button(getApplicationContext());
//   wmTag = true;
// }
// btn_floatView.setText(str);
// Log.i(TAG, "createFloatView: "+str);
// // 设置悬浮窗的Touch监听
// btn_floatView.setOnTouchListener(new View.OnTouchListener() {
//   int lastX, lastY;
//   int paramX, paramY;
//   public boolean onTouch(View v, MotionEvent event) {
//     switch (event.getAction())
//     {
//       case MotionEvent.ACTION_DOWN:
//         if (MainActivity.lifeTag == 1) {
//           Intent intent = new Intent(DataService.this, MainActivity.class);
//           startActivity(intent);
//         }
//         wm.removeViewImmediate(btn_floatView);
//         btn_floatView = null;
//         break;
//       case MotionEvent.ACTION_MOVE:
//         break;
//     }
//     return true;
//   }
// });
// if (wmTag){
//   wm.addView(btn_floatView, params);
//   wmTag = false;
// }else {
//   wm.updateViewLayout(btn_floatView,params);
// } }
}