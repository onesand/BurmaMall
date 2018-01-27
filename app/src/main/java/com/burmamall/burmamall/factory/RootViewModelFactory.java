package com.burmamall.burmamall.factory;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.viewmodel.banner.IBannerModel;
import com.burmamall.burmamall.viewmodel.banner.BannerModel;
import com.burmamall.burmamall.viewmodel.splash.DrawableSplashModel;
import com.burmamall.burmamall.viewmodel.splash.SplashModel;

/**
 * Created by sand on 2018/1/24.
 */

public class RootViewModelFactory implements IViewModelFactory{

    @Override
    public IBannerModel getBannerModel() {
        return new BannerModel();
    }

    @Override
    public SplashModel getSplashModel() {
        return new DrawableSplashModel(R.mipmap.ic_launcher);
    }


}
