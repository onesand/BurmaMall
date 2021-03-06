package com.burmamall.burmamall.utils;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sand on 2018/1/30.
 */

public class FileHelper {

    public final static String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/burmaMall/";
    public final static String BANNER_IMAGE = ROOT_PATH + "banner/";
    public final static String USER_IMAGE = ROOT_PATH + "userIcon/";

    static {
       createFolder();
    }

    public static void createFolder(){
        File dir = new File(ROOT_PATH);
        if (!dir.exists())
            dir.mkdirs();

        dir = new File(BANNER_IMAGE);
        if (!dir.exists())
            dir.mkdirs();

        dir = new File(USER_IMAGE);
        if (!dir.exists())
            dir.mkdirs();
    }

    /**
     * 获取目录下所有文件(按时间排序)
     *
     * @param path
     * @return
     */
    public static List<File> listFileSortByModifyTime(String path) {
        List<File> list = getFiles(path, new ArrayList<File>());
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<File>() {
                public int compare(File file, File newFile) {
                    if (file.lastModified() < newFile.lastModified()) {
                        return 1;
                    } else if (file.lastModified() == newFile.lastModified()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        }
        return list;
    }

    /**
     *
     * 获取目录下所有文件
     *
     * @param realpath
     * @param files
     * @return
     */
    public static List<File> getFiles(String realpath, List<File> files) {
        File realFile = new File(realpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath(), files);
                } else {
                    files.add(file);
                }
            }
        }
        return files;
    }
}
