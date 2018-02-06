package com.example.xuepeng.learnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        intent=new Intent(MainActivity.this,MyService.class);
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.unBindService).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startService:
                startService(intent);
                break;
            case R.id.stopService:
                stopService(intent);
                break;
            case R.id.bindService:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unBindService:
                unbindService(this);
                break;
        }

    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("service connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
