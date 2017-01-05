package com.example.administrator.listreyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.administrator.listreyclerview.listview.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    private BaseAdapter listViewAdapter;

    private List<String> listViewData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 50; i++) {
            listViewData.add("text" + i);
        }

        lv = (ListView) findViewById(R.id.lv);

        listViewAdapter = new ListViewAdapter(listViewData, this);

        lv.setAdapter(listViewAdapter);

    }

}
