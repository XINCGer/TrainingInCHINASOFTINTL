package com.example.administrator.demo1.tool;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/25.
 */
public class PracelableBean implements Parcelable {
    //定义要被传输的数据
    public int age;
    public String name;
    public HashMap<String,String> mMap = new HashMap<String,String>();
    public PracelableBean(){

    }

    protected PracelableBean(Parcel in) {
        //将映射在Parcel对象中的数据还原回来
        //警告，这里顺序一定要和writeToParcel中定义的顺序一致才行!!!
        age = in.readInt();
        name  = in.readString();
        mMap  = in.readHashMap(HashMap.class.getClassLoader());
    }

    public static final Creator<PracelableBean> CREATOR = new Creator<PracelableBean>() {
        @Override
        public PracelableBean createFromParcel(Parcel in) {
            return new PracelableBean(in);
        }

        @Override
        public PracelableBean[] newArray(int size) {
            return new PracelableBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //等于将数据映射到Parcel中去
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeMap(mMap);
    }
}
