package com.example.user.kk.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.media.RatingCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.activity.DynamicDetailsActivity;
import com.example.user.kk.activity.PersonalFileActivity;
import com.example.user.kk.bean.DynamicHotTopicBean;
import com.example.user.kk.bean.Live_year_item_bean;
import com.example.user.kk.view.XCFlowLayout;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/13.
 */
public class DynamicHotTopicFragment extends BaseFragment {
    private ListView LV;
    private LinearLayout dynamic_hotTopic_head;
    View viewHead;
    private DynamicHotTopicBean bean;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.dynamic_hot_topic, null);
        viewHead = View.inflate(getActivity(), R.layout.dynamic_hot_topic_head, null);
        dynamic_hotTopic_head = (LinearLayout) viewHead.findViewById(R.id.dynamic_hotTopic_head);
        LV = (ListView) view.findViewById(R.id.dynamic_hotTopic_LV);

        return view;
    }

    @Override
    public void setData() {
        RequestParams params = new RequestParams("http://api.kktv1.com:8080/meShow/entrance?parameter=%7B%22platform%22:2,%22token%22:%22A13D0D5DBFB954B3C2E0530C64A8C0DDD9%22,%22c%22:216,%22FuncTag%22:20000402,%22userId%22:112364888,%22a%22:1%7D");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(final String s) {
                Gson gson = new Gson();
                bean = gson.fromJson(s, DynamicHotTopicBean.class);
                //listView添加水平头布局
                for (int i = 0; i < bean.hotTopicList.size(); i++) {
                    View headViewItem = LayoutInflater.from(getActivity()).inflate(
                            R.layout.dynamic_hot_topic_headitem, null);
                    ImageView iv = (ImageView) headViewItem.findViewById(R.id.dynamic_hotTopic_horizontalRV_iv);
                    TextView tv = (TextView) headViewItem.findViewById(R.id.dynamic_hotTopic_horizontalRV_tv);
                    Glide.with(getContext()).load(bean.hotTopicList.get(i).imageUrl).into(iv);
                    if (bean.hotTopicList.get(i).content.length() > 4) {
                        tv.setText("#" + bean.hotTopicList.get(i).content.substring(0, 4) + "...");
                    } else {
                        tv.setText("#" + bean.hotTopicList.get(i).content);
                    }
                    dynamic_hotTopic_head.addView(headViewItem);
                }
                LV.addHeaderView(viewHead);
                MyListAdapter adapter = new MyListAdapter();
                LV.setAdapter(adapter);
                LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent =new Intent(getActivity(), DynamicDetailsActivity.class);
                        intent.putExtra("i",i);
                        intent.putExtra("str",s);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                throwable.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    public class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return bean.hotNewsList.size();
        }

        @Override
        public Object getItem(int i) {
            return bean.hotNewsList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            String str;
            if (bean.hotNewsList.get(i).picArray.size() > 1) {
                view = View.inflate(getActivity(), R.layout.dynamic_hot_topic_recyclerview1, null);
                ImageView nameImage = (ImageView) view.findViewById(R.id.dynamic_hotTopic_RV1_nameIV);
                nameImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView name = (TextView) view.findViewById(R.id.dynamic_hotTopic_RV1_name);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView time = (TextView) view.findViewById(R.id.dynamic_hotTopic_RV1_time);
                TextView content = (TextView) view.findViewById(R.id.dynamic_hotTopic_RV1_tv);
                GridView gv = (GridView) view.findViewById(R.id.dynamic_hotTopic_RV1_GV);
                XCFlowLayout xcFlowLayout = (XCFlowLayout) view.findViewById(R.id.dynamic_hotTopic_RV1_flowLayout);
                Glide.with(getActivity()).load(bean.pathPrefix + bean.hotNewsList.get(i).portrait_path_256).into(nameImage);
                name.setText(bean.hotNewsList.get(i).nickname);
                time.setText(bean.hotNewsList.get(i).publishedTime);
                if (bean.hotNewsList.get(i).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean.hotNewsList.get(i).topic + "#" + bean.hotNewsList.get(i).content;
                    int fstart = str.indexOf("#" + bean.hotNewsList.get(i).topic + "#");
                    String str1 = "#" + bean.hotNewsList.get(i).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean.hotNewsList.get(i).content);
                }

                MyGridView adapter = new MyGridView(i);
                gv.setAdapter(adapter);
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.leftMargin = 5;
                lp.rightMargin = 5;
                lp.topMargin = 5;
                lp.bottomMargin = 5;
                //流式布局
                if (bean.hotNewsList.get(i).commentList.size() > 0) {
                    for (int m = 0; m < bean.hotNewsList.get(i).commentList.size(); m++) {
                        TextView text = new TextView(getActivity());
                        text.setText(" " + bean.hotNewsList.get(i).commentList.get(m).content + " " + bean.hotNewsList.get(i).commentList.get(m).praiseNum + " ");
                        text.setTextColor(Color.GRAY);
                        text.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_xcflowlayout));
                        xcFlowLayout.addView(text, lp);
                    }
                }
            } else {
                view = View.inflate(getActivity(), R.layout.dynamic_hot_topic_recyclerview, null);
                ImageView nameImage = (ImageView) view.findViewById(R.id.dynamic_hotTopic_RV_nameIV);
                nameImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView name = (TextView) view.findViewById(R.id.dynamic_hotTopic_RV_name);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(), PersonalFileActivity.class);
                        startActivity(intent);
                    }
                });
                TextView time = (TextView) view.findViewById(R.id.dynamic_hotTopic_RV_time);
                TextView content = (TextView) view.findViewById(R.id.dynamic_hotTopic_RV_tv);
                ImageView imageView = (ImageView) view.findViewById(R.id.dynamic_hotTopic_RV_iv);
                XCFlowLayout xcFlowLayout = (XCFlowLayout) view.findViewById(R.id.dynamic_hotTopic_RV_XCFlowLayout);

                Glide.with(getActivity()).load(bean.pathPrefix + bean.hotNewsList.get(i).portrait_path_256).into(nameImage);
                name.setText(bean.hotNewsList.get(i).nickname);
                time.setText(bean.hotNewsList.get(i).publishedTime);
                if (bean.hotNewsList.get(i).topic != null) {
                    //改变一段字段的颜色
                    str = "#" + bean.hotNewsList.get(i).topic + "#" + bean.hotNewsList.get(i).content;
                    int fstart = str.indexOf("#" + bean.hotNewsList.get(i).topic + "#");
                    String str1 = "#" + bean.hotNewsList.get(i).topic + "#";
                    int fend = fstart + str1.length();
                    SpannableStringBuilder style = new SpannableStringBuilder(str);
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8200")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    content.setText(style);
                } else {
                    content.setText(bean.hotNewsList.get(i).content);
                }
                if (bean.hotNewsList.get(i).picArray.size() > 0) {
                    Glide.with(getActivity()).load(bean.pathPrefix + bean.hotNewsList.get(i).picArray.get(0).imageUrl_128).into(imageView);
                }
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.leftMargin = 5;
                lp.rightMargin = 5;
                lp.topMargin = 5;
                lp.bottomMargin = 5;
                //流式布局
                if (bean.hotNewsList.get(i).commentList.size() > 0) {
                    for (int m = 0; m < bean.hotNewsList.get(i).commentList.size(); m++) {
                        TextView text = new TextView(getActivity());
                        text.setText(" " + bean.hotNewsList.get(i).commentList.get(m).content + " " + bean.hotNewsList.get(i).commentList.get(m).praiseNum + " ");
                        text.setTextColor(Color.GRAY);
                        text.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_xcflowlayout));
                        xcFlowLayout.addView(text, lp);
                    }
                }
            }


            return view;
        }
    }

//    //重写GridView
//    public class DynamicGridView extends GridView {
//
//        public DynamicGridView(Context context, AttributeSet attrs, int defStyleAttr) {
//            super(context, attrs, defStyleAttr);
//        }
//
//        public DynamicGridView(Context context) {
//            super(context);
//        }
//
//        public DynamicGridView(Context context, AttributeSet attrs) {
//            super(context, attrs);
//        }
//
//        @Override
//        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//            super.onMeasure(widthMeasureSpec, expandSpec);
//        }
//    }

    public class MyGridView extends BaseAdapter {
        int position;

        public MyGridView(int position) {
            this.position = position;
        }

        @Override
        public int getCount() {
            return bean.hotNewsList.get(position).picArray.size();
        }

        @Override
        public Object getItem(int i) {
            return bean.hotNewsList.get(position).picArray.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(getActivity(), R.layout.dynamic_dynamic_grid_view_item, null);
            ImageView iv = (ImageView) view.findViewById(R.id.dynamic_dynamic_gird_view_iv);
            Glide.with(getActivity()).load(bean.pathPrefix + bean.hotNewsList.get(position).picArray.get(i).imageUrl_128).into(iv);

            return view;
        }
    }


}
