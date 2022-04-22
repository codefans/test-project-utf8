package com.codefans.practicetask.file;

import java.text.DecimalFormat;

/**
 * @Author: codefans
 * @Date: 2020-06-13 17:50
 */

public class FileBase {

    public static final long KB = 1024;
    public static final long MB = 1048576;
    public static final long G = 1073741824;

    public static String formetFileSize(long fileS) {// 转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < KB) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < MB) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < G) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

}
