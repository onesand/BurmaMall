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

        String HOT_BRAND = "http://111.231.215.157/Burmashop/interface/brand.php";

        String NEW_ARRIVE = "http://111.231.215.157/Burmashop/interface/new_arrivals.php";

        String HOT_CATEGORIES = "http://111.231.215.157/Burmashop/interface/hot_sales.php";

        String STORE = "http://111.231.215.157/Burmashop/interface/seller.php";

        String GUESS_YOU_LIKE = "http://111.231.215.157/Burmashop/interface/guess_youlike.php";

        String AD = "http://111.231.215.157/Burmashop/interface/ad.php";
    }
}
