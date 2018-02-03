package com.burmamall.burmamall.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.Toast;

import com.burmamall.burmamall.ECApplication;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.model.FacebookUserInfoModel;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.utils.DBlog;
import com.burmamall.burmamall.viewmodel.login.LoginModel;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.jaeger.library.StatusBarUtil;

import org.json.JSONObject;

/**
 * Created by sand on 2018/1/30.
 */

public class LoginActivity extends BaseActivity<LoginModel>{

    private CallbackManager callbackManager;
    private Button logoutFBBtn;
    private LoginButton loginFBBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logoutFBBtn = (Button) findViewById(R.id.logout_button);
        loginFBBtn = (LoginButton) findViewById(R.id.login_button);

        if (ECApplication.i().getLoginType() == ConstanModel.LoginType.FACEBOOK){
            loginFBBtn.setVisibility(View.GONE);
            logoutFBBtn.setVisibility(View.VISIBLE);
        } else {
            loginFBBtn.setVisibility(View.VISIBLE);
            logoutFBBtn.setVisibility(View.GONE);
        }

        logoutFBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.logoutFacebook(LoginActivity.this,-1);
            }
        });

        Intent intent = getIntent();
        int fromTag = intent.getIntExtra("from_tag",-1);
//        loginBtn = (Button) findViewById(R.id.login_btn);

//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
//                Toast.makeText(LoginActivity.this,"是否登录成功:" + !loggedIn,Toast.LENGTH_SHORT).show();
//
//                //获取 AccessToken
//                AccessToken accessToken = AccessToken.getCurrentAccessToken();
//                //手动获取登录的用户信息
//                getLoginInfo(accessToken);
//
//            }
//        });

        callbackManager = CallbackManager.Factory.create();

        // facebook login
       mViewModel.userFaceBookLogin(callbackManager,this,fromTag);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public LoginModel getViewModel() {
        return ViewModelFactory.factory().getLoginModel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
