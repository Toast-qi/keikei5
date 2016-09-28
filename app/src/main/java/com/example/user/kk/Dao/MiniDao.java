package com.example.user.kk.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by user on 2016/9/20.
 */
public class MiniDao {
    Context context;
    DbHelper dbHelper;

    public MiniDao(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context, "keikei.db", null, 1);
    }

    // 往mini表中  插入数据
    public void insert(String num, String name) {
//  获取数据库写的权限，一般都是更新
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql ="insert into mini(num,name) values(?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{num, name});
        sqLiteDatabase.close();

    }

//    查询数据库方法，使用数据库读取数据库权限的时候，不能调用sqLiteDatabase.close();
      public Cursor query(String num,String name){
          SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
          String sql="select*from mini where num=?and name=?";
          return sqLiteDatabase.rawQuery(sql,new String[]{num,name});

      }
    public Cursor queryAll(){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        String sql="select*from mini";
        return sqLiteDatabase.rawQuery(sql,null);
    }

}
