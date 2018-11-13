package com.fxp.secondapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fxp.secondapp.DataBean;
import com.fxp.secondapp.IDataService;
import com.fxp.secondapp.IDataServiceCallback;

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

    private final String TAG = DataService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"@@ onCreate");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"@@ onBind");
        return binder;
    }

    Binder binder = new IDataService
            .Stub() {
        @Override
        public void addData(String data) throws RemoteException {

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
        public void asynMethod(IDataServiceCallback callback) throws RemoteException {}
    };

}
