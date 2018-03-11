package com.burmamall.burmamall.http;


import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.utils.FileHelper;
import com.burmamall.burmamall.utils.StringUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sand on 2018/1/29.
 */

public class BurmamallServiceApi {

    public static Observable<Response<String>> getString(String url){
        return OkGo.<String>get(url)
                .converter(new StringConvert())
                .adapt(new ObservableResponse<String>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void downloadFile(Object tag,String url,String savePath){

        OkGo.<File>get(url)
                .tag(tag)
                .execute(new FileCallback(savePath, StringUtils.getImgName(url)) {
                    @Override
                    public void onSuccess(Response<File> response) {

                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }
}
