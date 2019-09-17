package com.codefans.basicjava.util;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-09-16 17:34
 */
public class RandomUtilsTest {

    @Test
    public void nextIntTest() {

        System.out.println(RandomUtils.nextInt(10));

    }

    @Test
    public void nextIntRangeTest() {

        System.out.println(RandomUtils.nextInt(10, 20));
        System.out.println(RandomUtils.nextInt(10, 20));
        System.out.println(RandomUtils.nextInt(10, 20));
        System.out.println(RandomUtils.nextInt(10, 20));
        System.out.println(RandomUtils.nextInt(10, 20));

    }


}
