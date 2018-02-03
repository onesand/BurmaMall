package com.burmamall.burmamall.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.model.HomeCommodityModel;
import com.burmamall.burmamall.ui.BannerListener;
import com.burmamall.burmamall.ui.RequestCommdoityListener;
import com.burmamall.burmamall.utils.FullyLinearLayoutManager;
import com.burmamall.burmamall.view.adapter.HomeCommodityAdatper;
import com.burmamall.burmamall.view.adapter.HomePageAdapter;
import com.burmamall.burmamall.viewmodel.home.HomeModel;
import com.burmamall.burmamall.widget.AutoMaticPageGridView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sand on 2018/1/27.
 */

public class HomeFragment extends BaseFragment<HomeModel> implements BannerListener,RequestCommdoityListener{

    private View view;
    private Banner mBanner;
    private AutoMaticPageGridView automatic;
    private HomePageAdapter adapter;
    private List<Integer> functionDatas;
    private RecyclerView commodityRecyclerView;
    private HomeCommodityAdatper commodityAdatper;
    private List<HomeCommodityModel> commodityModels = new ArrayList<>();
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
        initView();
        mViewModel.requestFileManifest(getActivity());
        mViewModel.requestBannerData(mBanner,this);
        mViewModel.requestCommodityData(this);

        //功能栏
        automatic = (AutoMaticPageGridView) view.findViewById(R.id.automatic);
        functionDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            functionDatas.add(i);
        }
        adapter = new HomePageAdapter(getActivity(), functionDatas);
        automatic.setAdapter(adapter);
        automatic.setOnItemClickListener(new AutoMaticPageGridView.OnItemClickCallBack() {
            @Override
            public void OnItemClicked(int position, Object object) {
                Toast.makeText(getActivity(), position + "--", Toast.LENGTH_SHORT).show();
            }
        });

        //商品列表
//        List<HomeCommodityModel> list = new ArrayList<>();
//        for (int i = 0;i <5;i++){
//            HomeCommodityModel model = new HomeCommodityModel();
//            model.setType(0);
//            list.add(model);
//        }


    }

    private void initView() {
        mBanner = (Banner) view.findViewById(R.id.home_fragment_banner);
        commodityRecyclerView = (RecyclerView) view.findViewById(R.id.home_fragment_recyclerview);
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
        if (commodityModels.size() == 1){
            commodityAdatper = new HomeCommodityAdatper(commodityModels,getActivity());
            FullyLinearLayoutManager mLinearLayoutManager = new FullyLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            commodityRecyclerView.setNestedScrollingEnabled(false);
            commodityRecyclerView.setLayoutManager(mLinearLayoutManager);
            commodityRecyclerView.setAdapter(commodityAdatper);
        }
    }
}
