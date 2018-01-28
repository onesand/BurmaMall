package com.burmamall.burmamall.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by melorin on 2017/2/28.
 */
public class ActivityCollector {

    private static List<Activity> mActivities = new ArrayList<>();

    /**
     * OnResume进入列表
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    /**
     * OnPause移除列表
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    public static Activity getTopActivity() {
        return mActivities.get(mActivities.size() - 1);
    }

    /**
     * 程序在后台时列表为空
     *
     * @return
     */
    public static boolean isBackground() {
        return mActivities.isEmpty();
    }

    /**
     * 关闭所有打开的活动界面
     */
    public static void clear() {
        Iterator<Activity> iterator = mActivities.iterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            if (activity != null) {
                activity.finish();
            }
            iterator.remove();
        }
    }
}
