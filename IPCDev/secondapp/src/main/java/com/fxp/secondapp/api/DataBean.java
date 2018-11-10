package com.fxp.secondapp.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Title:       DataBean
 * <p>
 * Package:     com.fxp.secondapp.api
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/10 11:56 AM
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
public class DataBean implements Parcelable{

    protected DataBean(Parcel in) {
    }

    public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
        @Override
        public DataBean createFromParcel(Parcel in) {
            return new DataBean(in);
        }

        @Override
        public DataBean[] newArray(int size) {
            return new DataBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
