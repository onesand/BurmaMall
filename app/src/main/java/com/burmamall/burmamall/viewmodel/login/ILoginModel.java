package com.burmamall.burmamall.viewmodel.login;

import android.app.Activity;
import android.content.Context;

import com.burmamall.burmamall.viewmodel.IViewModel;
import com.facebook.CallbackManager;

/**
 * Created by sand on 2018/1/30.
 */

public interface ILoginModel extends IViewModel{

    void userFaceBookLogin(CallbackManager callbackManager,Activity activity,int fromTag);

    void finishActivity(Activity activity,int fromTag);

    void logoutFacebook(Activity activity,int fromTag);
}
