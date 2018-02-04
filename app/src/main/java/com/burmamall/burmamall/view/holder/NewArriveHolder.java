package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.widget.HorizontalGridView;

/**
 * Created by sand on 2018/2/2.
 */

public class NewArriveHolder extends HomeBaseHolder{

    private HorizontalGridView gridView;
    private ImageView headIcon;

    public NewArriveHolder(View itemView) {
        super(itemView);
    }


    public ImageView getHeadIcon() {
        if (headIcon == null){
            headIcon = (ImageView) view.findViewById(R.id.home_new_arrive_item_head);
        }
        return headIcon;
    }

    public HorizontalGridView getGridView() {
        if (gridView == null){
            gridView = (HorizontalGridView) view.findViewById(R.id.home_new_arrive_gridview);
        }
        return gridView;
    }
}
