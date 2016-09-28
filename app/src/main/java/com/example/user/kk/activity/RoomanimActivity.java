package com.example.user.kk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.user.kk.R;

public class RoomanimActivity extends AppCompatActivity {
         ToggleButton toggleButton1,toggleButton2,toggleButton3;
    ImageView room_arrow;
    TextView room_gift_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomanim);
        room_gift_tv= (TextView) findViewById(R.id.room_gift_tv);
        room_gift_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomanimActivity.this.finish();
                overridePendingTransition(R.anim.tran_back_in,R.anim.tran_back_out);
            }
        });
        room_arrow= (ImageView) findViewById(R.id.room_arrow);
        room_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomanimActivity.this.finish();
                overridePendingTransition(R.anim.tran_back_in,R.anim.tran_back_out);
            }
        });
        toggleButton1= (ToggleButton) findViewById(R.id.mToBtn1);
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(RoomanimActivity.this, "礼物动画开启", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RoomanimActivity.this,"礼物动画关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });


        toggleButton2= (ToggleButton) findViewById(R.id.mToBtn2);
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(RoomanimActivity.this, "飞屏动画开启", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RoomanimActivity.this,"飞屏动画关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
