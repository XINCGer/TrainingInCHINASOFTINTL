package com.example.administrator.demo1.tool;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/25.
 */
public class SingletonBean {
    //单例模式实例
    private static SingletonBean instance = null;

    //synchronized 用于线程安全，防止多线程同时创建实例
    public synchronized static SingletonBean getInstance(){
        if(instance == null){
            instance = new SingletonBean ();
        }
        return instance;
    }

    final HashMap<String, Object> mMap;
    public SingletonBean ()
    {
        mMap = new HashMap<String,Object>();
    }

    public void put(String key,Object value){
        mMap.put(key,value);
    }

    public Object get(String key)
    {
        return mMap.get(key);
    }
}
