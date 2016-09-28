package com.example.user.kk.Dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016/9/20.
 */
public class DbHelper extends SQLiteOpenHelper{
    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table mini(id integer primary key autoincrement,num integer(5),name varchar(3))";
            sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        String sql1="create table mini(id integer primary key autoincrement,num integer(5),name varchar(3))";
//        sqLiteDatabase.execSQL(sql1);
    }
}
