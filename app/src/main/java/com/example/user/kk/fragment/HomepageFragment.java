package com.example.user.kk.fragment;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.kk.R;
import com.example.user.kk.adapter.MyLiveHomeListAdapter;
import com.example.user.kk.adapter.MyLiveHomeListAdapter1;
import com.example.user.kk.bean.Live_home_list_item2_bean;
import com.example.user.kk.bean.Live_home_list_item_bean;
import com.example.user.kk.utils.PinnedHeaderListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by user on 2016/9/12.
 */
public class HomepageFragment extends BaseFragment {

    PinnedHeaderListView listView,listView1;
    ImageView imageView1,imageView2,imageView3,imageView4;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    private View view1;
    private View view2;

    @Override
    public View initView() {
       View view =View.inflate(getContext(), R.layout.live_fragment_home,null);
        listView= (PinnedHeaderListView) view.findViewById(R.id.home_pinnedListView);

        //头布局
        initView1();
      //  initView2();
        //  setData1();
        //尾部局
        return view;
    }


    @Override
    public void setData() {
        RequestParams params = new RequestParams("http://api.kktv1.com:8080/meShow/entrance?parameter=%7B%22platform%22:2,%22offset%22:14,%22start%22:0,%22c%22:221,%22FuncTag%22:55000002,%22a%22:1%7D");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Live_home_list_item_bean bean =gson.fromJson(s,Live_home_list_item_bean.class);
                listView.addHeaderView(view1);
             //  listView.addFooterView(view2);
                MyLiveHomeListAdapter adapter = new MyLiveHomeListAdapter(bean,getContext());
                listView.setAdapter(adapter);

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


    private void initView1() {
         view1 =View.inflate(getContext(),R.layout.live_fragment_home_header,null);
        imageView1= (ImageView) view1.findViewById(R.id.live_fragment_home_header1_iv);
        tv1= (TextView) view1.findViewById(R.id.live_fragment_home_header1_tv);
        tv2= (TextView) view1.findViewById(R.id.live_fragment_home_header1_tv1);

        imageView2= (ImageView) view1.findViewById(R.id.live_fragment_home_header2_iv);
        tv3= (TextView) view1.findViewById(R.id.live_fragment_home_header2_tv);
        tv4= (TextView) view1.findViewById(R.id.live_fragment_home_header2_tv1);

        imageView3= (ImageView) view1.findViewById(R.id.live_fragment_home_header3_iv);
        tv5= (TextView) view1.findViewById(R.id.live_fragment_home_header3_tv);
        tv6= (TextView) view1.findViewById(R.id.live_fragment_home_header3_tv1);

        imageView4= (ImageView) view1.findViewById(R.id.live_fragment_home_header4_iv);
        tv7= (TextView) view1.findViewById(R.id.live_fragment_home_header4_tv);
        tv8= (TextView) view1.findViewById(R.id.live_fragment_home_header4_tv1);


    }

//    private void initView2() {
//        view2 = View.inflate(getContext(),R.layout.live_fragment_home2,null);
//
//        listView1= (PinnedHeaderListView) view2.findViewById(R.id.home_pinnedListView2);
//        Log.e("===11111=========", "initView2: ");
//        RequestParams params1 = new RequestParams("http://api.kktv1.com:8080/meShow/entrance?parameter=%7B%22platform%22:2,%22c%22:211,%22FuncTag%22:10002011,%22userId%22:112364321,%22a%22:1%7D");
//        x.http().get(params1, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String s) {
//                Log.e("===22222=========", "initView2: "+s);
//                Gson gson = new Gson();
//                Live_home_list_item2_bean bean1 =gson.fromJson(s,Live_home_list_item2_bean.class);
//                Log.e("===33333333=========", "initView2: "+bean1.rankList.size());
//                MyLiveHomeListAdapter1 adapter1 = new MyLiveHomeListAdapter1(bean1,getContext());
//                listView1.setAdapter(adapter1);
//                listView1.addHeaderView(view1);
//                Log.e("===444444=========", "initView2: ");
//            }
//
//            @Override
//            public void onError(Throwable throwable, boolean b) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException e) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//    }



}
