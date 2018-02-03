package com.burmamall.burmamall.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.model.HomeCommodityModel;
import com.burmamall.burmamall.utils.MultiItemType;
import com.burmamall.burmamall.view.holder.FlashDealsHolder;

import java.util.List;

/**
 * Created by sand on 2018/2/2.
 */

public class HomeCommodityAdatper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeCommodityModel> commodityModels;
    private Context context;

    public HomeCommodityAdatper(List<HomeCommodityModel> commodityModels,Context context) {
        this.commodityModels = commodityModels;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == MultiItemType.FLASH_DEALS){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_flash_deals_item,parent,false);
            return new FlashDealsHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FlashDealsHolder){
            FlashDealsHolder flashDealsHolder = (FlashDealsHolder) holder;
            FlashDealsAdapter adapter = new FlashDealsAdapter(commodityModels.get(position).getData(),context);
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            flashDealsHolder.getRecyclerView().setLayoutManager(manager);
            flashDealsHolder.getRecyclerView().setAdapter(adapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = commodityModels.get(position).getType();
        if(type == MultiItemType.FLASH_DEALS){
            return MultiItemType.FLASH_DEALS;
        } else if (type == MultiItemType.GUESS_YOU_LIKE){
            return MultiItemType.GUESS_YOU_LIKE;
        }else if (type == MultiItemType.HOT_BRAND){
            return MultiItemType.HOT_BRAND;
        } else if (type == MultiItemType.HOT_CATEGORIES){
            return MultiItemType.HOT_CATEGORIES;
        } else if (type == MultiItemType.NEW_ARRIVE){
            return MultiItemType.NEW_ARRIVE;
        } else {
            return MultiItemType.STORE;
        }
    }

    @Override
    public int getItemCount() {
        return commodityModels.size();
    }
}
