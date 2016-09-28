package com.example.user.kk.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.activity.DynamicDetailsActivity;
import com.example.user.kk.activity.PersonalFileActivity;
import com.example.user.kk.view.DynamicGridView;
import com.example.user.kk.adapter.DynamicGridViewAdapter;
import com.example.user.kk.bean.DynamicAttentionBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by user on 2016/9/13.
 */
public class DynamicAttentionFragment extends BaseFragment {
    public DynamicAttentionBean bean;
    private ListView lv;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.dynamic_attention, null);
        lv = (ListView) view.findViewById(R.id.dynamic_attention_listView);
        return view;
    }

    @Override
    public void setData() {

        RequestParams params = new RequestParams(
                "http://api.kktv1.com:8080/meShow/entrance?parameter=%7B%22platform%22:2,%22start%22:0,%22token%22:%22A13D0D5DBFB954B3C2E0530C64A8C0DDD9%22,%22c%22:216,%22userId%22:112364888,%22a%22:1,%22offset%22:10,%22FuncTag%22:20000403%7D"
        );
        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(final String s) {
                Gson gson = new Gson();
                bean = gson.fromJson(s, DynamicAttentionBean.class);
                MyAdapter adapter = new MyAdapter();
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent =new Intent(getActivity(), DynamicDetailsActivity.class);
                        intent.putExtra("i",i);
                        intent.putExtra("strAttention",s);
                        startActivity(intent);
                    }
                });
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

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return bean.newsList.size();
        }

        @Override
        public Object getItem(int i) {
            return bean.newsList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            String str;
            if (bean.newsList.get(i).picArray.size() > 1) {
                view = View.inflate(getActivity(), R.layout.dynamic_attention_listview_item1, null);
                ImageView nameiv = (ImageView) view.findViewById(R.id.dynamic_attention_listView_item1_nameIV);
                nameiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView name = (TextView) view.findViewById(R.id.dynamic_attention_listView_item1_name);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView content = (TextView) view.findViewById(R.id.dynamic_attention_listView_item1_content);
                TextView time = (TextView) view.findViewById(R.id.dynamic_attention_listView_item1_time);
                DynamicGridView gv = (DynamicGridView) view.findViewById(R.id.dynamic_attention_item1_GV);

                Glide.with(getContext()).load(bean.pathPrefix + bean.newsList.get(i).portrait_path_128).into(nameiv);
                name.setText(bean.newsList.get(i).nickname);
                content.setText(bean.newsList.get(i).content);
                time.setText(bean.newsList.get(i).publishedTime);
                if (bean.newsList.get(i).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean.newsList.get(i).topic + "#" + bean.newsList.get(i).content;
                    int fstart = str.indexOf("#" + bean.newsList.get(i).topic + "#");
                    String str1 = "#" + bean.newsList.get(i).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean.newsList.get(i).content);
                }
                DynamicGridViewAdapter adapter = new DynamicGridViewAdapter(getActivity(), i, bean);
                gv.setAdapter(adapter);
                return view;
            } else {
                view = View.inflate(getActivity(), R.layout.dynamic_attention_listview_item, null);
                ImageView iv = (ImageView) view.findViewById(R.id.dynamic_attention_listView_item_iv);
                ImageView nameiv = (ImageView) view.findViewById(R.id.dynamic_attention_listView_item_nameIV);
                nameiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView name = (TextView) view.findViewById(R.id.dynamic_attention_listView_item_name);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView content = (TextView) view.findViewById(R.id.dynamic_attention_listView_item_content);
                TextView time = (TextView) view.findViewById(R.id.dynamic_attention_listView_item_time);
                if (bean.newsList.get(i).picArray.size() > 0) {
                    Glide.with(getContext()).load(bean.pathPrefix + bean.newsList.get(i).picArray.get(0).imageUrl_720).into(iv);
                }
                Glide.with(getContext()).load(bean.pathPrefix + bean.newsList.get(i).portrait_path_128).into(nameiv);
                name.setText(bean.newsList.get(i).nickname);
                time.setText(bean.newsList.get(i).publishedTime);
                if (bean.newsList.get(i).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean.newsList.get(i).topic + "#" + bean.newsList.get(i).content;
                    int fstart = str.indexOf("#" + bean.newsList.get(i).topic + "#");
                    String str1 = "#" + bean.newsList.get(i).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean.newsList.get(i).content);
                }

                return view;
            }
        }
    }


    //重写GridView
//    public class DynamicGridView extends GridView {
//
//
//        public DynamicGridView(Context context) {
//            super(context);
//        }
//
//
//        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//            super.onMeasure(widthMeasureSpec, expandSpec);
//        }
//    }

//    public class MyGridView extends BaseAdapter {
//        int position;
//        public MyGridView(int position){
//            this.position=position;
//        }
//
//        @Override
//        public int getCount() {
//            return bean.newsList.get(position).picArray.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return bean.newsList.get(i).picArray.get(i);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return i;
//        }
//


}
