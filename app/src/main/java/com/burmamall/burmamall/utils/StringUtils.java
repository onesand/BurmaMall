package com.burmamall.burmamall.utils;

/**
 * Created by sand on 2018/1/30.
 */

public class StringUtils {

    public static String getBannerImgName(String path){
//        upload/2018/01/30/20180130164641316.png
        int first = path.lastIndexOf("/");
        int last = path.lastIndexOf(".");
        return path.substring(first,path.length());
    }
}
