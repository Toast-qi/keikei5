package com.example.user.kk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public List<Fragment> list;
    public List<String> listtitle;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> listtitle) {
        super(fm);
        this.list=list;
        this.listtitle=listtitle;
    }




    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }
}
