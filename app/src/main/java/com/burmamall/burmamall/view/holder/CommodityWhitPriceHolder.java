package com.burmamall.burmamall.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.burmamall.burmamall.R;

/**
 * Created by sand on 2018/2/2.
 */

public class CommodityWhitPriceHolder extends RecyclerView.ViewHolder{

    private ImageView commdityIcon;
    private TextView commdityPriceTv;
    private View v;

    public CommodityWhitPriceHolder(View itemView) {
        super(itemView);
        this.v = itemView;
    }

    public ImageView getCommdityIcon() {
        if (commdityIcon == null){
            commdityIcon = (ImageView) v.findViewById(R.id.commodity_icon);
        }
        return commdityIcon;
    }

    public TextView getCommdityPriceTv() {
        if (commdityPriceTv == null){
            commdityPriceTv = (TextView) v.findViewById(R.id.commodity_price);
        }
        return commdityPriceTv;
    }
}
