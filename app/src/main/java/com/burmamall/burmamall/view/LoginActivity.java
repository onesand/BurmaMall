package com.burmamall.burmamall.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.Button;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.viewmodel.login.LoginModel;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by sand on 2018/1/30.
 */

public class LoginActivity extends BaseActivity<LoginModel>{

    private Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button) findViewById(R.id.login_btn);
    }

    @Override
    public LoginModel getViewModel() {
        return ViewModelFactory.factory().getLoginModel();
    }
}
