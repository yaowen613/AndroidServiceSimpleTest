package com.yaowen.androidservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by HelloWorld on 2015/10/29.
 */
public class MyService extends Service {
    //private static final String TAG = "TAG";
    public static final String ACTION = "com.yaowen.androidservice.MyService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG", "MyService onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("TAG", "MyService onCreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d("TAG", "MyService onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
