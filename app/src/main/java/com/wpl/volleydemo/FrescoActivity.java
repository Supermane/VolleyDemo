package com.wpl.volleydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

public class FrescoActivity extends AppCompatActivity {

    private ListView lv;
    private String path = "http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);

        //获取控件
        lv = (ListView) findViewById(R.id.lv);

        new Thread(){
            @Override
            public void run() {
                super.run();
                //获取数据
                getData();
            }
        }.start();

    }

    /**
     * 获取数据
     */
    public void getData() {
        //请求队列
        RequestQueue rq = Volley.newRequestQueue(FrescoActivity.this);
        //请求对象
        StringRequest sr = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                DataBean bean = gson.fromJson(response, DataBean.class);
                List<DataBean.DataEntity.ForumListEntity> forum_list = bean.data.forum_list;
                List<DataBean.DataEntity.ForumListEntity.GroupEntity> Imglist = forum_list.get(0).group;

                lv.setAdapter(new ImgAdapter(FrescoActivity.this,Imglist));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //把请求的对象加入到消息队列
        rq.add(sr);
        //开始
        rq.start();
    }
}
