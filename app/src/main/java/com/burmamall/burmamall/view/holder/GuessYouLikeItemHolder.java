package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.burmamall.burmamall.R;

/**
 * Created by sand on 2018/2/2.
 */

public class GuessYouLikeItemHolder extends RecyclerView.ViewHolder{

    private ImageView commodityIcon;
    private TextView commodityPriceTv;
    private TextView commodityTitle;
    private View v;

    public GuessYouLikeItemHolder(View itemView) {
        super(itemView);
        this.v = itemView;
    }

    public ImageView getCommdityIcon() {
        if (commodityIcon == null){
            commodityIcon = (ImageView) v.findViewById(R.id.commodity_icon);
        }
        return commodityIcon;
    }

    public TextView getCommdityPriceTv() {
        if (commodityPriceTv == null){
            commodityPriceTv = (TextView) v.findViewById(R.id.commodity_price);
        }
        return commodityPriceTv;
    }

    public TextView getCommodityTitle() {
        if (commodityTitle  == null){
            commodityTitle = (TextView) v.findViewById(R.id.commodity_title);
        }
        return commodityTitle;
    }
}
