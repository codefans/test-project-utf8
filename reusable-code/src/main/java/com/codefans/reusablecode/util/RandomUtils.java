/**
 * Copyright (C), 2015-2020, 京东
 * FileName: RandomUtils
 * Author:   caishengzhi
 * Date:     2020/4/4 11:27
 * Description: 随机工具类
 */
package com.codefans.reusablecode.util;


import java.util.*;

/**
 *
 * 随机工具类
 *
 * @author: caishengzhi
 * @Date: 2020/04/04 11:27
 * @since: 1.0.0
 */
public class RandomUtils {

    private static char[] lowerLetterArr = new char[]{
        'a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z',
    };

    private static char[] higherLetterArr = new char[]{
        'A','B','C','D','E','F','G','H','I','J','K','L','M',
        'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
    };

    private static char[] numArr = new char[]{
        '1','2','3','4','5','6','7','8','9','0'
    };

    private static char[] specialArr = new char[]{
        '`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=',
        '[',']','{','}','|','\\',':',';','"','\'','<','>',',','.','?','/',
    };

    private static char[] add(char[] arr1, char[] arr2) {
        int len = 0;
        if(arr1 != null) {
            len += arr1.length;
        }
        if(arr2 != null) {
            len += arr2.length;
        }
        char[] arr = new char[len];
        int index = 0;
        for(int i = 0; i < arr1.length; i ++) {
            arr[index++] = arr1[i];
        }
        for(int i = 0; i < arr2.length; i ++) {
            arr[index++] = arr2[i];
        }
        return arr;
    }

    public static String generateRandomStr(int length) {
        char[] resArr = add(lowerLetterArr, higherLetterArr);
        resArr = add(resArr, numArr);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < length; i ++) {
            sb.append(resArr[random.nextInt(resArr.length)]);
        }
        return sb.toString();
    }

}