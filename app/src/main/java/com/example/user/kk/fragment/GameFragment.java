package com.example.user.kk.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Live_game_item_bean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class GameFragment extends BaseFragment {
    public RecyclerView recyclerView;
    public List<Live_game_item_bean> list;
    @Override
    public View initView() {
       View view = View.inflate(getContext(), R.layout.live_fragment_game,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.live_fragment_game_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        return view;
    }

    @Override
    public void setData() {
        RequestParams params = new RequestParams("http://www.kktv1.com/CDN/output/M/1/I/20010302/P/a-1_c-216_cataId-56_start-0_offset-20_platform-2/json.js");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Live_game_item_bean bean = gson.fromJson(s,Live_game_item_bean.class);
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

    class MyAdapter extends RecyclerView.Adapter{

        Live_game_item_bean bean;
        public MyAdapter(Live_game_item_bean bean) {
            this.bean=bean;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =View.inflate(getContext(),R.layout.live_fragment_game_recyclerview_item,null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder holder1= (MyViewHolder) holder;
            if (bean.roomList.get(position).liveType.equals("1")){
              String ss =bean.pathPrefix+bean.roomList.get(position).live_poster_756;
                Glide.with(getContext()).load(ss).into(holder1.imageView);
                holder1.textView.setText(bean.roomList.get(position).nickname);
                holder1.textView1.setText(bean.roomList.get(position).roomTheme);
                holder1.imageView1.setImageResource(R.mipmap.kk_room_mem_count_left);
                holder1.textView2.setText(bean.roomList.get(position).onlineCount);
            }else {
                String ss =bean.pathPrefix+bean.roomList.get(position).live_poster_756;
                Glide.with(getContext()).load(ss).into(holder1.imageView);
                holder1.textView.setText(bean.roomList.get(position).nickname);
                holder1.textView1.setText(bean.roomList.get(position).roomTheme);
                holder1.imageView1.setImageResource(R.mipmap.kk_room_not_play_gray_icon);
                holder1.textView2.setText("休息中");
            }

        }

        @Override
        public int getItemCount() {
            return bean.roomList.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        ImageView imageView1;
        TextView textView;
        TextView textView1;
        TextView textView2;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.game_item_imageView);
            imageView1= (ImageView) itemView.findViewById(R.id.game_item_imageView1);
            textView= (TextView) itemView.findViewById(R.id.game_item_tv);
            textView1= (TextView) itemView.findViewById(R.id.game_item_tv1);
            textView2= (TextView) itemView.findViewById(R.id.game_item_tv2);
        }
    }
}
