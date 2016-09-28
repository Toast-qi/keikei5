package com.example.user.kk.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.bean.Me_Family_Bean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MeFamilyActivity extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_family);
        imageView = (ImageView) findViewById(R.id.image_mefamily);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeFamilyActivity.this.finish();
            }
        });
        initview();
        setData();
    }

    private View initview() {

        recyclerView = (RecyclerView) findViewById(R.id.me_family_RecycylerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MeFamilyActivity.this, 2));
        return null;
    }

    private void setData() {
        RequestParams params = new RequestParams("http://api.kktv1.com:8080/meShow/entrance?parameter=%7B%22platform%22:2,%22offset%22:20,%22start%22:0,%22c%22:216,%22FuncTag%22:10008001,%22a%22:1%7D");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Me_Family_Bean me_family_bean = gson.fromJson(s, Me_Family_Bean.class);
                Log.e("sssssss", "onSuccess: " + me_family_bean.familyList.get(3).familyName);
                MyAdapter adapter = new MyAdapter(me_family_bean);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("sssssss", "onError: " );

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
        Me_Family_Bean me_family_bean;

        public MyAdapter(Me_Family_Bean me_family_bean) {
            this.me_family_bean = me_family_bean;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view1 = View.inflate(MeFamilyActivity.this, R.layout.activity_mefamilyfrag_item, null);
            MyViewHolder viewHolder = new MyViewHolder(view1);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder holder1 = (MyViewHolder) holder;
            String q = me_family_bean.pathPrefix + me_family_bean.familyList.get(position).familyPoster.path_222;
            Glide.with(MeFamilyActivity.this).load(q).into(holder1.imageView);
            holder1.textView1.setText(me_family_bean.familyList.get(position).familyName);
            holder1.family_item_tv2.setText(me_family_bean.familyList.get(position).familyLeader);
            holder1.family_item_tv3.setText(me_family_bean.familyList.get(position).actorCount+"人");
            holder1.family_item_tv4.setText(me_family_bean.familyList.get(position).memberCount+"人");
        }

        @Override
        public int getItemCount() {
            return me_family_bean.familyList.size();
        }

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, family_item_tv2, family_item_tv3, family_item_tv4;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.family_item_imageView);
            textView1 = (TextView) itemView.findViewById(R.id.family_item_tv1);
            family_item_tv2 = (TextView) itemView.findViewById(R.id.family_item_tv2);
            family_item_tv3 = (TextView) itemView.findViewById(R.id.family_item_tv3);
            family_item_tv4 = (TextView) itemView.findViewById(R.id.family_item_tv4);

        }
    }

}