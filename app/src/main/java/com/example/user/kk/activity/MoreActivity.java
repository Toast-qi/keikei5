package com.example.user.kk.activity;

import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.RecommendBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MoreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        setData();
    }

    private void setData() {
        RequestParams params = new RequestParams("http://api.kktv1.com:8080/meShow/entrance?parameter=%7B%22platform%22:2,%22offset%22:20,%22start%22:0,%22c%22:211,%22FuncTag%22:55000002,%22a%22:1%7D");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                RecommendBean bean =gson.fromJson(s,RecommendBean.class);
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

    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.tuijianrecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        imageView= (ImageView) findViewById(R.id.tuijian_iv);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    class MyAdapter extends RecyclerView.Adapter{

        RecommendBean bean;
        public MyAdapter(RecommendBean bean) {
            this.bean = bean;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =View.inflate(MoreActivity.this,R.layout.recommend_recycler_item,null);
            MyViewHolder myViewHolder = new MyViewHolder(view);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                     MyViewHolder mholder = (MyViewHolder) holder;
            String ss =bean.pathPrefix+bean.roomList.get(position).poster_path_756;
            Glide.with(MoreActivity.this).load(ss).into(mholder.imageView);
            mholder.textView.setText(bean.roomList.get(position).roomTheme);
            mholder.textView1.setText(bean.roomList.get(position).nickname);
            mholder.textView2.setText(bean.roomList.get(position).onlineCount);
            mholder.imageView1.setImageResource(R.mipmap.kk_room_mem_count_left);
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
            imageView= (ImageView) itemView.findViewById(R.id.recommend_item_iv);
            imageView1= (ImageView) itemView.findViewById(R.id.recommend_item_iv2);
            textView= (TextView) itemView.findViewById(R.id.recommend_item_tv);
            textView1= (TextView) itemView.findViewById(R.id.recommend_item_tv1);
            textView2= (TextView) itemView.findViewById(R.id.recommend_item_tv2);
        }
    }
}
