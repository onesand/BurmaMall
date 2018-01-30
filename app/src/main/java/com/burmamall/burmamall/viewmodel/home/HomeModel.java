package com.burmamall.burmamall.viewmodel.home;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.http.BurmamallServiceApi;
import com.burmamall.burmamall.model.BannerModel;
import com.burmamall.burmamall.ui.BannerListener;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.utils.DBlog;
import com.burmamall.burmamall.utils.FileHelper;
import com.burmamall.burmamall.utils.JsonUtils;
import com.burmamall.burmamall.utils.StringUtils;
import com.burmamall.burmamall.utils.permission.OnPermissionResultListener;
import com.burmamall.burmamall.utils.permission.PermissionsUtil;
import com.lzy.okgo.model.Response;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by sand on 2018/1/24.
 */

public class HomeModel implements IHomeModel{

    private BannerListener bannerListener;
    private List<BannerModel> bannerModels = new ArrayList<>();

    /**
     * 先查询服务器有没有更新 Banner
     * @param banner
     */
    @Override
    public void requestBannerData(Banner banner,BannerListener bannerListener) {
        this.bannerListener = bannerListener;

        List<File> temp = FileHelper.listFileSortByModifyTime(FileHelper.BANNER_IMAGE);
        if (temp.size() > 5){
            temp.subList(0,5);
        }
        initBanner(banner,temp);

        BurmamallServiceApi.getBannerData().subscribe(new Observer<Response<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Response<String> stringResponse) {
                bannerModels = JsonUtils.jsonToList(stringResponse.body(),BannerModel.class);
                for (BannerModel model : bannerModels){
                    BurmamallServiceApi.downloadFile(this, ConstanModel.BurmamallApi.BASE_URL + model.getImg_path());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                List<String> images = new ArrayList<>();
                for (BannerModel model : bannerModels){
                    String name = StringUtils.getBannerImgName(model.getImg_path());
                    images.add(FileHelper.BANNER_IMAGE + name);
                }
                banner.update(images);
            }
        });


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
        banner.setDelayTime(3000);
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
                        FileHelper.createFolder();
                    }

                    @Override
                    public void onAllGranted() {
                        FileHelper.createFolder();
                    }
                },Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
    }
}
