package com.example.user.kk.fragment;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Live_year_item_bean;
import com.example.user.kk.utils.HttpUtils;
import com.google.gson.Gson;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class YearFragment extends BaseFragment {
    private View view;
    public RecyclerView recyclerView;
    public List<Live_year_item_bean> list;
    public Live_year_item_bean bean;

    @Override
    public View initView() {
        view = View.inflate(getContext(), R.layout.live_fragment_year, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.live_fragment_year_recyclerView);
        //使用表格布局管理器
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }

    @Override
    public void setData() {
        RequestParams params = new RequestParams("http://www.kktv1.com/CDN/output/M/1/I/20010302/P/a-1_c-211_cataId-571_start-0_offset-20_platform-2/json.js");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {

                Gson gson = new Gson();
                bean = gson.fromJson(s, Live_year_item_bean.class);
                MyAdapter adapter = new MyAdapter(bean);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {


            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter {
        Live_year_item_bean bean;

        public MyAdapter(Live_year_item_bean bean) {
            this.bean = bean;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getContext(), R.layout.live_fragment_year_recyclerview_item, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder mholder = (MyViewHolder) holder;


            if (bean.roomList.get(position).liveType.equals(1)) {
                String ss = bean.pathPrefix + bean.roomList.get(position).poster_path_756;
//                Bitmap bitmap = HttpUtils.HttpGetBitmap(ss);
//                Matrix matrix = new Matrix();
//                matrix.postScale(2f,2f);
//                bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
//
//                mholder.imageView.setImageBitmap(bitmap);
                Glide.with(getContext()).load(ss).into(mholder.imageView);
                mholder.textView.setText(bean.roomList.get(position).nickname);
                mholder.textView1.setText(bean.roomList.get(position).roomTheme);
                mholder.imageView1.setImageResource(R.mipmap.kk_room_mem_count_left);
                mholder.textView2.setText(bean.roomList.get(position).onlineCount);
            } else {
                String ss = bean.pathPrefix + bean.roomList.get(position).poster_path_756;
                Glide.with(getContext()).load(ss).into(mholder.imageView);
                mholder.textView.setText(bean.roomList.get(position).nickname);
                mholder.textView1.setText(bean.roomList.get(position).roomTheme);
                mholder.imageView1.setImageResource(R.mipmap.kk_room_not_play_gray_icon);
                mholder.textView2.setText("休息中");
            }


        }

        @Override
        public int getItemCount() {
            return bean.roomList.size();
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        ImageView imageView1;
        TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.year_item_imageView);
            imageView1 = (ImageView) itemView.findViewById(R.id.year_item_iv);
            textView = (TextView) itemView.findViewById(R.id.year_item_tv);
            textView1 = (TextView) itemView.findViewById(R.id.year_item_tv1);
            textView2 = (TextView) itemView.findViewById(R.id.year_item_tv2);
        }
    }

}
