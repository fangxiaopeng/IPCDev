package com.fxp.ipcdev.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.fxp.ipcdev.R;
import com.fxp.secondapp.IDataService;

/**
 * Title:       AIDLTestActivity
 * <p>
 * Package:     com.fxp.ipcdev.activity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/10 6:08 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/10    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class AIDLTestActivity extends Activity{

    private IDataService iDataService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iDataService = IDataService.Stub.asInterface(service);
            if (iDataService != null){
                // todo

            }

            try{
                // 注册死亡代理，监测连接状态
                service.linkToDeath(deathRecipient, 0);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if (iDataService == null) return;

            iDataService.asBinder().unlinkToDeath(deathRecipient, 0);
            iDataService = null;
            // 重新绑定服务
            bindDataService();
        }
    };

    private void bindDataService(){
        try {
            Intent serviceIntent = new Intent();
            serviceIntent.setPackage("com.fxp.secondapp");
            serviceIntent.setAction("com.fxp.secondapp.service.BackService");
            bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
