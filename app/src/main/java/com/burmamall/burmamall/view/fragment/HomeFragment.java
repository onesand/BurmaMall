package com.burmamall.burmamall.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.model.FunctionModel;
import com.burmamall.burmamall.model.HomeCommodityModel;
import com.burmamall.burmamall.ui.BannerListener;
import com.burmamall.burmamall.ui.FunctionDataListener;
import com.burmamall.burmamall.ui.RequestCommdoityListener;
import com.burmamall.burmamall.utils.FullyLinearLayoutManager;
import com.burmamall.burmamall.utils.MultiItemType;
import com.burmamall.burmamall.view.adapter.HomeCommodityAdatper;
import com.burmamall.burmamall.view.adapter.HomePageAdapter;
import com.burmamall.burmamall.viewmodel.home.HomeModel;
import com.burmamall.burmamall.widget.AutoMaticPageGridView;
import com.burmamall.burmamall.widget.ZProgressHUD;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sand on 2018/1/27.
 */

public class HomeFragment extends BaseFragment<HomeModel> implements BannerListener,RequestCommdoityListener, FunctionDataListener {

    private View view;
    private Banner mBanner;
    private AutoMaticPageGridView automatic;
    private HomePageAdapter adapter;
    private List<Integer> functionDatas;
    private RecyclerView commodityRecyclerView;
    private SmartRefreshLayout smartRefreshLayout;
    private HomeCommodityAdatper commodityAdatper;
    private List<HomeCommodityModel> commodityModels = new ArrayList<>();
    private ImageView adImage;
    private ZProgressHUD progressHUD;
    private RelativeLayout searchMainRl;
    private TextView searchHint;
    private ImageView searchCream;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public HomeModel getViewModel() {
        return ViewModelFactory.factory().getBannerModel();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressHUD = ZProgressHUD.getInstance(getActivity());
        progressHUD.setMessage("loading...");
        progressHUD.setCancelable(false);
        progressHUD.show();
        initView();
        initSearchView();
        mViewModel.requestFileManifest(getActivity());
        mViewModel.requestBannerData(mBanner,this);
        mViewModel.requestFunction(this);
        mViewModel.requestAd(adImage);
        mViewModel.requestCommodityData(this);

    }

    private void initSearchView() {
        searchHint.setHint("input search");
        searchMainRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"跳转搜索界面",Toast.LENGTH_SHORT).show();
            }
        });
        searchCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"cream",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mBanner = (Banner) view.findViewById(R.id.home_fragment_banner);
        commodityRecyclerView = (RecyclerView) view.findViewById(R.id.home_fragment_recyclerview);
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.guess_you_like_item_smartrefresh);
        searchCream = (ImageView) view.findViewById(R.id.search_layout_camera_icon);
        searchHint = (TextView) view.findViewById(R.id.search_layout_hint);
        searchMainRl = (RelativeLayout) view.findViewById(R.id.search_rl);
        automatic = (AutoMaticPageGridView) view.findViewById(R.id.automatic);
        smartRefreshLayout.setEnableLoadmore(true);
        smartRefreshLayout.setEnableRefresh(false);
        adImage = (ImageView) view.findViewById(R.id.home_fragment_advertising);
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                commodityAdatper.loadMoreGuessYouLike(refreshlayout);
            }
        });
    }

    @Override
    public void bannerOnclick(String url) {
        Toast.makeText(getActivity(),url,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void add(int type, List<?> data) {
        HomeCommodityModel model = new HomeCommodityModel();
        model.setType(type);
        model.setData(data);
        commodityModels.add(model);

        if (commodityModels.size() == 6){

            List<HomeCommodityModel> temp = new ArrayList<>();

            for(HomeCommodityModel tempModel :commodityModels){
                while (tempModel.getType() == MultiItemType.FLASH_DEALS){
                    temp.add(tempModel);
                    break;
                }
            }

            for(HomeCommodityModel tempModel :commodityModels){
                while (tempModel.getType() == MultiItemType.HOT_BRAND){
                    temp.add(tempModel);
                    break;
                }
            }

            for(HomeCommodityModel tempModel :commodityModels){
                while (tempModel.getType() == MultiItemType.NEW_ARRIVE){
                    temp.add(tempModel);
                    break;
                }
            }

            for(HomeCommodityModel tempModel :commodityModels){
                while (tempModel.getType() == MultiItemType.HOT_CATEGORIES){
                    temp.add(tempModel);
                    break;
                }
            }

            for(HomeCommodityModel tempModel :commodityModels){
                while (tempModel.getType() == MultiItemType.STORE){
                    temp.add(tempModel);
                    break;
                }
            }

            for(HomeCommodityModel tempModel :commodityModels){
                while (tempModel.getType() == MultiItemType.GUESS_YOU_LIKE){
                    temp.add(tempModel);
                    break;
                }
            }

            commodityModels = temp;
            commodityAdatper = new HomeCommodityAdatper(commodityModels,getActivity());
            FullyLinearLayoutManager mLinearLayoutManager = new FullyLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            commodityRecyclerView.setNestedScrollingEnabled(false);
            commodityRecyclerView.setLayoutManager(mLinearLayoutManager);
            commodityRecyclerView.setAdapter(commodityAdatper);
            progressHUD.dismiss();
        }
    }

    @Override
    public void functionDataListenerComplete(List<FunctionModel> functionModels) {
        //功能栏
        adapter = new HomePageAdapter(getActivity(), functionModels);
        automatic.setAdapter(adapter);
        automatic.setOnItemClickListener(new AutoMaticPageGridView.OnItemClickCallBack() {
            @Override
            public void OnItemClicked(int position, Object object) {
                Toast.makeText(getActivity(), functionModels.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
