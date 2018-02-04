package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.burmamall.burmamall.R;

/**
 * Created by sand on 2018/2/2.
 */

public class HotBrandHolder extends HomeBaseHolder{

    private RecyclerView recyclerView;
    private ImageView headIcon;

    public HotBrandHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView getRecyclerView() {
        if (recyclerView == null){
            recyclerView = (RecyclerView) view.findViewById(R.id.home_hot_brand_item_recyclerview);
        }
        return recyclerView;
    }

    public ImageView getHeadIcon() {
        if (headIcon == null){
            headIcon = (ImageView) view.findViewById(R.id.home_hot_brand_item_head_icon);
        }
        return headIcon;
    }
}
