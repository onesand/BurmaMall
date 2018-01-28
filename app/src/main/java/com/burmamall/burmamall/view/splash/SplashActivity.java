package com.burmamall.burmamall.view.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.config.LauchConfig;
import com.burmamall.burmamall.config.TimeConfig;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.view.BaseActivity;
import com.burmamall.burmamall.viewmodel.splash.SplashModel;

/**
 * Created by sand on 2018/1/24.
 */

public class SplashActivity extends BaseActivity<SplashModel>{

    private ImageView mIvSplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.APPTheme_Fullscreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        addDisposable(
          mViewModel.toNext(TimeConfig.SPLASH)
                .subscribe(this::toNext)
        );

        mIvSplash = (ImageView) findViewById(R.id.splash_iv);

        mViewModel.loadSplashImg(mIvSplash);
    }

    @Override
    public SplashModel getViewModel() {
        return ViewModelFactory.factory().getSplashModel();
    }

    private void toNext(int type){
        switch (type){
            case ConstanModel.Login.USER_LOGINED:
                LauchConfig.toMainActivity(this);
                break;
            case ConstanModel.Login.USER_UNLOGIN:
                LauchConfig.toMainActivity(this);
                break;
        }
        finish();
    }

}
