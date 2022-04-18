package com.codefans.basicjava.resourceload;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Author: codefans
 * @Date: 2022-04-18 22:51
 * 加载class path下非class资源文件
 */

public class ResourceLoadMain {

    public static void main(String[] args) throws IOException {
        String path = "META-INF";
        String resouce = "com.codefans.resourceload.TestApi";
        String resourcePath = path + File.separator + resouce;
        System.out.println("resourcePath=" + resourcePath);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL url = classLoader.getResource(resourcePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = "";
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }


}
