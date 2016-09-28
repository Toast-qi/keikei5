package com.example.user.kk.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.kk.R;
import com.example.user.kk.activity.MoreActivity;
import com.example.user.kk.bean.Live_home_list_item_bean;
import com.example.user.kk.bean.Live_hot_item_bean;
import com.example.user.kk.fragment.LiveFragment;
import com.example.user.kk.utils.SectionedBaseAdapter;
import com.example.user.kk.view.DynamicGridView;

/**
 * Created by user on 2016/9/19.
 */
public class MyLiveHomeListAdapter extends SectionedBaseAdapter {

    Live_home_list_item_bean bean;
    Context context;
    public MyLiveHomeListAdapter(Live_home_list_item_bean bean, Context context){
        this.bean=bean;
        this.context=context;
    }
    @Override
    public Object getItem(int section, int position) {
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        return 0;
    }

    @Override
    public int getSectionCount() {
        return 1;
    }

    @Override
    public int getCountForSection(int section) {
        return 1;
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
             convertView = View.inflate(context,R.layout.live_fragment_home_item,null);
        DynamicGridView gridView = (DynamicGridView) convertView.findViewById(R.id.live_fragment_home_gridview);
            LiveHomeGridViewAdapter adapter =new LiveHomeGridViewAdapter(bean,context);





        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "==", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }


    public View getSectionHeaderView(int section, View convertView, final ViewGroup parent) {
        if(convertView == null){
            convertView=View.inflate(context,R.layout.homexuanfu,null);

        }
        TextView textView = (TextView) convertView.findViewById(R.id.tv);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(context,MoreActivity.class);
                context.startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,MoreActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }


}
