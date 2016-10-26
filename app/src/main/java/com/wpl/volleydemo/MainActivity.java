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

public class MainActivity extends AppCompatActivity {

    private String path = "http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        lv = (ListView) findViewById(R.id.lv);

        //获取数据
        getData();
    }

    /**
     * 获取数据
     */
    public void getData() {
        //请求的队列
        RequestQueue rqueque = Volley.newRequestQueue(MainActivity.this);
        //请求对象                    请求方式   地址    成功返回一个String
        StringRequest str = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//请求成功
                //解析
                Gson gson = new Gson();
                DataBean bean = gson.fromJson(response, DataBean.class);
                List<DataBean.DataEntity.ForumListEntity> forumList = bean.data.forum_list;

                //适配器
                lv.setAdapter(new MyAdapter(MainActivity.this, forumList));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //把请求的对象加入到消息队列
        rqueque.add(str);
        //开始
        rqueque.start();
    }
}
