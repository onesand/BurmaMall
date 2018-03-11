package com.burmamall.burmamall.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.model.FlashDealsModel;
import com.burmamall.burmamall.model.StoreModel;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.view.holder.CommodityWhitPriceHolder;
import com.burmamall.burmamall.view.holder.StoreItemHolder;

import java.util.List;

/**
 * Created by sand on 2018/2/3.
 */

public class StoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StoreModel> data;
    private Context context;

    public StoreAdapter(List<StoreModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_store_item_item,parent,false);
        return new StoreItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        StoreItemHolder holder = (StoreItemHolder) h;
        holder.getStoreName().setText(data.get(position).getSeller().getSeller_name());
        Glide.with(context).load(ConstanModel.BurmamallApi.BASE_URL + data.get(position).getSeller().getLogo())
                .into(holder.getStoreIcon());
        StoreCommodityAdapter adapter = new StoreCommodityAdapter(data.get(position).getSeller_goods(),context);
        LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.getRecyclerView().setLayoutManager(manager);
        holder.getRecyclerView().setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 商店的商品列表
     */
    class StoreCommodityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private List<FlashDealsModel> data;
        private Context context;

        public StoreCommodityAdapter(List<FlashDealsModel> data, Context context) {
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            CommodityWhitPriceHolder commodityWhitPriceHolder = (CommodityWhitPriceHolder) holder;
            FlashDealsModel model = data.get(position);
            commodityWhitPriceHolder.getCommdityPriceTv().setVisibility(View.VISIBLE);
            commodityWhitPriceHolder.getCommdityOldPriceTv().setVisibility(View.GONE);
            commodityWhitPriceHolder.getCommdityPriceTv().setText("$" + data.get(position).getSell_price());
            commodityWhitPriceHolder.getCommdityPriceTv().setTextColor(context.getResources().getColor(R.color.black));
            Glide.with(context).load(ConstanModel.BurmamallApi.BASE_URL + data.get(position).getImg()).into(commodityWhitPriceHolder.getCommdityIcon());
            commodityWhitPriceHolder.getCommdityIcon().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,model.getName(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

    }
}
