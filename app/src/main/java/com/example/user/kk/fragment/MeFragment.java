package com.example.user.kk.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.kk.R;

import com.example.user.kk.activity.AboutActivity;
import com.example.user.kk.activity.MeFamilyActivity;
import com.example.user.kk.activity.RegisterActivity;
import com.example.user.kk.activity.SetActivity;

import com.example.user.kk.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class MeFragment extends BaseFragment{
    public TabLayout tableLayout;
    public ViewPager viewPager;
    public List<Fragment>list;
    public List<String>listtitle;

    public ImageView imageView,imageView1,mefragment_about,mefragment_pay;
    public LinearLayout linearLayout;
    public TextView login_textview;

    @Override
    public View initView() {
        View view=View.inflate(getActivity(), R.layout.me_fragment,null);
        tableLayout= (TabLayout) view.findViewById(R.id.mefragment_tb);
        viewPager= (ViewPager) view.findViewById(R.id.mefragment_vp);
        mefragment_pay= (ImageView) view.findViewById(R.id.mefragment_pay);
        mefragment_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(getActivity(),);
            }
        });
        linearLayout= (LinearLayout) view.findViewById(R.id.me_fragment_linear);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MeFamilyActivity.class);
                startActivity(intent);
            }
        });
        imageView1= (ImageView) view.findViewById(R.id.me_family_arrow);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MeFamilyActivity.class);
                startActivity(intent);
            }
        });

        mefragment_about= (ImageView) view.findViewById(R.id.mefragment_about);
        mefragment_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);

            }
        });
        imageView= (ImageView) view.findViewById(R.id.me_set_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
               getActivity().overridePendingTransition(R.anim.tran_in,R.anim.tran_out);
            }
        });
        login_textview= (TextView) view.findViewById(R.id.me_fragment_login);
        login_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), RegisterActivity.class);
                  startActivity(intent);
                 getActivity().overridePendingTransition(R.anim.tran_in,R.anim.tran_out);
            }
        });

        return view;
    }

    @Override
    public void setData() {
        list=new ArrayList<>();
        list.add(new MySelfFragment());
        list.add(new MyGuardFragment());
        list.add(new MyMangeFragment());
        list.add(new MyHistoryFragment());
        listtitle=new ArrayList<>();
        listtitle.add("我关注的");
        listtitle.add("我守护的");
        listtitle.add("我管理的");
        listtitle.add("观看历史");
        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager(),list,listtitle);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        tableLayout.setupWithViewPager(viewPager);




    }
}
