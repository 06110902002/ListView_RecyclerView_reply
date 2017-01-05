package com.example.administrator.listreyclerview.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.administrator.listreyclerview.R;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<String> listViewData;
    private Context mContext;

    private int i = 0;  //listView中的itemview创建次数
    private int j = 0;  //listView中的itemview复用次数

    public ListViewAdapter(List<String> listViewData, Context mContext) {
        this.listViewData = listViewData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listViewData.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 这个方法调用时机为：在每一个item从不可见变为可见的时候
     * 1.如果不采取复用机制，那么，即使已经创建过的view，重新从不可见，到可见的过程时，依然是再创建一次，
     * 这样会大影响性能的
     *
     * @param position
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        /**
         * 不复用时，设置数据时，创建次数 测试
         */
       /* View item = View.inflate(mContext, R.layout.listview_item, null);
        //找到文本框
        TextView tv = (TextView) item.findViewById(R.id.tv);
        //设置文本内容
        tv.setText(listViewData.get(position));

        //找到复选框
        CheckBox cb = (CheckBox) item.findViewById(R.id.cb);

        if (position % 2 != 0) { //如果是奇数
            cb.setChecked(true);
        }*/
        /**----------------------测试完毕--------------------**/

        /**第一种复用方式，不采用ViewHolder保存
         * 这种方式复用时，依然会出现：即使已经创建过的view，重新从不可见，到可见的过程时，依然是再创建一次，
         * 这样会大影响性能的
         *
         */

        /*View item = null;

        if (view == null) {
            item = View.inflate(mContext, R.layout.listview_item, null);
            i ++;
            System.out.println("86-------------------------"+i);
        }else{
            item = view;
            j ++;
            //System.out.println("90-------------------------"+j);
        }

        //找到文本框
        TextView tv = (TextView) item.findViewById(R.id.tv);
        //设置文本内容
        tv.setText(listViewData.get(position));

        //找到复选框
        CheckBox cb = (CheckBox) item.findViewById(R.id.cb);
        cb.setChecked(false);
        if(position % 2 == 0){ //如果是奇数
            cb.setChecked(true);
        }*/
        /**----------------------第一种复用方式，不采用ViewHolder保存-------------------------*/


        //Item对应的试图
        View item = null;

        ViewHolder vh = null;

        if (view == null) {
            item = View.inflate(mContext, R.layout.listview_item, null);
            vh = new ViewHolder();
            //找到文本框
            vh.tv = (TextView) item.findViewById(R.id.tv);
            //找到复选框
            vh.cb = (CheckBox) item.findViewById(R.id.cb);
            //让item和ViewHolder绑定在一起
            item.setTag(vh);

            i ++;
            System.out.println("123-------------------------"+i);
        } else {
            //复用ListView给的View
            item = view;
            //拿出ViewHolder
            vh = (ViewHolder) item.getTag();
        }

        //设置文本内容
        vh.tv.setText(listViewData.get(position));

        //还原状态
        vh.cb.setChecked(false);

        if (position % 2 == 0) { //如果是奇数
            vh.cb.setChecked(true);
        }

        return item;
    }

    /**
     * 第二种复用方式：这种方式可以优化每次设置数据时，通过findViewByid()的方式来寻找控件，
     * 因为在创建视图的时候，listView的itemview中的控件已经被绑定到ViewHolder上了
     * 所以下次复用的时候，直接可以通过ViewHolde中的对应的控件设置其值即可
     * 
     *
     * 用于存放一个ItemView中的控件,由于这里只有两个控件,那么声明两个控件即可
     */
    class ViewHolder {
        TextView tv;
        CheckBox cb;
    }

}
