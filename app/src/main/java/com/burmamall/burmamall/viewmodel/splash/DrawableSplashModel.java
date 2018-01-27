package com.burmamall.burmamall.viewmodel.splash;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by sand on 2018/1/24.
 */

public class DrawableSplashModel extends SplashModel{

    private int mDrawbleRes = -1;

    public DrawableSplashModel(@DrawableRes int mDrawbleRes) {
        this.mDrawbleRes = mDrawbleRes;
    }

    @Override
    public void loadSplashImg(ImageView view) {
        super.loadSplashImg(view);
        if (mDrawbleRes > 0){
            Glide.with(view.getContext()).load(mDrawbleRes).into(view);
        }
    }
}
