package com.burmamall.burmamall.utils;

/**
 * Created by sand on 2018/1/24.
 */

public interface ConstanModel {

    interface Login{
        int USER_LOGINED = 0;
        int USER_UNLOGIN = 1;
    }

    interface BurmamallApi{

        String BASE_URL = "http://111.231.215.157/Burmashop/";

        String BANNER_URL = "http://111.231.215.157/Burmashop/interface/banner.php";
    }
}
