package com.burmamall.burmamall.viewmodel.my;

import android.widget.TextView;

import com.burmamall.burmamall.model.FacebookUserInfoModel;
import com.burmamall.burmamall.viewmodel.IViewModel;
import com.burmamall.burmamall.widget.RoundImageView;

/**
 * Created by sand on 2018/1/31.
 */

public interface IMyModel extends IViewModel{

    void initUserInfoData(RoundImageView userIcon, TextView userName);
}
