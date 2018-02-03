package com.burmamall.burmamall.utils;

import android.text.TextUtils;

/**
 * Created by sand on 2018/1/30.
 */

public class StringUtils {

    public static String getImgName(String path){
        int first = path.lastIndexOf("/");
        return path.substring(first,path.length());
    }
}
