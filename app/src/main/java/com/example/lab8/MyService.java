package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate(){
        super.onCreate();
        new Thread(()->{
            try{
                Thread.sleep(5000);
                Intent intent = new Intent(this, Main3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MyService.this.startActivity(intent);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int starId){
        super.onStartCommand(intent,flags,starId);
        return START_STICKY;
    }

    @Override
    public void  onDestroy(){super.onDestroy();}
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}