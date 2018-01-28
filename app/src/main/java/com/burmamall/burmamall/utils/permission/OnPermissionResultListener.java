package com.burmamall.burmamall.utils.permission;

/***
 * 运行时权限申请监听器
 */
public interface OnPermissionResultListener {

    /**
     * 有部分权限申请未通过
     *
     * @param granted
     * @param denied
     */
    void onRequestPermissionsResult(String[] granted, String[] denied);

    /**
     * 所有权限申请通过
     */
    void onAllGranted();
}
