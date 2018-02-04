package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.widget.RoundImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by sand on 2018/2/2.
 */

public class GuessYouLikeHolder extends HomeBaseHolder{

    private RecyclerView recyclerView;
//    private SmartRefreshLayout smartRefreshLayout;

    public GuessYouLikeHolder(View itemView) {
        super(itemView);
    }

//    public SmartRefreshLayout getSmartRefreshLayout() {
//        if (smartRefreshLayout == null){
//            smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.guess_you_like_item_smartrefresh);
//        }
//        return smartRefreshLayout;
//    }

    public RecyclerView getRecyclerView() {
        if (recyclerView == null){
            recyclerView = (RecyclerView) view.findViewById(R.id.guess_you_like_item_recyclerview);
        }
        return recyclerView;

    }

}
