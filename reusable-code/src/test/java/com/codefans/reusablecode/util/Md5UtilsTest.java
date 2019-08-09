package com.codefans.reusablecode.util;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2017-09-14 10:40
 * Md5Utils类单元测试
 **/
public class Md5UtilsTest {

    @Test
    public void getMd5StrTest() {
        String sourceStr = "hello";
        String md5Str = Md5Utils.getMd5Str(sourceStr);
        System.out.println("source:" + sourceStr);
        System.out.println("md5Str:" + md5Str);
        System.out.println("sourceStr.length:" + sourceStr.length());
        System.out.println("md5Str.length:" + md5Str.length());
        System.out.println("sourceStr.length==md5Str.length:" + (sourceStr.length()==md5Str.length()));
    }

    @Test
    public void decodeMD5StrTest() {

        String md5Str = "0a247e4796a02ae8dc96c27e03f17480";
        String verifyCode = "4588";
        String verifyCodeMD5Str = Md5Utils.getMd5Str(verifyCode);
        System.out.println("verifyCodeMD5Str=" + verifyCodeMD5Str); //verifyCodeMD5Str=fa131721954c3ddae16ee67620ffb2e0


    }



}
