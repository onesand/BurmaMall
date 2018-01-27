package com.burmamall.burmamall.viewmodel.splash;

import android.widget.ImageView;

import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.viewmodel.IViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by sand on 2018/1/24.
 */

public class SplashModel implements IViewModel{

    public Observable<Integer> toNext(int seconds){
        return Observable.just(ConstanModel.Login.USER_LOGINED).delay(seconds, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void loadSplashImg(ImageView view){

    }

    @Override
    public void onDestroy() {
    }
}
