package com.burmamall.burmamall.factory;

import com.burmamall.burmamall.viewmodel.home.HomeModel;
import com.burmamall.burmamall.viewmodel.login.LoginModel;
import com.burmamall.burmamall.viewmodel.my.MyModel;
import com.burmamall.burmamall.viewmodel.splash.SplashModel;

/**
 * Created by sand on 2018/1/24.
 * Model 构造工厂
 */

public interface IViewModelFactory {

    HomeModel getBannerModel();

    SplashModel getSplashModel();

    LoginModel getLoginModel();

    MyModel getMyModel();
}
