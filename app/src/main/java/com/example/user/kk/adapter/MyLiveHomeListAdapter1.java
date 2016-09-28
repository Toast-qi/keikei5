package com.example.user.kk.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Live_home_list_item2_bean;
import com.example.user.kk.bean.Live_hot_item_bean;
import com.example.user.kk.utils.SectionedBaseAdapter;

import javax.security.auth.login.LoginException;

/**
 * Created by user on 2016/9/19.
 */
public class MyLiveHomeListAdapter1 extends SectionedBaseAdapter {

    Live_home_list_item2_bean bean;
    Context context;

    public MyLiveHomeListAdapter1(Live_home_list_item2_bean bean, Context context) {
        this.bean = bean;
        this.context = context;
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
        convertView = View.inflate(context, R.layout.live_fragment_home_item2, null);

        Log.e("=============","============="+bean.rankList.size());

        ImageView imageView11 = (ImageView) convertView.findViewById(R.id.live_fragment_home2_header1_iv);
        TextView textView11 = (TextView) convertView.findViewById(R.id.live_fragment_home2_header1_tv1);
        ImageView imageView12 = (ImageView) convertView.findViewById(R.id.live_fragment_home2_header1_iv1);
        TextView textView12 = (TextView) convertView.findViewById(R.id.live_fragment_home2_header1_tv2);

        ImageView imageView21 = (ImageView) convertView.findViewById(R.id.live_fragment_home2_header2_iv);
        TextView textView21 = (TextView) convertView.findViewById(R.id.live_fragment_home2_header2_tv1);
        ImageView imageView22 = (ImageView) convertView.findViewById(R.id.live_fragment_home2_header2_iv1);
        TextView textView22 = (TextView) convertView.findViewById(R.id.live_fragment_home2_header2_tv2);

        ImageView imageView31 = (ImageView) convertView.findViewById(R.id.live_fragment_home2_header3_iv);
        TextView textView31 = (TextView) convertView.findViewById(R.id.live_fragment_home2_header3_tv1);
        ImageView imageView32 = (ImageView) convertView.findViewById(R.id.live_fragment_home2_header3_iv1);
        TextView textView32 = (TextView) convertView.findViewById(R.id.live_fragment_home2_header3_tv2);

        Glide.with(context).load(bean.rankList.get(0).portrait_path_128).into(imageView21);
        textView21.setText(bean.rankList.get(0).nickName);
        textView22.setText(bean.rankList.get(0).giftName);
        Glide.with(context).load(bean.rankList.get(0).giftPic).into(imageView22);

        Glide.with(context).load(bean.rankList.get(1).portrait_path_128).into(imageView11);
        textView11.setText(bean.rankList.get(1).nickName);
        textView12.setText(bean.rankList.get(1).giftName);
        Glide.with(context).load(bean.rankList.get(1).giftPic).into(imageView12);

        Glide.with(context).load(bean.rankList.get(2).portrait_path_128).into(imageView31);
        textView31.setText(bean.rankList.get(2).nickName);
        textView32.setText(bean.rankList.get(2).giftName);
        Glide.with(context).load(bean.rankList.get(2).giftPic).into(imageView32);

        Log.e("=======1======","============="+bean.rankList.get(2).giftName);

        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.homexuanfu2, null);
        return convertView;
    }

}
