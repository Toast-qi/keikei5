package com.example.user.kk.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.user.kk.R;
import com.example.user.kk.fragment.DynamicFragment;
import com.example.user.kk.fragment.LiveFragment;
import com.example.user.kk.fragment.MeFragment;
import com.example.user.kk.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout main_dynamic, main_live, main_me, main_news;
    Fragment Dynamic_Fragment, Live_Fragment, News_Fragment, Me_Fragment;
    ImageView main_kktv, main_dynamic_iv, main_live_iv, main_news_iv, main_me_iv;
    TextView main_dynamic_tv, main_live_tv, main_me_tv, main_news_tv;
    //声明一个 FragmentManager 的管理类
    private FragmentManager fragmentManager;
    //声明一个Fragment事务的对象
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化一个 FragmentManager 管理类的实例
        fragmentManager = getSupportFragmentManager();
        onInitView();

        onClickListener();
    }

    private void onInitView() {
        main_dynamic = (LinearLayout) findViewById(R.id.main_dynamic);
        main_live = (LinearLayout) findViewById(R.id.main_live);
        main_me = (LinearLayout) findViewById(R.id.main_me);
        main_news = (LinearLayout) findViewById(R.id.main_news);
        main_kktv = (ImageView) findViewById(R.id.main_kktv);
        main_dynamic_iv = (ImageView) findViewById(R.id.main_dynamic_iv);
        main_news_iv = (ImageView) findViewById(R.id.main_news_iv);
        main_live_iv = (ImageView) findViewById(R.id.main_live_iv);
        main_me_iv = (ImageView) findViewById(R.id.main_me_iv);
        main_me_tv = (TextView) findViewById(R.id.main_me_tv);
        main_live_tv = (TextView) findViewById(R.id.main_live_tv);
        main_dynamic_tv = (TextView) findViewById(R.id.main_dynamic_tv);
        main_news_tv = (TextView) findViewById(R.id.main_news_tv);


        setClick(1);
        main_live_tv.setTextColor(this.getResources().getColor(R.color.colorOrange));
        main_live_iv.setImageResource(R.mipmap.kk_tab_hotscreen_selected);


        main_dynamic.setOnClickListener(this);
        main_live.setOnClickListener(this);
        main_me.setOnClickListener(this);
        main_news.setOnClickListener(this);
        main_kktv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //导航条每次点击前重置其他按钮图片和文字
        reset();
        switch (view.getId()) {
            //点击首页按钮
            case R.id.main_live:
                //点击更改图片和字体颜色
                main_live_tv.setTextColor(this.getResources().getColor(R.color.colorOrange));
                main_live_iv.setImageResource(R.mipmap.kk_tab_hotscreen_selected);
                //点击时，调用方法显示对应的 Fragment
                setClick(1);
                break;
            case R.id.main_dynamic:
                main_dynamic_tv.setTextColor(this.getResources().getColor(R.color.colorOrange));
                main_dynamic_iv.setImageResource(R.mipmap.kk_tab_dis_selected);
                setClick(2);
                break;
            case R.id.main_news:
                main_news_tv.setTextColor(this.getResources().getColor(R.color.colorOrange));
                main_news_iv.setImageResource(R.mipmap.kk_tab_news_selected);
                setClick(3);
                break;
            case R.id.main_me:
                main_me_tv.setTextColor(this.getResources().getColor(R.color.colorOrange));
                main_me_iv.setImageResource(R.mipmap.kk_tab_me_selected);
                setClick(4);
                break;
        }

    }


    private void setClick(int i) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (i) {
            //让直播按钮所对应的 Fragment 显示
            case 1:
                //如果已经存在对应的 Fragment 对象，直接让它显示出来；否则就创建一个对象出来
                if (Live_Fragment == null) {
                    //实例化一个 Fragment 对象
                    Live_Fragment = new LiveFragment();
                    fragmentTransaction.add(R.id.activity_content, Live_Fragment);
                } else {
                    //因为已经存在对应的 Fragment 对象，所以直接显示出来即可
                    fragmentTransaction.show(Live_Fragment);
                }
                break;
            case 2:
                if (Dynamic_Fragment == null) {
                    Dynamic_Fragment = new DynamicFragment();
                    fragmentTransaction.add(R.id.activity_content, Dynamic_Fragment);
                } else {
                    fragmentTransaction.show(Dynamic_Fragment);
                }
                break;
            case 3:
                if (News_Fragment == null) {
                    News_Fragment = new NewsFragment();
                    fragmentTransaction.add(R.id.activity_content, News_Fragment);
                } else {
                    fragmentTransaction.show(News_Fragment);
                }
                break;
            case 4:
                if (Me_Fragment == null) {
                    Me_Fragment = new MeFragment();
                    fragmentTransaction.add(R.id.activity_content, Me_Fragment);
                } else {
                    fragmentTransaction.show(Me_Fragment);
                }
                break;
            default:
                break;
        }
        //进行事务的提交（如果没有此方法，则以上所有代码不起作用）
        fragmentTransaction.commit();
    }
    public void onClickListener(){
        main_kktv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    /**
     * 隐藏已经存在的所有的 Fragment
     */
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        //判断对应 Fragment 是否为空
        if (Live_Fragment != null) {
            //不等于空，则隐藏
            fragmentTransaction.hide(Live_Fragment);
        }
        if (Dynamic_Fragment != null) {
            fragmentTransaction.hide(Dynamic_Fragment);
        }
        if (News_Fragment != null) {
            fragmentTransaction.hide(News_Fragment);
        }
        if (Me_Fragment != null) {
            fragmentTransaction.hide(Me_Fragment);
        }
    }
    //导航条每次点击重置其他按钮图片和文字
    public void reset() {
        main_live_tv.setTextColor(this.getResources().getColor(R.color.colorGray));
        main_live_iv.setImageResource(R.mipmap.kk_tab_hotscreen_unselected);
        main_dynamic_tv.setTextColor(this.getResources().getColor(R.color.colorGray));
        main_dynamic_iv.setImageResource(R.mipmap.kk_tab_dis_unselected);
        main_news_tv.setTextColor(this.getResources().getColor(R.color.colorGray));
        main_news_iv.setImageResource(R.mipmap.kk_tab_news_unselected);
        main_me_tv.setTextColor(this.getResources().getColor(R.color.colorGray));
        main_me_iv.setImageResource(R.mipmap.kk_tab_me_unselected);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
