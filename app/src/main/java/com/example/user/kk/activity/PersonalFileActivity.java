package com.example.user.kk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.user.kk.R;

public class PersonalFileActivity extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_file);
        initView();
        onSetData();
        onClickListener();
    }
    private void initView() {
        back= (ImageView) findViewById(R.id.person_file_back);

    }
    private void onSetData() {

    }
    private void onClickListener(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
