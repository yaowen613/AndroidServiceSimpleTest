package com.yaowen.androidservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {
    private Button bdService, startService;
   // private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        bdService = (Button) findViewById(R.id.bdService);
        startService = (Button) findViewById(R.id.startService);

        bdService.setOnClickListener(new OnClick());
        startService.setOnClickListener(new OnClick());
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == bdService) {
                bindService(new Intent(MyService.ACTION), conn, BIND_AUTO_CREATE);
            }
            if (v == startService) {
                startService(new Intent(MyService.ACTION));
            }
        }
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("TAG", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("TAG", "onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        Log.d("TAG", "onDestroy unbindService");
        unbindService(conn);
        super.onDestroy();
    }
}
