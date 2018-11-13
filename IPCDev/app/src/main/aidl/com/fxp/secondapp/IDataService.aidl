// IDataService.aidl
package com.fxp.secondapp;

import com.fxp.secondapp.DataBean;
import com.fxp.secondapp.IDataServiceCallback;

interface IDataService {

    void addData(String data);

    void deleteData(int index, String data);

    void setData(int index, in DataBean data);

    DataBean getData(int index);

    List<DataBean> getAll();

    void asynMethod(IDataServiceCallback callback);
}
