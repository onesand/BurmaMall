package com.burmamall.burmamall.widget.adapter;

/**
 * Created by sand on 2018/2/2.
 */

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ouhimehime on 16/5/4.
 * -----适配器=------
 */
public abstract class BaseAutoAdapter {


    public abstract int getCounts(); //返回数据数量

    public abstract Object getItem(int position); //当前Item的数据

    public abstract View getItemView(int position, ViewGroup parent); //返回Item的布局


}