/**
 * Copyright (C), 2015-2020, XXX
 * FileName: ParseUrlFromSpringMVCProjectByScanFile
 * Author:   codefans
 * Date:     2020/4/11 22:31
 * Description: 从SpringMVC项目中解析url
 */
package com.codefans.practicetask;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 从SpringMVC项目中解析url
 *
 * @author: codefans
 * @Date: 2020/04/11 22:31
 * @since: 1.0.0
 */
public class ParseUrlFromSpringMVCProjectByScanFile {

    @Test
    public void httpUrlCount() {

        String[] dirArr = new String[]{
                "D:\\jdProjects\\jd.plus.app\\jd-vip-plus-app-rest",
                "D:\\jdProjects\\jd.plus.app\\jd-vip-plus-app-web",
                "D:\\jdProjects\\jd.plus.app\\jd-vip-plus-app-mobile",
                "D:\\jdProjects\\jd.plus.app\\jd-vip-smc-app-mobile",
        };

        String rootDir = "D:\\project\\projectName";
        String urlPrefix = "";

        List<String> fileList = new ArrayList<String>();
        List<String> httpUrlList = new ArrayList<String>();
        long start = System.currentTimeMillis();
        int totalUrlCount = 0;

        for(int i = 0; i < dirArr.length; i ++) {
            rootDir = dirArr[i];
            urlPrefix = getUrlPrefix(rootDir);
            collect(rootDir, fileList);

            for (int j = 0; j < fileList.size(); j++) {
                List<String> list = collect(fileList.get(j));
                httpUrlList.addAll(list);
            }

            totalUrlCount += httpUrlList.size();
            System.out.println(rootDir + ", httpUrlCount:" + httpUrlList.size());
            System.out.println(rootDir + ", javaFileCount:" + fileList.size());
            System.out.println(rootDir + ", url列表如下:");
            for (int j = 0; j < httpUrlList.size(); j++) {
                String url = httpUrlList.get(j);
                System.out.println(urlPrefix + url);
            }

            fileList.clear();
            httpUrlList.clear();

        }
        long end = System.currentTimeMillis();

        System.out.println("totalUrlCount:" + totalUrlCount);
        System.out.println("cost:[" + (end - start) + "]ms");
    }

    public String getUrlPrefix(String rootDir) {
        if(rootDir.contains("jd-vip-plus-app-rest")) {
            return "http://rsp.jd.com";
        } else if(rootDir.contains("jd-vip-plus-app-web")) {
            return "http://plus.jd.com";
        } else if(rootDir.contains("jd-vip-plus-app-mobile")) {
            return "http://plus.m.jd.com";
        } else if(rootDir.contains("jd-vip-smc-app-mobile")) {
            return "http://smc.m.jd.com";
        }
        return "";
    }

    public void collect(String rootDir, List<String> fileList) {
        File rootFile = new File(rootDir);
        if(rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            for(int i = 0; i < files.length; i ++) {
                File f = files[i];
                if(f.isDirectory()) {
                    collect(rootDir + File.separator + f.getName(), fileList);
                } else {
                    if(f.getName().endsWith(".java")) {
                        fileList.add(f.getAbsolutePath());
                    }
                }
            }

        } else {
            if(rootFile.getName().endsWith(".java")) {
                fileList.add(rootFile.getAbsolutePath());
            }
        }
    }

    public List<String> collect(String path) {

        List<String> httpUrlList = new ArrayList<String>();

        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            String line = "";
            boolean isFirst = true;
            String urlPrefix = "";
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                if(StringUtils.isNotBlank(line)) {
                    line = line.trim();

                    if(isFirst && isRootUrl(line)) {
                        urlPrefix = parseUrl(line);
                        isFirst = false;
                    } else {
                        if (isHttpUrl(line)) {
                            httpUrlList.add(urlPrefix + parseUrl(line));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return httpUrlList;
    }

    public boolean isRootUrl(String line) {
        if(line.startsWith("@RequestMapping") && !line.contains("method")) {
            return true;
        }
        return false;
    }

    public boolean isHttpUrl(String line) {
        if(line.startsWith("@RequestMapping") || line.startsWith("@GetMapping") || line.startsWith("@PostMapping")) {
            return true;
        }
        return false;
    }

    public String parseUrl(String url) {
        if(StringUtils.isNotBlank(url)) {
            if(url.indexOf("\"/") >= 0) {
                url = url.substring(url.indexOf("\"/") + 1);
                url = url.substring(0, url.indexOf("\""));
            } else {
                url = "";
            }
        }
        return url;
    }

}