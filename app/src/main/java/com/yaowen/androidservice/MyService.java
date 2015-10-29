package com.yaowen.androidservice;

import android.app.Notification;
import android.app.PendingIntent;
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

        Intent notificationIntent = new Intent(this, ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        //Notification notification = new Notification(R.mipmap.ic_launcher, "这个一个前台服务！", System.currentTimeMillis());
        //notification.setLatestEventInfo(this, "This is title", "This is content", pendingIntent);//该方法已经过时，不可使用了
        Notification.Builder builder = new Notification.Builder(MyService.this);
        builder.setContentIntent(pendingIntent).setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())//设置时间发生时间
                .setAutoCancel(true)//设置可以清除
                .setContentTitle("this is the ContentTitle!")//设置下拉列表里的标题
                .setContentText("this is ContentText!");//设置上下文内容
        Notification notification = builder.getNotification();
        //以前台服务的模式启动了，并且在系统状态栏会显⽰⼀个通知图标，下拉状态栏后可以看到该通知的详细内容
        startForeground(1, notification);
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
