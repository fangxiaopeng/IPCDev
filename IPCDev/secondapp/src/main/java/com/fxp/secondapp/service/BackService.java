package com.fxp.secondapp.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Title:       BackService
 * <p>
 * Package:     com.fxp.secondapp.service
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/9 7:38 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/9    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class BackService extends Service{

    private String TAG = BackService.class.getSimpleName();

    private MyBroadcastReceiver myBroadcastReceiver = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        initBroadcastReceiver();

//        startTimerTask();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand - startId = " + startId + ", Thread ID = " + Thread.currentThread().getId());

        return super.onStartCommand(intent, flags, startId);
    }

    private void initBroadcastReceiver(){
        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("");
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra("key");
            if (intent.getAction().equals(getPackageName())) {
                handleMessage(handler, 0, data);
            }
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

                    break;
                default:
                    break;
            }
        }

    };

    public void sendTestBroadcast(String action, String content){
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("key", content);
        sendBroadcast(intent);
    }

    private void startTimerTask(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run(){
                // todo

            }
        };
        timer.schedule(task,0,10000);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }
}
