package com.example.user.kk.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.opengl.Visibility;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.kk.Dao.MiniDao;
import com.example.user.kk.R;
/**
 * 登录界面及登录功能
 *
 * user Toast_qi
 *
 * **/
public class RegisterActivity extends Activity {
    private ImageView close;
    TextView phone_fast_login, first_login_tv, login_login,kk_ID;
    EditText kk_phonenum, message_code_edtext;
    ImageView kk_message_code;
    MiniDao miniDao;
    EditText phone_phonenum_edtv, phone_message_code_edtext;
    TextView phone_first_sign, phone_forget_num;
    ImageView phone_arrow_down;
    //true：显示登录   false：显示注册
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        close = (ImageView) findViewById(R.id.register_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
//        手机号
        phone_phonenum_edtv = (EditText) findViewById(R.id.phone_phonenum_edtv);
        phone_message_code_edtext = (EditText) findViewById(R.id.phone_message_code_edtext);
        phone_first_sign = (TextView) findViewById(R.id.phone_first_sign);
        phone_first_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,RegisActivity.class);
                startActivity(intent);

            }
        });
        phone_forget_num = (TextView) findViewById(R.id.phone_forget_num);
        phone_arrow_down = (ImageView) findViewById(R.id.phone_arrow_down);

        first_login_tv = (TextView) findViewById(R.id.first_login_tv);
//        kk_ID = (TextView) findViewById(R.id.kk_ID);
           miniDao=new MiniDao(this);
        kk_phonenum = (EditText) findViewById(R.id.kk_phonenum);
        message_code_edtext = (EditText) findViewById(R.id.message_code_edtext);
        login_login= (TextView) findViewById(R.id.login_login);
        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RegisterActivity.this, MainActivity.class);
                String str1=kk_phonenum.getText().toString();
                String str2=message_code_edtext.getText().toString();
                miniDao.query(str1,str2);
                Cursor cursor = miniDao.query(kk_phonenum.getText().toString().trim(), message_code_edtext.getText().toString().trim());
                Log.e("query", "onClick: "+miniDao );

                if (kk_phonenum.getText().toString().length()==11) {
                    if (cursor.moveToNext()) {
                        startActivity(intent1);
                        Toast.makeText(RegisterActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(RegisterActivity.this, "您输入的账号或密码有误", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(RegisterActivity.this, "请输入正确11位手机号", Toast.LENGTH_SHORT).show();
                }
            }

        });
        kk_message_code = (ImageView) findViewById(R.id.kk_message_code);
        phone_fast_login = (TextView) findViewById(R.id.phone_fast_login);
        phone_fast_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = !flag;
                if (flag) {
                    first_login_tv.setVisibility(View.VISIBLE);
                    kk_phonenum.setVisibility(View.VISIBLE);
                    message_code_edtext.setVisibility(View.VISIBLE);
                    kk_message_code.setVisibility(View.VISIBLE);
                    phone_phonenum_edtv.setVisibility(View.INVISIBLE);
                    phone_message_code_edtext.setVisibility(View.INVISIBLE);
                    phone_first_sign.setVisibility(View.INVISIBLE);
                    phone_forget_num.setVisibility(View.INVISIBLE);
                    phone_arrow_down.setVisibility(View.INVISIBLE);
                    phone_fast_login.setText("kk账号登录");
                    //显示登录的视图
                } else {
                    first_login_tv.setVisibility(View.INVISIBLE);
                    kk_phonenum.setVisibility(View.INVISIBLE);
                    message_code_edtext.setVisibility(View.INVISIBLE);
                    kk_message_code.setVisibility(View.INVISIBLE);
                    phone_phonenum_edtv.setVisibility(View.VISIBLE);
                    phone_message_code_edtext.setVisibility(View.VISIBLE);
                    phone_first_sign.setVisibility(View.VISIBLE);
                    phone_forget_num.setVisibility(View.VISIBLE);
                    phone_arrow_down.setVisibility(View.VISIBLE);
                    phone_fast_login.setText("手机号快捷登录");
                }
            }
        });

    }


}
