package com.example.wangkuan.testservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private final String TAG = "test20160901";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyReceiver testreceiver = new MyReceiver();
        //启动Service
        //通过start方式启动
        Log.i(TAG,"启动service！");
        Intent intent=new Intent(MainActivity.this, TestService.class);
        startService(intent);
        IntentFilter intentFilter = new IntentFilter( "testbroadcast" );
        registerReceiver(testreceiver, intentFilter);
    }
    class MyReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            String data = intent.getExtras().getString("data");
            Log.i("Recevier1", "接收到:"+data);
        }
    }

}
