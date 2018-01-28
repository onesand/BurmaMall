package com.burmamall.burmamall.viewmodel.banner;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.ui.BannerListener;
import com.burmamall.burmamall.utils.permission.OnPermissionResultListener;
import com.burmamall.burmamall.utils.permission.PermissionsUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sand on 2018/1/24.
 */

public class HomeModel implements IHomeModel{

    private BannerListener bannerListener;

    /**
     * 先查询服务器有没有更新 Banner
     * @param banner
     */
    @Override
    public void requestBannerData(Banner banner,BannerListener bannerListener) {
        this.bannerListener = bannerListener;
        //// TODO: 2018/1/28  查询服务器有没有更新
        List<String> images = new ArrayList<>();
        images.add("/sdcard/Pictures/Screenshots/11.jpg");
        images.add("/sdcard/Pictures/Screenshots/12.jpg");
        images.add("/sdcard/Pictures/Screenshots/13.jpg");
        images.add("/sdcard/Pictures/Screenshots/14.jpg");

        initBanner(banner,images);
    }

    /**
     * 初始化 Banner 数据
     */
    @Override
    public void initBanner(Banner banner, List<?> images) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                bannerListener.bannerOnclick(images.get(position)+"");
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void onDestroy() {

    }


    public class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            Glide.with(context).load(path).into(imageView);
        }
    }

    @Override
    public void requestFileManifest(Activity activity){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            int code = PermissionsUtil.checkPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (code != PackageManager.PERMISSION_GRANTED){
                PermissionsUtil.requestPermissions(activity, new OnPermissionResultListener() {
                    @Override
                    public void onRequestPermissionsResult(String[] granted, String[] denied) {

                    }

                    @Override
                    public void onAllGranted() {

                    }
                },Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
    }
}
