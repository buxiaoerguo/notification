package com.example.administrator.ljjdemo;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogTestActivity extends Activity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test);
        LogManager.getInstance().init(LOG_FILE);

        LogUtil.e("start");
        LogUtil.e(LOG_FILE,"start");
    }
}
