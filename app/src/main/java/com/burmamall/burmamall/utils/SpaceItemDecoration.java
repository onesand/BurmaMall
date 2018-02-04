package com.burmamall.burmamall.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sand on 2018/2/4.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration{

    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int allCount = parent.getChildCount();
        if(parent.getChildAdapterPosition(view) != -1){
            if (parent.getChildAdapterPosition(view) != allCount)
                outRect.top = space;
        }

    }
}
