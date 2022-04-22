package com.codefans.practicetask.scannerdisk;

import java.io.File;
import java.util.Map;

/**
 * @Author: codefans
 * @Date: 2022-04-22 18:35
 */

public class GetFolderSizeTask implements Runnable {

    private String path;

    private Map<String, String> dataMap;

    public GetFolderSizeTask(String path, Map<String, String> dataMap) {
        this.path = path;
        this.dataMap = dataMap;
    }

    @Override
    public void run() {
        try {
            File file = new File(path);
            long fileSize = this.getFileSize(file);
            dataMap.put(path, String.valueOf(fileSize));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 递归计算文件夹大小
     * @param f
     * @return
     * @throws Exception
     */
    public long getFileSize(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        if (flist != null) {
            for (int i = 0; i < flist.length; i++) {
                if (flist[i].isDirectory()) {
                    size = size + getFileSize(flist[i]);
                } else {
                    size = size + flist[i].length();
                }
            }
        }
        return size;
    }
}
