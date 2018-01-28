package com.burmamall.burmamall.utils.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.burmamall.burmamall.utils.ActivityCollector;
import com.burmamall.burmamall.utils.L;
import com.burmamall.burmamall.utils.Utils;
import com.burmamall.burmamall.utils.action.IAction;
import com.burmamall.burmamall.utils.action.IAction2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 运行时权限申请工具类
 * <p>
 * Created by melorin on 2017/3/23.
 */
public class PermissionsUtil {

    static final String TAG = "Permissions";

    public static void requestPermissions(OnPermissionResultListener listener, @NonNull String permission, String... permissions) {
        requestPermissions(null, listener, permission, permissions);
    }

    /**
     * 对外开放方法，对系统版本进行区分
     *
     * @param activity
     * @param onAllGranted
     * @param onRequestPermissionsResult
     * @param permission
     * @param permissions
     */
    public static void requestPermissions(Activity activity, IAction onAllGranted, IAction2<String[], String[]> onRequestPermissionsResult, @NonNull String permission, String... permissions) {
        requestPermissions(activity, new OnPermissionResultListener() {
            @Override
            public void onRequestPermissionsResult(String[] granted, String[] denied) {
                if (onRequestPermissionsResult != null) {
                    onRequestPermissionsResult.invoke(granted, denied);
                }
            }

            @Override
            public void onAllGranted() {
                if (onAllGranted != null) {
                    onAllGranted.invoke();
                }
            }
        }, permission, permissions);
    }

    /**
     * 对外开放方法，对系统版本进行区分
     *
     * @param activity
     * @param listener
     * @param permission
     * @param permissions
     */
    public static void requestPermissions(Activity activity, OnPermissionResultListener listener, @NonNull String permission, String... permissions) {
        // Android M以下系统返回现有权限状态，不做申请操作
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            activity = checkActivity(activity);
            if (activity == null) {
                return;
            }
            List<String> permissionList = new LinkedList<>();
            permissionList.add(permission);
            permissionList.addAll(Arrays.asList(permissions));
            String[] granted = getGrantedPermissions(activity, permissionList.toArray(new String[]{}));
            String[] denied = getDeniedPermissions(activity, permissionList.toArray(new String[]{}));

            if (denied.length == 0) {
                listener.onAllGranted();
            } else {
                listener.onRequestPermissionsResult(granted, denied);
            }
            return;
        }
        List<String> permissionList = new LinkedList<>();
        permissionList.add(permission);
        permissionList.addAll(Arrays.asList(permissions));
        requestPermissions(activity, permissionList.toArray(new String[]{}), 1, listener);
    }

    /**
     * 权限申请入口
     *
     * @param activity
     * @param permissions
     * @param requestCode
     * @param listener
     */
    @TargetApi(Build.VERSION_CODES.M)
    private static void requestPermissions(Activity activity, @NonNull String[] permissions, int requestCode, OnPermissionResultListener listener) {
        // 传入Activity及栈顶Activity均为空时返回现有权限状态
        activity = checkActivity(activity);
        if (activity == null) {
            L.e("Permissions", "App is background and activity is null");
            if (listener != null) {
                listener.onRequestPermissionsResult(getGrantedPermissions(Utils.getContext(), permissions), getDeniedPermissions(Utils.getContext(), permissions));
            }
            return;
        }
        MyPermissionFragment fragment = findPermissionFragment(activity);
        // PermissionFragment初始化完成后根据TAG添加至Activity
        if (fragment == null) {
            fragment = new MyPermissionFragment().context(activity);
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction()
                    .add(fragment, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();

        }
        fragment.requestPermissions(permissions, requestCode, listener);
    }

    /**
     * 获取PermissionFragment
     *
     * @param activity
     * @return
     */
    private static MyPermissionFragment findPermissionFragment(Activity activity) {
        return (MyPermissionFragment) activity.getFragmentManager().findFragmentByTag(TAG);
    }

    /**
     * 校验单个权限
     *
     * @param permission
     * @return
     */
    public static int checkPermission(Context context, String permission) {
        if (context == null) {
            return PackageManager.PERMISSION_DENIED;
        }
        return ContextCompat.checkSelfPermission(context, permission);
    }

    /**
     * 对Activity进行校验，返回传入Activity或栈顶Activity
     *
     * @param activity
     * @return
     */
    private static Activity checkActivity(Activity activity) {
        if (activity != null) {
            return activity;
        }
        return ActivityCollector.getTopActivity();
    }

    public static String[] getGrantedPermissions(Context context, @NonNull String[] permissions) {
        List<String> granted = new LinkedList<>();
        for (String perm : permissions) {
            if (checkPermission(context, perm) == PackageManager.PERMISSION_GRANTED) {
                granted.add(perm);
            }
        }
        return granted.toArray(new String[]{});
    }

    public static String[] getDeniedPermissions(Context context, @NonNull String[] permissions) {
        List<String> denied = new LinkedList<>();
        for (String perm : permissions) {
            if (checkPermission(context, perm) != PackageManager.PERMISSION_GRANTED) {
                denied.add(perm);
            }
        }
        return denied.toArray(new String[]{});
    }
}
