package com.example.user.kk.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.gesture.GestureOverlayView;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.user.kk.R;

public class SplashActivity extends AppCompatActivity {
     ImageView imageView;
    Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        imageView= (ImageView) findViewById(R.id.splash_bigphoto);
        TranslateAnimation anim=new TranslateAnimation(80f,-80f,0f,0f);
         anim.setDuration(3000);
//        anim.setRepeatCount(5);
//        anim.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(anim);
        setData();
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);




    }

    private void setData(){
//     实现倒数三秒跳转,延迟发送消息功能
        handler.sendEmptyMessageDelayed(0,3000);
    }


}
