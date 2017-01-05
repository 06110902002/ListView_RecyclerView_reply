package com.example.administrator.listreyclerview.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.listreyclerview.R;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ItemViewHolder> {
    Context mContext;
    private int i = 0;
    List<String> data = new ArrayList<>();
    ItemViewHolder viewHolder = null;

    public TestAdapter(Context context,List<String> data) {
        this.mContext = context;
        this.data = data;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycview_item, parent, false);
        viewHolder = new ItemViewHolder(view);

        i ++;
        System.out.println("29-------------------------"+i);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.mTextView.setText(data.get(position));
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ItemViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.name);
        }
    }

}