package com.example.user.kk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by user on 2016/9/23.
 */
public class MyaboutAdapter extends FragmentPagerAdapter {

       List<Fragment>list;
      List<String>listTitle;

    public MyaboutAdapter(FragmentManager fm, List<Fragment> list, List<String> listTitle) {
        super(fm);
        this.list = list;
        this.listTitle = listTitle;
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
        return listTitle.get(position);
    }
}
