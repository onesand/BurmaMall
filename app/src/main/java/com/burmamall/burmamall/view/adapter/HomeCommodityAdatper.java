package com.burmamall.burmamall.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.http.BurmamallServiceApi;
import com.burmamall.burmamall.model.FlashDealsModel;
import com.burmamall.burmamall.model.HomeCommodityModel;
import com.burmamall.burmamall.ui.EndLessOnScrollListener;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.utils.DBlog;
import com.burmamall.burmamall.utils.JsonUtils;
import com.burmamall.burmamall.utils.MultiItemType;
import com.burmamall.burmamall.view.holder.FlashDealsHolder;
import com.burmamall.burmamall.view.holder.GuessYouLikeHolder;
import com.burmamall.burmamall.view.holder.HotBrandHolder;
import com.burmamall.burmamall.view.holder.HotCategoriesHolder;
import com.burmamall.burmamall.view.holder.NewArriveHolder;
import com.burmamall.burmamall.view.holder.StoreItemHolder;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by sand on 2018/2/2.
 */

public class HomeCommodityAdatper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeCommodityModel> commodityModels;
    private Context context;
    private Activity activity;
    private GuessYouLikeAdapter guessYouLikeAdapter;
    private int loadMoreCount = 2;

    public HomeCommodityAdatper(List<HomeCommodityModel> commodityModels,Context context) {
        this.commodityModels = commodityModels;
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == MultiItemType.FLASH_DEALS){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_flash_deals_item,parent,false);
            return new FlashDealsHolder(view);
        } else if (viewType == MultiItemType.HOT_BRAND){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_hot_brand_item,parent,false);
            return new HotBrandHolder(view);
        } else if (viewType == MultiItemType.NEW_ARRIVE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_new_arrive_item,parent,false);
            return new NewArriveHolder(view);
        } else if (viewType == MultiItemType.HOT_CATEGORIES){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_new_arrive_item,parent,false);
            return new HotCategoriesHolder(view);
        } else if (viewType == MultiItemType.STORE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_store_item,parent,false);
            return new StoreItemHolder(view);
         } else if (viewType == MultiItemType.GUESS_YOU_LIKE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_guess_you_like_item,parent,false);
            return new GuessYouLikeHolder(view);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof FlashDealsHolder){
            FlashDealsHolder flashDealsHolder = (FlashDealsHolder) holder;

            flashDealsHolder.getCountDownTv().setVisibility(View.VISIBLE);
            flashDealsHolder.getTitleTv().setText(context.getResources().getText(R.string.flash_deals));
            flashDealsHolder.getMoreIv().setVisibility(View.VISIBLE);

            FlashDealsAdapter adapter = new FlashDealsAdapter(commodityModels.get(position).getData(),context);
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            flashDealsHolder.getRecyclerView().setLayoutManager(manager);
            flashDealsHolder.getRecyclerView().setAdapter(adapter);
        } else if (holder instanceof HotBrandHolder){
            HotBrandHolder hotBrandHolder = (HotBrandHolder) holder;

            hotBrandHolder.getCountDownTv().setVisibility(View.GONE);
            hotBrandHolder.getTitleTv().setText(context.getResources().getText(R.string.hot_brand));
            hotBrandHolder.getMoreIv().setVisibility(View.VISIBLE);

            HotBrandAdapter adapter = new HotBrandAdapter(commodityModels.get(position).getData(),context);
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            hotBrandHolder.getRecyclerView().setLayoutManager(manager);
            hotBrandHolder.getRecyclerView().setAdapter(adapter);
        } else if (holder instanceof NewArriveHolder){
            NewArriveHolder newArriveHolder = (NewArriveHolder) holder;
            List<FlashDealsModel> data = commodityModels.get(position).getData();

            newArriveHolder.getCountDownTv().setVisibility(View.GONE);
            newArriveHolder.getTitleTv().setText(context.getResources().getText(R.string.new_arrive));
            newArriveHolder.getMoreIv().setVisibility(View.VISIBLE);

            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            float density = dm.density;


            NewArriveAdapter arriveAdapter = new NewArriveAdapter(data,context);
            int count = arriveAdapter.getCount();
            int columns = (count % 2 == 0) ? count / 2 : count / 2 + 1;
            newArriveHolder.getGridView().setAdapter(arriveAdapter);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(columns * (dm.widthPixels-150) / 3, LinearLayout.LayoutParams.WRAP_CONTENT);
            newArriveHolder.getGridView().setLayoutParams(params);
            newArriveHolder.getGridView().setColumnWidth((dm.widthPixels-300) / 3 );
            newArriveHolder.getGridView().setStretchMode(GridView.NO_STRETCH);
            if (count <= 3) {
                newArriveHolder.getGridView().setNumColumns(count);
            } else {
                newArriveHolder.getGridView().setNumColumns(columns);
            }

            newArriveHolder.getGridView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context,data.get(position).getName(),Toast.LENGTH_SHORT).show();
                }
            });

        } else if (holder instanceof HotCategoriesHolder){
            HotCategoriesHolder hotCategoriesHolder = (HotCategoriesHolder) holder;
            List<FlashDealsModel> data = commodityModels.get(position).getData();

            hotCategoriesHolder.getCountDownTv().setVisibility(View.GONE);
            hotCategoriesHolder.getTitleTv().setText(context.getResources().getText(R.string.hot_categories));
            hotCategoriesHolder.getMoreIv().setVisibility(View.VISIBLE);
            hotCategoriesHolder.getHeadIcon().setVisibility(View.GONE);

            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            float density = dm.density;


            HotCategoriesAdapter hotCategoriesAdapter = new HotCategoriesAdapter(data,context);
            int count = hotCategoriesAdapter.getCount();
            int columns = (count % 2 == 0) ? count / 2 : count / 2 + 1;
            hotCategoriesHolder.getGridView().setAdapter(hotCategoriesAdapter);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(columns * (dm.widthPixels-150) / 3, LinearLayout.LayoutParams.WRAP_CONTENT);
            hotCategoriesHolder.getGridView().setLayoutParams(params);
            hotCategoriesHolder.getGridView().setColumnWidth((dm.widthPixels-300) / 3 );
            hotCategoriesHolder.getGridView().setStretchMode(GridView.NO_STRETCH);
            if (count <= 3) {
                hotCategoriesHolder.getGridView().setNumColumns(count);
            } else {
                hotCategoriesHolder.getGridView().setNumColumns(columns);
            }

            hotCategoriesHolder.getGridView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context,data.get(position).getName(),Toast.LENGTH_SHORT).show();
                }
            });

        } else if (holder instanceof StoreItemHolder){
            StoreItemHolder storeItemHolder = (StoreItemHolder) holder;

            storeItemHolder.getCountDownTv().setVisibility(View.GONE);
            storeItemHolder.getTitleTv().setText(context.getResources().getText(R.string.store));
            storeItemHolder.getMoreIv().setVisibility(View.VISIBLE);

            StoreAdapter adapter = new StoreAdapter(commodityModels.get(position).getData(),context);
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            storeItemHolder.getRecyclerView().setLayoutManager(manager);
            storeItemHolder.getRecyclerView().setAdapter(adapter);
        } else if (holder instanceof GuessYouLikeHolder){
            GuessYouLikeHolder guessYouLikeHolder = (GuessYouLikeHolder) holder;

            guessYouLikeHolder.getCountDownTv().setVisibility(View.GONE);
            guessYouLikeHolder.getTitleTv().setText(context.getResources().getText(R.string.guess_you_like));
            guessYouLikeHolder.getMoreIv().setVisibility(View.VISIBLE);

            guessYouLikeAdapter = new GuessYouLikeAdapter(commodityModels.get(position).getData(),context);
            GridLayoutManager manager = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
            guessYouLikeHolder.getRecyclerView().setLayoutManager(manager);
            guessYouLikeHolder.getRecyclerView().setAdapter(guessYouLikeAdapter);
//            guessYouLikeHolder.getSmartRefreshLayout().setEnableLoadmore(true);
//            guessYouLikeHolder.getSmartRefreshLayout().setOnLoadmoreListener(new OnLoadmoreListener() {
//                @Override
//                public void onLoadmore(RefreshLayout refreshlayout) {
//                    loadMoreGuessYouLike(adapter,refreshlayout);
//                    DBlog.ln("start load more");
//                }
//            });
        }
    }

    public GuessYouLikeAdapter getGuessYouLikeAdapter(){
        return guessYouLikeAdapter;
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

    public void loadMoreGuessYouLike(RefreshLayout refreshLayout){
        //guess you like
        BurmamallServiceApi.getString(ConstanModel.BurmamallApi.GUESS_YOU_LIKE + "?p=" + loadMoreCount).subscribe(new Observer<Response<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Response<String> stringResponse) {
                List<FlashDealsModel> models = JsonUtils.jsonToList(stringResponse.body(),FlashDealsModel.class);
                commodityModels.get(5).getData().addAll(models);
//                getGuessYouLikeAdapter().addData(models);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                loadMoreCount++;
                refreshLayout.finishLoadmore(true);
                notifyDataSetChanged();
            }
        });
    }
}
