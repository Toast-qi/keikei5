package com.example.user.kk.fragment;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;


import com.example.user.kk.R;
import com.example.user.kk.activity.SeekActivity;
import com.example.user.kk.activity.TabActivity;
import com.example.user.kk.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/12.
 */
public class LiveFragment extends BaseFragment implements View.OnClickListener {

    public TabLayout tabLayout;
    public ViewPager viewPager;
    public List<Fragment> list;
    public List<String> listtitle;
    public ImageView imageView1;
    public ImageView imageView2;
    private HotFragmentBroadcastReceiver broadcastReceiver;

    @Override
    public View initView() {

        //广播的注册
        HotFragmentBroadcastReceiver  broadcastReceiver = new HotFragmentBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("xuanze");
        getActivity().registerReceiver(broadcastReceiver,filter);

        View view = View.inflate(getContext(), R.layout.live_fragment,null);
        tabLayout= (TabLayout) view.findViewById(R.id.live_tb);
        viewPager= (ViewPager) view.findViewById(R.id.live_vp);


        imageView1= (ImageView) view.findViewById(R.id.live_seek_iv);
        imageView2= (ImageView) view.findViewById(R.id.live_right_iv);
        imageView1.setOnClickListener(this);

        imageView2.setOnClickListener(this);

        return view;
    }

    @Override
    public void setData() {
        //viewpager 里面放的5个fragment
        list=new ArrayList<>();
        list.add(new HomepageFragment());
        list.add(new HotFragment());
        list.add(new YearFragment());
        list.add(new YoungsterFragment());
        list.add(new GameFragment());
        //tablayout 标题
        listtitle=new ArrayList<>();
        listtitle.add(this.getString(R.string.live_tab_homepage));
        listtitle.add(this.getString(R.string.live_tab_hot));
        listtitle.add(this.getString(R.string.live_tab_year));
        listtitle.add(this.getString(R.string.live_tab_youngster));
        listtitle.add(this.getString(R.string.live_tab_game));

        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager(),list,listtitle);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.live_seek_iv:
                Intent intent = new Intent(getActivity(), SeekActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.translate_in,R.anim.translate_out);
                break;
            case R.id.live_right_iv:
                Intent intent1 = new Intent(getActivity(), TabActivity.class);
                startActivity(intent1);
              getActivity().overridePendingTransition(R.anim.translate_in,R.anim.translate_out);
                break;
            default:
                break;
        }
    }

    class HotFragmentBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getIntExtra("key",7)){
                case 0:
                    viewPager.setCurrentItem(0);
                    break;
                case 1:
                    viewPager.setCurrentItem(1);
                    break;
                case 2:
                    viewPager.setCurrentItem(2);
                    break;
                case 3:
                    viewPager.setCurrentItem(3);
                    break;
                case 4:
                    viewPager.setCurrentItem(4);
                    break;

            }
        }
    }

}
