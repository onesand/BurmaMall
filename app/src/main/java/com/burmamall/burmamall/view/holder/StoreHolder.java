package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burmamall.burmamall.R;

/**
 * Created by sand on 2018/2/2.
 */

public class StoreHolder extends HomeBaseHolder{

    private RecyclerView recyclerView;

    public StoreHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView getRecyclerView() {
        if (recyclerView == null){
            recyclerView = (RecyclerView) view.findViewById(R.id.store_item_store_recyclerview);
        }
        return recyclerView;
    }
}
