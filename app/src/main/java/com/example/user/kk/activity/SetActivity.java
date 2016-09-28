package com.example.user.kk.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.kk.R;
import com.example.user.kk.fragment.MeFragment;

public class SetActivity extends AppCompatActivity {
    ImageView imageView;
    TextView roomanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        imageView= (ImageView) findViewById(R.id.image_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(SetActivity.this, MeFragment.class);
//                startActivity(intent);
//                finish();
                SetActivity.this.finish();
                overridePendingTransition(R.anim.tran_back_in,R.anim.tran_back_out);
            }
        });

        roomanim= (TextView) findViewById(R.id.rooom_anim);
        roomanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent=new Intent(SetActivity.this,RoomanimActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.tran_back_in,R.anim.tran_back_out);
            }
        });
    }

}
