package com.codefans.basicjava.byteopt;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-04-28 19:19:14
 */
public class BitMapTest {

    @Test
    public void basicTest() {

        int num = 191;

        int index = num >> 6;

        // num%64得到在byte[index]的位置, 63对应的16进制数为0x3f
        int position = num & 0x3f;

        System.out.println("index=" + index);
        System.out.println("position=" + position);

    }


    @Test
    public void test() {

        final long available = Runtime.getRuntime().totalMemory();
        final long freeMemory = Runtime.getRuntime().freeMemory();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {

                long afterAvailable = Runtime.getRuntime().totalMemory();
                System.out.println("total memory=" + (afterAvailable - available) / 1024 / 1024 + "G");

                long afterFreeMemory = Runtime.getRuntime().freeMemory();
                System.out.println("free memory=" + (freeMemory - afterFreeMemory) / 1024 / 1024 + "G");


            }

        });

        BitMap bitmap = new BitMap(20000000000L);
        bitmap.add(15010198727L);
        System.out.println("插入15010198727成功");

        boolean isexsit = bitmap.contain(15010198727L);
        System.out.println("15010198727是否存在:"+isexsit);

        bitmap.clear(15010198727L);
        isexsit = bitmap.contain(15010198727L);
        System.out.println("15010198727是否存在:"+isexsit);

    }

}
