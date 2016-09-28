package com.example.user.kk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Live_hot_item_bean;
import com.example.user.kk.utils.SectionedBaseAdapter;

import java.util.List;

/**
 * Created by user on 2016/9/19.
 */
public class MyLiveHotListAdapter extends SectionedBaseAdapter {

    Live_hot_item_bean bean;
    Context context;
    public MyLiveHotListAdapter(Live_hot_item_bean bean, Context context){
        this.bean=bean;
        this.context=context;
    }
    @Override
    public Object getItem(int section, int position) {
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        return 0;
    }

    @Override
    public int getSectionCount() {
        return 1;
    }

    @Override
    public int getCountForSection(int section) {
        return 1;
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
             convertView = View.inflate(context,R.layout.live_fragment_hot_item,null);
             GridView gridView = (GridView) convertView.findViewById(R.id.live_fragment_hot_gridview);
             LiveHorGridViewAdapter adapter =new LiveHorGridViewAdapter(bean,context);
             gridView.setAdapter(adapter);
        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        convertView=View.inflate(context,R.layout.xuanfu,null);
        return convertView;
    }

}
