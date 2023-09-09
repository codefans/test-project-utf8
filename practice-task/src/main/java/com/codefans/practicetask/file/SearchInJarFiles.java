package com.codefans.practicetask.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Author: codefans
 * @Date: 2023-09-07 19:29
 */

public class SearchInJarFiles {

    public static void main(String[] args) {
        SearchInJarFiles searchInJarFiles = new SearchInJarFiles();
        searchInJarFiles.search();
    }

    public void search() {

        String jarDir = "D:\\test-project\\target\\lib";
        List<String> filePathList = this.getFilePaths(jarDir);
        System.out.println("jar包个数为:" + filePathList.size());
        for(String jarPath : filePathList) {
            searchInJar(jarPath);
        }


    }

    private void searchInJar(String jarPath) {
        try {
            JarFile zipFile = new JarFile(new File(jarPath));
            Enumeration<JarEntry> enumeration = zipFile.entries();
            while(enumeration.hasMoreElements()) {
                JarEntry jarEntry = enumeration.nextElement();
                String name = jarEntry.getName();
                if(name != null && name.endsWith("log4j2.xml")) {
                    System.out.println(jarEntry.getName() + ", jar=" + jarPath);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<String> getFilePaths(String jarDir) {
        List<String> filePathList = new ArrayList<>();
        this.getFilePaths(jarDir, filePathList);
        return filePathList;
    }

    private void getFilePaths(String jarDir, List<String> filePathList) {
        File dir = new File(jarDir);
        if(dir.isDirectory()) {
            File[] fileArr = dir.listFiles();
            for(File f : fileArr) {
                if(f.isDirectory()) {
                    getFilePaths(jarDir + File.separator + f.getName(), filePathList);
                } else {
                    if(isJarFile(f.getName())) {
                        filePathList.add(jarDir + File.separator + f.getName());
                    }
                }
            }
        } else {
            if(isJarFile(dir.getName())) {
                filePathList.add(jarDir);
            }
        }
    }

    private boolean isJarFile(String fileName) {
        if(fileName != null && fileName.endsWith(".jar")) {
            return true;
        }
        return false;
    }

}
