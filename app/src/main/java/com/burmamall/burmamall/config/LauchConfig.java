package com.burmamall.burmamall.config;

import android.content.Context;
import android.content.Intent;

import com.burmamall.burmamall.MainActivity;

/**
 * Created by sand on 2018/1/24.
 */

public class LauchConfig {

    public static void toMainActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
