package com.example.user.kk.activity;

import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.support.v4.app.FragmentManager;
import com.example.user.kk.R;
import com.example.user.kk.adapter.MyPagerAdapter;
import com.example.user.kk.adapter.MyaboutAdapter;
import com.example.user.kk.fragment.AboutNewbookFragment;
import com.example.user.kk.fragment.About_Officialservice_fragment;
import java.util.ArrayList;
import java.util.List;

/**
 * 写点击关于的界面
 **/

public class AboutActivity extends AppCompatActivity {
    public ImageView back_arrow_img;
    TabLayout about_tab;
    ViewPager about_vp;
    List<Fragment> list;
    List<String> listtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initview();
        set1Data();
    }


    public View initview() {
        back_arrow_img = (ImageView) findViewById(R.id.back_arrow_img);
        back_arrow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutActivity.this.finish();
            }
        });
        about_tab = (TabLayout) findViewById(R.id.aboutActivity_tab);
        about_vp = (ViewPager) findViewById(R.id.aboutActivity_vp);
        return null;
    }

    public void set1Data() {
        list = new ArrayList<>();
        list.add(new About_Officialservice_fragment());
        list.add(new AboutNewbookFragment());
        listtitle=new ArrayList<>();
        listtitle.add("新手宝典");
        listtitle.add("官方客服");


        MyaboutAdapter myaboutAdapter=new MyaboutAdapter(getSupportFragmentManager(),list,listtitle);

        about_vp.setAdapter(myaboutAdapter);
        about_vp.setCurrentItem(0);
        about_tab.setupWithViewPager(about_vp);


    }

}
