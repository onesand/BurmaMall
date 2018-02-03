package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.burmamall.burmamall.R;

/**
 * Created by sand on 2018/2/2.
 */

public class HomeBaseHolder extends RecyclerView.ViewHolder{

    public ImageView moreIv;
    public TextView countDownTv;
    private TextView titleTv;
    protected View view;

    public HomeBaseHolder(View itemView) {
        super(itemView);
        this.view = itemView;
    }


    public ImageView getMoreIv() {
        if (moreIv == null){
            moreIv = (ImageView) view.findViewById(R.id.home_commodity_more_iv);
        }
        return moreIv;
    }

    public TextView getCountDownTv() {
        if (countDownTv == null){
            countDownTv = (TextView) view.findViewById(R.id.home_commodity_count_down_tv);
        }
        return countDownTv;
    }

    public TextView getTitleTv() {
        if (titleTv == null){
            titleTv = (TextView) view.findViewById(R.id.home_commodity_title_tv);
        }
        return titleTv;
    }
}
