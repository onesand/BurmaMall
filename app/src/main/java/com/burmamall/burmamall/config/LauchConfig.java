package com.burmamall.burmamall.config;

import android.content.Context;
import android.content.Intent;

import com.burmamall.burmamall.view.LoginActivity;
import com.burmamall.burmamall.view.fragment.MainFragment;

/**
 * Created by sand on 2018/1/24.
 */

public class LauchConfig {

    public static void toMainActivity(Context context){
        Intent intent = new Intent(context, MainFragment.class);
        context.startActivity(intent);
    }

    public static void toLoginActivity(Context context,int fromTag){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("from_tag",fromTag);
        context.startActivity(intent);
    }

    public static void toLoginActivity(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
