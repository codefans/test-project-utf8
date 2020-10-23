package com.codefans.practicetask;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: codefans
 * @Date: 2020-10-22 08:41
 */

public class ProjectStatistic {

    private String rootDir;

    ProjectStatistic(String rootDir) {
        this.rootDir = rootDir;
    }

    private AtomicLong javaFileCount = new AtomicLong(0);

    public static void main(String[] args) {
        String rootDir = "G:\\GitHub\\test-project-utf8";
        ProjectStatistic projectStatistic = new ProjectStatistic(rootDir);
        long javaFileCount = projectStatistic.javaFileCount();
        System.out.println("javaFileCount:" + javaFileCount);
    }

    public long javaFileCount() {
        javaFileCount(rootDir);
        return javaFileCount.get();
    }

    public void javaFileCount(String path) {
        File dir = new File(path);
        if(dir.isDirectory()) {
            File[] fileArr = dir.listFiles();
            for(int i = 0; i < fileArr.length; i ++) {
                File f = fileArr[i];
                if(f.isDirectory()) {
                    javaFileCount(path + File.separator + f.getName());
                } else {
                    judgeSingleFile(f);
                }
            }
        } else {
            judgeSingleFile(dir);
        }
    }

    public void judgeSingleFile(File file) {
        if(isJavaFile(file.getName())) {
            javaFileCount.getAndIncrement();
        }
    }

    private boolean isJavaFile(String fileName) {
        return fileName.endsWith(".java");
    }


}
