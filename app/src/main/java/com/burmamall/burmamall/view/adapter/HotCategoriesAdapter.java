package com.burmamall.burmamall.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.model.FlashDealsModel;
import com.burmamall.burmamall.utils.ConstanModel;

import java.util.List;

/**
 * Created by sand on 2018/2/4.
 */

public class HotCategoriesAdapter extends BaseAdapter {

    private List<FlashDealsModel> data;
    private Context context;

    public HotCategoriesAdapter(List<FlashDealsModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(this.context).inflate(R.layout.commdity_wit_price_item, null);
            viewHolder.commodityIcon = (ImageView) convertView.findViewById(R.id.commodity_icon);
            viewHolder.commodityPrice = (TextView) convertView.findViewById(R.id.commodity_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.commodityPrice.setTextColor(context.getResources().getColor(R.color.gray1));
        viewHolder.commodityPrice.setText(data.get(position).getName());
        Glide.with(context).load(ConstanModel.BurmamallApi.BASE_URL + data.get(position).getImg()).into(viewHolder.commodityIcon);
        return convertView;
    }

    class ViewHolder {
        public TextView commodityPrice;
        public ImageView commodityIcon;
    }
}
