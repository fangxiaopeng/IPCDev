package com.fxp.secondapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fxp.secondapp.api.DataBean;
import com.fxp.secondapp.api.IDataService;
import com.fxp.secondapp.api.IDataServiceCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:       DataService
 * <p>
 * Package:     com.fxp.secondapp.service
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/10 4:29 PM
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
public class DataService extends Service{

    private List<String> stringList;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("fxp", "DataService - onCreate");

        stringList = new ArrayList<>();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("fxp", "onStartCommand - startId = " + startId + ", Thread ID = " + Thread.currentThread().getId());

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Binder binder = new IDataService
            .Stub() {
        @Override
        public void addData(String data) throws RemoteException {
            if (stringList != null) stringList.add(data);
        }

        @Override
        public void deleteData(int index, String data) throws RemoteException {

        }

        @Override
        public void setData(int index, DataBean data) throws RemoteException {

        }

        @Override
        public DataBean getData(int index) throws RemoteException {
            return null;
        }

        @Override
        public List<DataBean> getAll() throws RemoteException {
            return null;
        }

        @Override
        public void asynMethod(String params, IDataServiceCallback callback) throws RemoteException {
            if (callback != null) callback.onSuccess("Callback Test onSuccess");

        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            try {
                return super.onTransact(code, data, reply, flags);
            } catch (RuntimeException e) {
                // 打印 远端api错误信息
                Log.e("fxp", "Unexpected remote exception", e);

                throw e;
            }
        }
    };

}
