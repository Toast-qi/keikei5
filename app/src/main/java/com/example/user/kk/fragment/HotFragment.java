package com.example.user.kk.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.kk.R;
import com.example.user.kk.adapter.LiveFragmentHotHeaderAdapter;
import com.example.user.kk.adapter.MyLiveHotListAdapter;
import com.example.user.kk.bean.List_hot_viewPager_bean;
import com.example.user.kk.bean.Live_hot_item_bean;
import com.example.user.kk.utils.PinnedHeaderListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class HotFragment extends BaseFragment {

    PinnedHeaderListView listView;
    ViewPager viewPager;
    List<View> list;
    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private View view1;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.live_fragment_hot, null);
        listView = (PinnedHeaderListView) view.findViewById(R.id.pinnedListView);
        //头布局
        view1 = View.inflate(getContext(), R.layout.live_fragment_hot_header, null);
        viewPager = (ViewPager) view1.findViewById(R.id.live_fragment_hot_viewPager);
        LiveFragmentHotHeaderAdapter adapter = new LiveFragmentHotHeaderAdapter(getData());
        viewPager.setAdapter(adapter);
        return view;
    }

    @Override
    public void setData() {
        RequestParams params = new RequestParams("http://www.kktv1.com/CDN/output/M/1/I/55000003/P/a-1_c-216_start-0_offset-20_platform-2_type-2/json.js");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Live_hot_item_bean bean = gson.fromJson(s, Live_hot_item_bean.class);
                listView.addHeaderView(view1);
                MyLiveHotListAdapter adapter1 = new MyLiveHotListAdapter(bean, getContext());
                listView.setAdapter(adapter1);
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

    public List<View> getData() {
        final RequestParams params = new RequestParams("http://www.kktv1.com/CDN/output/M/1440/I/10002006/P/a-1_c-216_platform-2_isTop-1_version-78/json.js");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                List_hot_viewPager_bean bean = gson.fromJson(s, List_hot_viewPager_bean.class);
                Glide.with(getContext()).load(bean.activityList.get(0).imgURL).into(imageView);
                Glide.with(getContext()).load(bean.activityList.get(1).imgURL).into(imageView1);
                Glide.with(getContext()).load(bean.activityList.get(2).imgURL).into(imageView2);

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
        list = new ArrayList<>();
        View view11 = View.inflate(getContext(), R.layout.live_fragment_hot_viewpager_image, null);
        imageView = (ImageView) view11.findViewById(R.id.viewPager_iv);
        View view12 = View.inflate(getContext(), R.layout.live_fragment_hot_viewpager_image, null);
        imageView1 = (ImageView) view12.findViewById(R.id.viewPager_iv);
        View view13 = View.inflate(getContext(), R.layout.live_fragment_hot_viewpager_image, null);
        imageView2 = (ImageView) view13.findViewById(R.id.viewPager_iv);
        list.add(view11);
        list.add(view12);
        list.add(view13);

        return list;
    }
}
