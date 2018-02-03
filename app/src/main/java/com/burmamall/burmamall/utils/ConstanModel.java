package com.burmamall.burmamall.utils;

/**
 * Created by sand on 2018/1/24.
 */

public interface ConstanModel {

    /**
     * 登录状态
     */
    interface Login{
        int USER_LOGINED = 0;
        int USER_UNLOGIN = 1;
    }

    /**
     * 登录方式
     */
    interface LoginType{
        int FACEBOOK = 0;
        int NORMAL = 1;
    }

    interface BurmamallApi{

        String BASE_URL = "http://111.231.215.157/Burmashop/";

        String BANNER_URL = "http://111.231.215.157/Burmashop/interface/banner.php";

        String FLASH_DEALS = "http://111.231.215.157/Burmashop/interface/recommended_goods.php";
    }
}
