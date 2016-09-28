package com.example.user.kk.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Live_youngster_item_bean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import javax.security.auth.login.LoginException;


/**
 * Created by user on 2016/9/12.
 */
public class YoungsterFragment extends BaseFragment {
    private View view;
    public RecyclerView recyclerView;

    @Override
    public View initView() {
        view = View.inflate(getContext(), R.layout.live_fragment_youngster, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.live_fragment_youngster_recyclerView);




        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }

    @Override
    public void setData() {
        RequestParams params = new RequestParams("http://www.kktv1.com/CDN/output/M/1/I/20010302/P/a-1_c-211_cataId-26_start-0_offset-20_platform-2/json.js");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Live_youngster_item_bean bean = gson.fromJson(s, Live_youngster_item_bean.class);
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
        Live_youngster_item_bean bean;

         public MyAdapter(Live_youngster_item_bean bean) {
            this.bean = bean;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getContext(), R.layout.live_fragment_youngster_item, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder mholder = (MyViewHolder) holder;
            if (bean.roomList.get(position).liveType.equals("1")) {
                String ss = bean.pathPrefix + bean.roomList.get(position).poster_path_756;
                Glide.with(getContext()).load(ss).into(mholder.imageView);
                mholder.textView.setText(bean.roomList.get(position).nickname);
                mholder.textView1.setText(bean.roomList.get(position).onlineCount);
                mholder.imageView1.setImageResource(R.mipmap.kk_room_mem_count_left);
            } else {
                String ss = bean.pathPrefix + bean.roomList.get(position).poster_path_756;
                Glide.with(getContext()).load(ss).into(mholder.imageView);
                mholder.textView.setText(bean.roomList.get(position).nickname);
                mholder.imageView1.setImageResource(R.mipmap.kk_room_not_play_gray_icon);
                mholder.textView1.setText("休息中");
            }

        }

        @Override
        public int getItemCount() {
            return bean.roomList.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView imageView1;
        TextView textView;
        TextView textView1;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.youngter_item_iv);
            imageView1 = (ImageView) itemView.findViewById(R.id.youngter_item_iv1);
            textView = (TextView) itemView.findViewById(R.id.youngter_item_tv);
            textView1 = (TextView) itemView.findViewById(R.id.youngter_item_tv1);
        }
    }
}
