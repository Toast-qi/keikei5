package com.example.user.kk.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by user on 2016/9/19.
 */
public class LiveFragmentHotHeaderAdapter extends PagerAdapter {
    List<View> list;

    public LiveFragmentHotHeaderAdapter(List<View> list){
        this.list=list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e("====1==11===", "getData:");
        View view = list.get(position);
        Log.e("===2===11===", "getData:"+position);
        container.addView(view);
        Log.e("===3===11===", "getData:"+position);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       View view=list.get(position);
        Log.e("===4===11===", "getData:");
        container.removeView(view);
    }
}
