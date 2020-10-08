/**
 * Copyright (C), 2015-2020, 京东
 * FileName: RandomUtilsTest
 * Author:   codefans
 * Date:     2020/4/4 11:44
 * Description: 随机类测试
 */
package com.codefans.reusablecode.util;


import org.junit.Test;

/**
 *
 * 随机类测试
 *
 * @author: codefans
 * @Date: 2020/04/04 11:44
 * @since: 1.0.0
 */
public class RandomUtilsTest {


    @Test
    public void randomStrTest() {

        int len = 32;
        String randomStr = RandomUtils.generateRandomStr(len);
        System.out.println(randomStr);

    }

}