package com.example.user.kk.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.user.kk.R;
import com.example.user.kk.activity.NewSurvivalwebview;

public class About_Officialservice_fragment extends BaseFragment {
  ImageView new_subvival;

    @Override
    public View initView() {
        View view=View.inflate(getContext(),R.layout.activity_about__officialservice_fragment,null);
        new_subvival= (ImageView) view.findViewById(R.id.new_subvival_img);
        new_subvival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), NewSurvivalwebview.class);
                getContext().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void setData() {

    }
}
