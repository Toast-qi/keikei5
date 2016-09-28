package com.example.user.kk.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.adapter.DynamicGridViewAdapter;
import com.example.user.kk.bean.DynamicAttentionBean;
import com.example.user.kk.bean.DynamicHotTopicBean;
import com.example.user.kk.view.XCFlowLayout;
import com.google.gson.Gson;

public class DynamicDetailsActivity extends AppCompatActivity {

    private ImageView nameImage;
    private TextView name;
    private TextView time;
    private TextView content;
    private GridView gv;
    private ListView listView;
    int num;
    private String str;
    private DynamicHotTopicBean bean;
    private ImageView Image;
    private ImageView close;
    String TAG = "tag";
    private String ststrAttention;
    private DynamicAttentionBean bean1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_details);
        Intent intent = getIntent();
        str = intent.getStringExtra("str");
        ststrAttention = intent.getStringExtra("strAttention");
        if (str==null){
            num = intent.getIntExtra("i", 0);
        }else {
            num = intent.getIntExtra("i", 0)-1;
        }
        initView();
        onSetData();
    }

    private void initView() {
        nameImage = (ImageView) findViewById(R.id.dynamic_attention_details_nameIV);
        nameImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DynamicDetailsActivity.this, PersonalFileActivity.class);
                startActivity(intent);
            }
        });
        name = (TextView) findViewById(R.id.dynamic_attention_details_name);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DynamicDetailsActivity.this, PersonalFileActivity.class);
                startActivity(intent);
            }
        });
        time = (TextView) findViewById(R.id.dynamic_attention_details_time);
        content = (TextView) findViewById(R.id.dynamic_attention_details_content);
        gv = (GridView) findViewById(R.id.dynamic_attention_details_gv);
        Image = (ImageView) findViewById(R.id.dynamic_attention_details_iv);
        close = (ImageView) findViewById(R.id.dynamic_attention_details_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.dynamic_attention_details_ListView);
    }

    private void onSetData() {
        Gson gson = new Gson();
        if (ststrAttention == null) {
            bean = gson.fromJson(str, DynamicHotTopicBean.class);

            if (bean.hotNewsList.get(num).picArray.size() > 1) {
                Glide.with(this).load(bean.pathPrefix + bean.hotNewsList.get(num).portrait_path_256).into(nameImage);
                name.setText(bean.hotNewsList.get(num).nickname);
                time.setText(bean.hotNewsList.get(num).publishedTime);
                if (bean.hotNewsList.get(num).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean.hotNewsList.get(num).topic + "#" + bean.hotNewsList.get(num).content;
                    int fstart = str.indexOf("#" + bean.hotNewsList.get(num).topic + "#");
                    String str1 = "#" + bean.hotNewsList.get(num).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean.hotNewsList.get(num).content);
                }

                GridViewAdapter adapter = new GridViewAdapter();
                gv.setAdapter(adapter);
                ListViewAdapter myAdapter = new ListViewAdapter();
                listView.setAdapter(myAdapter);

            } else {
                Glide.with(this).load(bean.pathPrefix + bean.hotNewsList.get(num).portrait_path_256).into(nameImage);
                name.setText(bean.hotNewsList.get(num).nickname);
                time.setText(bean.hotNewsList.get(num).publishedTime);
                Log.e(TAG, "onCreate: " + bean.hotNewsList.get(num).publishedTime);
                if (bean.hotNewsList.get(num).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean.hotNewsList.get(num).topic + "#" + bean.hotNewsList.get(num).content;
                    int fstart = str.indexOf("#" + bean.hotNewsList.get(num).topic + "#");
                    String str1 = "#" + bean.hotNewsList.get(num).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean.hotNewsList.get(num).content);
                }
                if (bean.hotNewsList.get(num).picArray.size() > 0) {
                    Glide.with(this).load(bean.pathPrefix + bean.hotNewsList.get(num).picArray.get(0).imageUrl_128).into(Image);
                }
                ListViewAdapter myAdapter = new ListViewAdapter();
                listView.setAdapter(myAdapter);

            }
        } else {
            bean1 = gson.fromJson(ststrAttention, DynamicAttentionBean.class);

            if (bean1.newsList.get(num).picArray.size() > 1) {
                Glide.with(this).load(bean1.pathPrefix + bean1.newsList.get(num).portrait_path_128).into(nameImage);
                name.setText(bean1.newsList.get(num).nickname);
                time.setText(bean1.newsList.get(num).publishedTime);
                if (bean1.newsList.get(num).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean1.newsList.get(num).topic + "#" + bean1.newsList.get(num).content;
                    int fstart = str.indexOf("#" + bean1.newsList.get(num).topic + "#");
                    String str1 = "#" + bean1.newsList.get(num).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean1.newsList.get(num).content);
                }

                DynamicGridViewAdapter adapter = new DynamicGridViewAdapter(this,num,bean1);
                gv.setAdapter(adapter);
                AttentionListViewAdapter myAdapter=new AttentionListViewAdapter();
                listView.setAdapter(myAdapter);

            } else {
                Glide.with(this).load(bean1.pathPrefix + bean1.newsList.get(num).portrait_path_128).into(nameImage);
                name.setText(bean1.newsList.get(num).nickname);
                time.setText(bean1.newsList.get(num).publishedTime);
                Log.e(TAG, "onCreate: "+bean1.newsList.get(num).publishedTime);
                if (bean1.newsList.get(num).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean1.newsList.get(num).topic + "#" + bean1.newsList.get(num).content;
                    int fstart = str.indexOf("#" + bean1.newsList.get(num).topic + "#");
                    String str1 = "#" + bean1.newsList.get(num).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean1.newsList.get(num).content);
                }
                if (bean1.newsList.get(num).picArray.size() > 0) {
                    Glide.with(this).load(bean1.pathPrefix + bean1.newsList.get(num).picArray.get(0).imageUrl_128).into(Image);
                }
                AttentionListViewAdapter myAdapter=new AttentionListViewAdapter();
                listView.setAdapter(myAdapter);

            }

        }

    }

    private class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return bean.hotNewsList.get(num).commentList.size() > 0 ? bean.hotNewsList.get(num).commentList.size() : 0;
        }

        @Override
        public Object getItem(int i) {
            return bean.hotNewsList.get(num).commentList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(DynamicDetailsActivity.this, R.layout.dynamic_details_listview, null);
            ImageView image = (ImageView) view.findViewById(R.id.dynamic_attention_details_listview_iv);
            Log.e(TAG, "getView++: " + bean.hotNewsList.get(num).commentList.get(i).portrait_path);
            Log.e(TAG, "getView: " + bean.pathPrefix + bean.hotNewsList.get(num).commentList.get(i).portrait_path);
            Glide.with(DynamicDetailsActivity.this).load(bean.pathPrefix + bean.hotNewsList.get(num).commentList.get(i).portrait_path).into(image);
            TextView content = (TextView) view.findViewById(R.id.dynamic_attention_details_listview_tv);
            content.setText(" " + bean.hotNewsList.get(num).commentList.get(i).content + " " + bean.hotNewsList.get(num).commentList.get(i).praiseNum + " ");
            return view;
        }
    }

    public class GridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return bean.hotNewsList.get(num).picArray.size();
        }

        @Override
        public Object getItem(int i) {
            return bean.hotNewsList.get(num).picArray.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(DynamicDetailsActivity.this, R.layout.dynamic_attention_grid_view_item, null);
            ImageView iv = (ImageView) view.findViewById(R.id.dynamic_attention_gird_view_iv);
            Glide.with(DynamicDetailsActivity.this).load(bean.pathPrefix + bean.hotNewsList.get(num).picArray.get(i).imageUrl_128).into(iv);
            return view;
        }
    }
    private class AttentionListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return bean1.newsList.get(num).commentList.size() > 0 ? bean1.newsList.get(num).commentList.size() : 0;
        }

        @Override
        public Object getItem(int i) {
            return bean1.newsList.get(num).commentList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(DynamicDetailsActivity.this, R.layout.dynamic_details_listview, null);
//            ImageView image = (ImageView) view.findViewById(R.id.dynamic_attention_details_listview_iv);
//            Glide.with(DynamicDetailsActivity.this).load(bean1.pathPrefix + bean1.newsList.get(num).commentList.get(i).portrait_path).into(image);
            TextView content = (TextView) view.findViewById(R.id.dynamic_attention_details_listview_tv);
            content.setText(" " + bean1.newsList.get(num).commentList.get(i).content + " " + bean1.newsList.get(num).commentList.get(i).praiseNum + " ");
            return view;
        }
    }


}
