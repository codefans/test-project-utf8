package com.codefans.basicjava.util;

import java.util.Random;

/**
 * @author: codefans
 * @date: 2019-09-16 17:32
 */
public class RandomUtils {

    /**
     * 返回0-max直接的随机数
     * @param max
     * @return
     */
    public static int nextInt(int max) {
        return new Random().nextInt(max);
    }

    /**
     * 返回min-max之间的随机数
     * @param min
     * @param max
     * @return
     */
    public static int nextInt(int min, int max) {
        return new Random().nextInt(max-min) + min;
    }

}
