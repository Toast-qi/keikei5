package com.example.user.kk.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.kk.R;

public class TabActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    TextView textView2,textView3,textView4,textView5,textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        imageView= (ImageView) findViewById(R.id.tab_iv);
        textView2= (TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3);
        textView4= (TextView) findViewById(R.id.textView4);
        textView5= (TextView) findViewById(R.id.textView5);
        textView6= (TextView) findViewById(R.id.textView6);

        imageView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("xuanze");
        switch (view.getId()){
            case R.id.tab_iv:
                finish();
                overridePendingTransition(R.anim.tran_back_in,R.anim.tran_back_out);
                break;
            case R.id.textView2:
                finish();
                intent.putExtra("key",0);
                sendBroadcast(intent);
                break;
            case R.id.textView3:
                finish();
                intent.putExtra("key",1);
                sendBroadcast(intent);
                break;
            case R.id.textView4:
                finish();
                intent.putExtra("key",2);
                sendBroadcast(intent);
                break;
            case R.id.textView5:
                finish();
                intent.putExtra("key",3);
                sendBroadcast(intent);
                break;
            case R.id.textView6:
                finish();
                intent.putExtra("key",4);
                sendBroadcast(intent);
                break;

        }

    }
}
