package com.burmamall.burmamall.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.model.FlashDealsModel;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.view.holder.CommodityWhitPriceHolder;

import java.util.List;

/**
 * Created by sand on 2018/2/3.
 */

public class FlashDealsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FlashDealsModel> data;
    private Context context;

    public FlashDealsAdapter(List<FlashDealsModel> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commdity_wit_price_item,parent,false);
        return new CommodityWhitPriceHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        CommodityWhitPriceHolder holder = (CommodityWhitPriceHolder) h;
        holder.getCommdityPriceTv().setText("$" + data.get(position).getSell_price());
        holder.getCommdityPriceTv().setTextColor(context.getResources().getColor(R.color.red));
        holder.getCommdityOldPriceTv().setText("$" + data.get(position).getMarket_price());
        holder.getCommdityOldPriceTv().getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
        Glide.with(context).load(ConstanModel.BurmamallApi.BASE_URL + data.get(position).getImg()).into(holder.getCommdityIcon());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
