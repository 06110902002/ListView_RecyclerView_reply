package com.example.administrator.listreyclerview.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.administrator.listreyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */

public class RecycViewActivity extends Activity {

    private RecyclerView mList;
    private List<String> Data = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycview);

        for (int i = 0; i < 50; i++) {
            Data.add("text" + i);
        }

        mList = (RecyclerView) findViewById(R.id.rv_list);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new TestAdapter(this,Data));
    }
}
