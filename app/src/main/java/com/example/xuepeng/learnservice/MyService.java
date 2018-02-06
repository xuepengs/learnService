package com.example.xuepeng.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean serviceRunming = false;
    public MyService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("on start Commond");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service Create");
        serviceRunming=true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (serviceRunming) {
                    System.out.println("服务正在运行。。。");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service Destroy");
        serviceRunming=false;
    }
}
