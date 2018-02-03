package com.burmamall.burmamall.viewmodel.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.burmamall.burmamall.ECApplication;
import com.burmamall.burmamall.model.FacebookUserInfoModel;
import com.burmamall.burmamall.utils.DBlog;
import com.burmamall.burmamall.view.fragment.MainFragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by sand on 2018/1/30.
 */

public class LoginModel implements ILoginModel{

    @Override
    public void userFaceBookLogin(CallbackManager callbackManager,Activity activity,int fromTag) {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        DBlog.ln("facebook 登录成功=>>>" + loginResult.getAccessToken().getToken());
                        DBlog.ln("facebook 登录成功toString=>>>" + loginResult.getAccessToken().toString());
                        getLoginInfo(loginResult.getAccessToken());
                        ECApplication.i().refreshFBLoginStatus();
                        finishActivity(activity,fromTag);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        exception.printStackTrace();
                        DBlog.ln("facebook onError=>>>" + exception.getMessage());
                    }
                });
    }

    @Override
    public void finishActivity(Activity activity,int fromTag) {
        Intent intent = new Intent(activity, MainFragment.class);
        intent.putExtra("from_tag",fromTag);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    public void logoutFacebook(Activity activity,int fromTag) {
        LoginManager.getInstance().logOut();
        ECApplication.i().refreshFBLoginStatus();
        finishActivity(activity,fromTag);
    }

    public void getLoginInfo(AccessToken accessToken){
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                if (object != null) {

                    FacebookUserInfoModel userInfoModel = new Gson().fromJson(object.toString(),FacebookUserInfoModel.class);
                    ECApplication.i().setUserInfoModel(userInfoModel);
                    ECApplication.i().refreshFBLoginStatus();
//                    String id = object.optString( "id" ) ;   //比如:1565455221565
//                    String name = object.optString( "name" ) ;  //比如：Zhang San
//                    String gender = object.optString("gender") ;  //性别：比如 male （男）  female （女）
//                    String emali = object.optString("email") ;  //邮箱：比如：56236545@qq.com
//
//                    //获取用户头像
//                    JSONObject object_pic = object.optJSONObject( "picture" ) ;
//                    JSONObject object_data = object_pic.optJSONObject( "data" ) ;
//                    String photo = object_data.optString( "url" )  ;
//
//                    //获取地域信息
//                    String locale = object.optString( "locale" ) ;   //zh_CN 代表中文简体
                }
            }
        }) ;

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,gender,birthday,email,picture,locale,updated_time,timezone,age_range,first_name,last_name");
        request.setParameters(parameters);
        request.executeAsync() ;
    }

    @Override
    public void onDestroy() {

    }
}
