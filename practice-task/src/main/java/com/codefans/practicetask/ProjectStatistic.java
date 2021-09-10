package com.codefans.practicetask;

import java.io.File;
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
    private AtomicLong javaSourceCount = new AtomicLong(0);
    private AtomicLong javaTestSourceCount = new AtomicLong(0);

    public static void main(String[] args) {
//        String rootDir = "D:/github/test-project-utf8/";
//        String rootDir = "D:/jdProjects/jd.plus.app";
        String rootDir = "D:/jdProjects/jd.plus.app-gradle";
        ProjectStatistic projectStatistic = new ProjectStatistic(rootDir);
        long javaFileCount = projectStatistic.javaFileCount();
        System.out.println("javaFileCount:" + javaFileCount);

        long javaSourceCount = projectStatistic.javaSourceCount();
        System.out.println("javaSourceCount:" + javaSourceCount);

        long javaTestSourceCount = projectStatistic.javaTestSourceCount();
        System.out.println("javaTestSourceCount:" + javaTestSourceCount);
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

    public long javaSourceCount() {
        if(javaSourceCount.get() > 0) {
            return javaSourceCount.get();
        }
        javaFileCount(rootDir);
        return javaSourceCount.get();
    }

    public long javaTestSourceCount() {
        if(javaTestSourceCount.get() > 0) {
            return javaTestSourceCount.get();
        }
        javaFileCount(rootDir);
        return javaTestSourceCount.get();
    }

    public void judgeSingleFile(File file) {
        if(isJavaFile(file.getName())) {
            javaFileCount.getAndIncrement();
            String absolutePath = file.getAbsolutePath();
            if(absolutePath.indexOf("src\\test\\java") >= 0) {
                javaTestSourceCount.getAndIncrement();
            } else if(absolutePath.indexOf("src\\main\\java") >= 0) {
                javaSourceCount.getAndIncrement();
            }
        }
    }



    private boolean isJavaFile(String fileName) {
        return fileName.endsWith(".java");
    }


}
