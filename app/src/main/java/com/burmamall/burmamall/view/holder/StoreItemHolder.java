package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.widget.RoundImageView;

/**
 * Created by sand on 2018/2/2.
 */

public class StoreItemHolder extends HomeBaseHolder{

    private RecyclerView recyclerView;
    private RoundImageView storeIcon;
    private TextView storeName;
    private TextView storeTitle;

    public StoreItemHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView getRecyclerView() {
        if (recyclerView == null){
            recyclerView = (RecyclerView) view.findViewById(R.id.store_item_store_recyclerview);
        }
        return recyclerView;
    }

    public RoundImageView getStoreIcon() {
        if (storeIcon == null){
            storeIcon = (RoundImageView) view.findViewById(R.id.store_item_store_icon);
        }
        return storeIcon;
    }

    public TextView getStoreName() {
        if (storeName == null){
            storeName = (TextView) view.findViewById(R.id.store_item_store_name);
        }
        return storeName;
    }

    public TextView getStoreTitle() {
        if (storeTitle == null){
            storeTitle = (TextView) view.findViewById(R.id.store_item_store_title);
        }
        return storeTitle;
    }
}
