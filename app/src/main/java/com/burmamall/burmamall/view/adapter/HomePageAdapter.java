package com.burmamall.burmamall.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.model.FunctionModel;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.widget.adapter.BaseAutoAdapter;

import java.util.List;


/**
 * Created by sand
 */
public class HomePageAdapter extends BaseAutoAdapter {

    private Context context;
    private List<FunctionModel> myData;
    private  View view;

    public HomePageAdapter(Context context, List<FunctionModel> myData) {
        this.context = context;
        this.myData = myData;
    }

    @Override
    public int getCounts() {
        return myData.size();
    }

    @Override
    public Object getItem(int position) {
        return myData.get(position);
    }

    @Override
    public View getItemView(int position, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.home_gridview_item, null);
        TextView hint = (TextView) view.findViewById(R.id.gridview_item_hint);
        ImageView icon = (ImageView) view.findViewById(R.id.gridview_item_icon);
        hint.setText(myData.get(position).getName());
        Glide.with(context).load(ConstanModel.BurmamallApi.BASE_URL + myData.get(position).getLogo()).into(icon);
        return view;
    }

}