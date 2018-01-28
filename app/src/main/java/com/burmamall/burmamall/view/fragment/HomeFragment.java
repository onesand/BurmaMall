package com.burmamall.burmamall.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.ui.BannerListener;
import com.burmamall.burmamall.viewmodel.banner.HomeModel;
import com.youth.banner.Banner;

/**
 * Created by sand on 2018/1/27.
 */

public class HomeFragment extends BaseFragment<HomeModel> implements BannerListener{

    private View view;
    private Banner mBanner;

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
    }

    private void initView() {
        mBanner = (Banner) view.findViewById(R.id.home_fragment_banner);
    }

    @Override
    public void bannerOnclick(String url) {
        Toast.makeText(getActivity(),url,Toast.LENGTH_SHORT).show();
    }
}
