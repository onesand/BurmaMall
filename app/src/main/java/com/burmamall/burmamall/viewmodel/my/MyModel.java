package com.burmamall.burmamall.viewmodel.my;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.burmamall.burmamall.ECApplication;
import com.burmamall.burmamall.http.BurmamallServiceApi;
import com.burmamall.burmamall.model.FacebookUserInfoModel;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.utils.FileHelper;
import com.burmamall.burmamall.utils.StringUtils;
import com.burmamall.burmamall.widget.RoundImageView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Response;

import java.io.File;

/**
 * Created by sand on 2018/1/31.
 */

public class MyModel implements IMyModel{

    @Override
    public void initUserInfoData(RoundImageView userIcon, TextView userName) {
        if (ECApplication.i().getLoginType() == ConstanModel.LoginType.FACEBOOK){
            FacebookUserInfoModel infoModel = ECApplication.i().getUserInfoModel();
            String iconUrl = StringUtils.getImgName(infoModel.getPicture().getData().getUrl());
            File file = new File(FileHelper.USER_IMAGE + iconUrl);
            if (file.exists()){
                Glide.with(userIcon.getContext()).load(file).into(userIcon);
            } else {
                OkGo.<File>get(infoModel.getPicture().getData().getUrl())
                        .tag(this)
                        .execute(new FileCallback(FileHelper.USER_IMAGE, StringUtils.getImgName(infoModel.getPicture().getData().getUrl())) {
                            @Override
                            public void onSuccess(Response<File> response) {
                                Glide.with(userIcon.getContext()).load(response.body()).into(userIcon);
                            }

                            @Override
                            public void onFinish() {
                                super.onFinish();
                            }
                        });
            }
            userName.setText(infoModel.getName());
        }

    }

    @Override
    public void onDestroy() {

    }
}
