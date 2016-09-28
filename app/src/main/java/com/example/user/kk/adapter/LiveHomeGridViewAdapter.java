package com.example.user.kk.adapter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Live_home_list_item_bean;
import com.example.user.kk.bean.Live_hot_item_bean;

/**
 * Created by user on 2016/9/20.
 */
public class LiveHomeGridViewAdapter extends BaseAdapter {

    Live_home_list_item_bean bean;
    Context context;

    public LiveHomeGridViewAdapter(Live_home_list_item_bean bean, Context context) {
        this.context=context;
        this.bean=bean;
    }

    @Override
    public int getCount() {
        return bean.roomList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.live_fragment_home_grid_item,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.home_item_iv);
            ImageView imageView1 = (ImageView) view.findViewById(R.id.home_item_iv2);
            TextView textView = (TextView) view.findViewById(R.id.home_item_tv);
            TextView textView1 = (TextView) view.findViewById(R.id.home_item_tv1);
            TextView textView2 = (TextView) view.findViewById(R.id.home_item_tv2);
             String ss=bean.pathPrefix+bean.roomList.get(i).poster_path_756;
        Glide.with(context).load(ss).into(imageView);
        imageView1.setImageResource(R.mipmap.kk_room_mem_count_left);
        textView.setText(bean.roomList.get(i).roomTheme);
        textView1.setText(bean.roomList.get(i).nickname);
        textView2.setText(bean.roomList.get(i).onlineCount);
        return view;
    }

}
