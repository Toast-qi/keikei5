package com.example.user.kk.activity;

import android.app.Application;

import org.xutils.x;

/**
 * Created by user on 2016/8/23.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
