package com.burmamall.burmamall.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by sand on 2018/1/24.
 */

public class TUtil {

    public static <T> T get(Object obj){
        try {
            Type genType = obj.getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)){
                return null;
            }
            //返回表示此类型实际类型的参数的 Type 对象数组
            Type[] parms = ((ParameterizedType)genType).getActualTypeArguments();
            Class<T> clzz = (Class<T>) parms[0];
            return clzz.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
