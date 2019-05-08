package com.codefans.reusablecode.performance;

import java.util.Random;

/**
 * @author: codefans
 * @date: 2019-02-15 14:04:43
 *
 * 原文：https://blog.csdn.net/sidihuo/article/details/78489820
 *
 */
public class BitAndModCompare {

    public static void main(String[] args) {
        BitAndModCompare bitAndModCompare = new BitAndModCompare();
        bitAndModCompare.compare();
    }

    public void compare() {
        long currentTimeMillis = System.currentTimeMillis();
        int a=0;
        int times = 10000*10000;
        for (long i = 0; i < times; i++) {
            a=new Random().nextInt(9999)%1024;
        }
        long currentTimeMillis2 = System.currentTimeMillis();

        int b=0;
        for (long i = 0; i < times; i++) {
            b=new Random().nextInt(9999)&(1024-1);
        }

        long currentTimeMillis3 = System.currentTimeMillis();
        System.out.println(a+","+b);
        System.out.println("%: "+(currentTimeMillis2-currentTimeMillis));
        System.out.println("&: "+(currentTimeMillis3-currentTimeMillis2));

    }


}
