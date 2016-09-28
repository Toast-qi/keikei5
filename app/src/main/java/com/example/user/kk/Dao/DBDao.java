package com.example.user.kk.Dao;

import android.content.Context;

import com.example.user.kk.utils.ConstantUtils;

/**
 * Created by user on 2016/9/22.
 */
public class DBDao {
    Context context;
    DbHelper dbHelper;

    public  DBDao( Context context){
        this.context=context;
        dbHelper=new DbHelper(context, ConstantUtils.DB_NAME,null,ConstantUtils.DB_VERSION);

    }
}
