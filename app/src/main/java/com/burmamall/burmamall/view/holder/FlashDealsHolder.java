package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burmamall.burmamall.R;

/**
 * Created by sand on 2018/2/2.
 */

public class FlashDealsHolder extends HomeBaseHolder{

    private RecyclerView recyclerView;

    public FlashDealsHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView getRecyclerView() {
        if (recyclerView == null){
            recyclerView = (RecyclerView) view.findViewById(R.id.home_flash_deals_item_recyclerview);
        }
        return recyclerView;
    }
}
