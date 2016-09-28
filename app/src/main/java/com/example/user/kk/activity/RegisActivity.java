package com.example.user.kk.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.kk.Dao.DbHelper;
import com.example.user.kk.Dao.MiniDao;
import com.example.user.kk.R;

public class RegisActivity extends AppCompatActivity {
    DbHelper dbHelper;
     MiniDao miniDao;
    Button login_zhuce_xiyibu;
    EditText login_zhuce_haoma,login_zhuce_duanxin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        login_zhuce_xiyibu= (Button) findViewById(R.id.login_zhuce_xiyibu);
        login_zhuce_haoma= (EditText) findViewById(R.id.login_zhuce_haoma);
        login_zhuce_duanxin= (EditText) findViewById(R.id.login_zhuce_duanxin);

        miniDao=new MiniDao(this);
        login_zhuce_xiyibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=login_zhuce_haoma.getText().toString();
                Log.e("str1", "onClick: "+str1 );
                String str11= login_zhuce_duanxin.getText().toString();
                Log.e("str1", "onClick: "+str11 );
                miniDao.insert(str1,str11);
                Intent intent=new Intent(RegisActivity.this,RegisterActivity.class);

                if(login_zhuce_haoma.getText().toString().length()==11){
                    Toast.makeText(RegisActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    Toast.makeText(RegisActivity.this,"请输入正确的11手机号码",Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}
