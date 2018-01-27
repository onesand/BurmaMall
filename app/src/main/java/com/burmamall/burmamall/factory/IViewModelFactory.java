package com.burmamall.burmamall.factory;

import com.burmamall.burmamall.viewmodel.banner.IBannerModel;
import com.burmamall.burmamall.viewmodel.splash.SplashModel;

/**
 * Created by sand on 2018/1/24.
 * Model 构造工厂
 */

public interface IViewModelFactory {

    IBannerModel getBannerModel();

    SplashModel getSplashModel();
}
