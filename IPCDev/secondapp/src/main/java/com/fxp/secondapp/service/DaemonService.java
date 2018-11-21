package com.fxp.secondapp.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Title:       DaemonService
 * <p>
 * Package:     com.fxp.secondapp.service
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 2:52 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class DaemonService extends Service{

    @Override
    public void onCreate(){
        super.onCreate();

        startTimerTask();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("fxp", "onStartCommand - startId = " + startId + ", Thread ID = " + Thread.currentThread().getId());

        return super.onStartCommand(intent, flags, startId);
    }

    private void startTimerTask(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run(){
                // 10秒启动一次OnePxActivity
                toOnePxActivity();
            }
        };
        timer.schedule(task,0,10000);
    }

    private void toOnePxActivity(){
        Log.e("fxp-DaemonService", "toOnePxActivity");

        try {
            Intent intent = new Intent("com.fxp.secondapp.activity.OnePxActivity");
            startActivity(intent);

            handleMessage(handler, 0, "toOnePxActivity");
        } catch (Exception e) {
            e.printStackTrace();
            handleMessage(handler, 0, e.getMessage().toString());
        }
    }

    private void handleMessage(Handler h, int msgID, String data)
    {
        Message msg = new Message();
        msg.what = msgID;
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            String data = msg.getData().getString("data");
            switch (msg.what){
                case 0:
                    Toast.makeText(DaemonService.this, data, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}
