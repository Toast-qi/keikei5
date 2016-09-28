package com.example.user.kk.fragment;

import android.graphics.Bitmap;
import android.media.tv.TvContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.kk.R;

import org.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2016/9/12.
 */
public class NewsFragment extends BaseFragment {
    ListView listView;
    List<Map> list;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.news_fragment, null);
        listView = (ListView) view.findViewById(R.id.news_fragment_listView);

        return view;
    }

    @Override
    public void setData() {
//        RequestParams params = new RequestParams("");
        list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> map1 = new HashMap<>();
        Map<Object, Object> map2 = new HashMap<>();
        Map<Object, Object> map3 = new HashMap<>();
//        ListData data = new ListData(R.mipmap.kk_news_praise, "赞", "暂无消息", null);
//        ListData data1 = new ListData(R.mipmap.kk_news_bullntei, "新鲜时报", "暂无消息", null);
//        ListData data2 = new ListData(R.mipmap.kk_news_dynamic, "动态评论", "暂无消息", null);
//        ListData data3 = new ListData(R.mipmap.kk_news_sysmsg, "系统消息", "暂无消息", null);
        map.put("image", R.mipmap.kk_news_praise);
        map.put("name", "赞");
        map.put("content", "暂无消息");
        map.put("time", null);
        list.add(map);
        map1.put("image", R.mipmap.kk_news_bullntei);
        map1.put("name", "新鲜时报");
        map1.put("content", "暂无消息");
        map1.put("time", null);
        list.add(map1);
        map2.put("image", R.mipmap.kk_news_dynamic);
        map2.put("name", "动态评论");
        map2.put("content", "暂无消息");
        map2.put("time", null);
        list.add(map2);
        map3.put("image", R.mipmap.kk_news_sysmsg);
        map3.put("name", "系统消息");
        map3.put("content", "暂无消息");
        map3.put("time", null);
        list.add(map3);
        MyAdapter adapter=new MyAdapter();
        listView.setAdapter(adapter);
    }

    public class ListData {

//        int nameimage;
//        String name;
//        String content;
//        String time;
//        Bitmap bitmap;
//
//        public ListData(int nameimage, String name, String content, String time) {
//            this.nameimage = nameimage;
//            this.name = name;
//            this.content = content;
//            this.time = time;
//        }
//        public ListData(Bitmap bitmap, String name, String content, String time) {
//            this.bitmap = bitmap;
//            this.name = name;
//            this.content = content;
//            this.time = time;
//        }

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(getActivity(), R.layout.news_listview_item, null);
            ImageView nameImage = (ImageView) view.findViewById(R.id.news_listView_item_nameIv);
            TextView name = (TextView) view.findViewById(R.id.news_listView_item_nameTv);
            TextView time = (TextView) view.findViewById(R.id.news_listView_item_time);
            TextView content = (TextView) view.findViewById(R.id.news_listView_item_content);
            nameImage.setImageResource((Integer) list.get(i).get("image"));
            content.setText(list.get(i).get("content").toString());
//            time.setText(list.get(i).get("time").toString());
            name.setText(list.get(i).get("name").toString());
            return view;
        }
    }
}
