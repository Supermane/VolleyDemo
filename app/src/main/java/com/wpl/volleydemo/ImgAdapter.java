package com.wpl.volleydemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 王鹏龙 on 2016/10/27.
 */
public class ImgAdapter extends BaseAdapter {

    Context context;
    List<DataBean.DataEntity.ForumListEntity.GroupEntity> imglist;

    public ImgAdapter(Context context, List<DataBean.DataEntity.ForumListEntity.GroupEntity> imglist) {
        this.context = context;
        this.imglist = imglist;
    }

    @Override
    public int getCount() {
        return imglist.size();
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
            convertView = View.inflate(context, R.layout.fresco_item, null);
        }
        SimpleDraweeView img = (SimpleDraweeView) convertView.findViewById(R.id.fresco_img);

        img.setImageURI(imglist.get(position).photo);

        return convertView;
    }
}
