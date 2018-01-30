package com.burmamall.burmamall.factory;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.viewmodel.home.HomeModel;
import com.burmamall.burmamall.viewmodel.login.LoginModel;
import com.burmamall.burmamall.viewmodel.splash.DrawableSplashModel;
import com.burmamall.burmamall.viewmodel.splash.SplashModel;

/**
 * Created by sand on 2018/1/24.
 */

public class RootViewModelFactory implements IViewModelFactory{

    @Override
    public HomeModel getBannerModel() {
        return new HomeModel();
    }

    @Override
    public SplashModel getSplashModel() {
        return new DrawableSplashModel(R.mipmap.first);
    }

    @Override
    public LoginModel getLoginModel() {
        return new LoginModel();
    }
}
