package com.burmamall.burmamall.viewmodel.home;

import android.app.Activity;
import android.widget.ImageView;

import com.burmamall.burmamall.model.FunctionModel;
import com.burmamall.burmamall.ui.BannerListener;
import com.burmamall.burmamall.ui.FunctionDataListener;
import com.burmamall.burmamall.ui.RequestCommdoityListener;
import com.burmamall.burmamall.viewmodel.IViewModel;
import com.youth.banner.Banner;

import java.util.List;

/**
 * Created by sand on 2018/1/24.
 */

public interface IHomeModel extends IViewModel{

    void requestBannerData(Banner banner,BannerListener bannerListener);

    void initBanner(Banner banner,List<?> images);

    void requestFileManifest(Activity activity);

    void requestCommodityData(RequestCommdoityListener listener);

    void requestAd(ImageView imageView);

    void requestFunction(FunctionDataListener listener);
}
