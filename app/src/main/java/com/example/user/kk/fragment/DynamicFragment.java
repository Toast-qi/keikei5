package com.example.user.kk.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.user.kk.R;
import com.example.user.kk.activity.RegisterActivity;
import com.example.user.kk.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class DynamicFragment extends BaseFragment {
    private TabLayout tb;
    private ViewPager vp;
    private List<Fragment> fragmentList;
    private List<String> listTitle;
    private ImageView camera;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.dynamic_fragment, null);
        tb = (TabLayout) view.findViewById(R.id.dynamic_tb);
        vp = (ViewPager) view.findViewById(R.id.dynamic_VP);
        camera = (ImageView) view.findViewById(R.id.dynamic_fragment_camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
//                if () {
//
//                } else {
//
//                }
            }
        });

        return view;
    }

    @Override
    public void setData() {
        listTitle = new ArrayList<>();
        listTitle.add("热门");
        listTitle.add("关注");
        fragmentList = new ArrayList<>();
        fragmentList.add(new DynamicHotTopicFragment());
        fragmentList.add(new DynamicAttentionFragment());
        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager(), fragmentList, listTitle);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);

    }
}
