package com.fxp.secondapp;

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

    public String id;

    public int index;

    public String value;

    public DataBean(Parcel in) {
        id = in.readString();
        index = in.readInt();
        value = in.readString();
    }

    public DataBean(String id, int index, String value){
        this.id = id;
        this.index = index;
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(index);
        dest.writeString(value);
    }

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        id = dest.readString();
        index = dest.readInt();
        value = dest.readString();
    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "id='" + id + '\'' +
                ", index=" + index +
                ", value='" + value + '\'' +
                '}';
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

    public static Creator<DataBean> getCREATOR() {
        return CREATOR;
    }
}
