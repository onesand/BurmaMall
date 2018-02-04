package com.burmamall.burmamall.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.model.FlashDealsModel;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.view.holder.GuessYouLikeItemHolder;

import java.util.List;

/**
 * Created by sand on 2018/2/3.
 */

public class GuessYouLikeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FlashDealsModel> data;
    private Context context;

    public GuessYouLikeAdapter(List<FlashDealsModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commdity_wit_price_title_item,parent,false);
        return new GuessYouLikeItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        GuessYouLikeItemHolder holder = (GuessYouLikeItemHolder) h;
        holder.getCommdityPriceTv().setText("$" + data.get(position).getSell_price());
        holder.getCommdityPriceTv().setTextColor(context.getResources().getColor(R.color.black));
        holder.getCommodityTitle().setText(data.get(position).getName());
        Glide.with(context).load(ConstanModel.BurmamallApi.BASE_URL + data.get(position).getImg()).into(holder.getCommdityIcon());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<FlashDealsModel> t){
        data.addAll(t);
//        notifyDataSetChanged();
    }
}
