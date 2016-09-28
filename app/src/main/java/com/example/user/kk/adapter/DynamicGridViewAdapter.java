package com.example.user.kk.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.DynamicAttentionBean;

/**
 * Created by user on 2016/9/19.
 */
public class DynamicGridViewAdapter extends BaseAdapter {
    Context context;
    DynamicAttentionBean bean;
    int position;
    public DynamicGridViewAdapter(Context context,int position,DynamicAttentionBean bean){
        this.position=position;
        this.context=context;
        this.bean=bean;
    }

    @Override
    public int getCount() {
        return bean.newsList.get(position).picArray.size();
    }

    @Override
    public Object getItem(int i) {
        return bean.newsList.get(position).picArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.dynamic_attention_grid_view_item,null);
        ImageView iv= (ImageView) view.findViewById(R.id.dynamic_attention_gird_view_iv);
        Glide.with(context).load(bean.pathPrefix+bean.newsList.get(position).picArray.get(i).imageUrl_128).into(iv);
        return view;
    }
}