package com.example.user.kk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.kk.R;

public class SeekActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    TextView textView;
    EditText editText;

    int a =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);

        imageView= (ImageView) findViewById(R.id.seek_iv);
        textView= (TextView) findViewById(R.id.seek_quxiao);
        editText= (EditText) findViewById(R.id.seek_edittex);




        imageView.setOnClickListener(this);
        textView.setOnClickListener(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() ==0){
                    a=1;
                    imageView.setVisibility(View.GONE);
                    textView.setText("取消");
                }else {
                    a=2;
                    imageView.setVisibility(View.VISIBLE);
                    textView.setText("搜索");

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.seek_quxiao:

                if (a==1){
                    finish();
                    overridePendingTransition(R.anim.tran_back_in,R.anim.tran_back_out);
                }else {
                    Toast.makeText(this,"逻辑处理",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.seek_iv:
                editText.setText("");
                textView.setText("取消");
                a=1;
                break;

        }

    }
}
