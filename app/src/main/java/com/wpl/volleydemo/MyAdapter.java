package com.wpl.volleydemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 王鹏龙 on 2016/10/26.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<DataBean.DataEntity.ForumListEntity> forumList;

    public MyAdapter(Context context, List<DataBean.DataEntity.ForumListEntity> forumList) {
        this.context = context;
        this.forumList = forumList;
    }

    @Override
    public int getCount() {
        return forumList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView=View.inflate(context,R.layout.item,null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        tv.setText(forumList.get(position).name);
        return convertView;
    }
}
