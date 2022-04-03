package com.codefans.basicjava.byteopt;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-04-28 19:19:14
 */
public class BitMapTest {

    @Test
    public void basicTest() {

        int n = 11;
        System.out.println("n%8=" + (n%8));
        System.out.println("n&(8-1)=" + (n&(8-1)));
        System.out.println("n/8=" + (n/8));
        System.out.println("n>>3=" + (n>>3));

        int bitIndex = 65;
        int wordIndex = bitIndex>>6;
        System.out.println("bitIndex=" + bitIndex);
        System.out.println("wordIndex=" + wordIndex);

        /**
         * 33只有最低5位有效，即1
         * 65只有最低6位有效，即1
         */
        System.out.println("1<<33=" + (1<<33));
        System.out.println("1L<<65=" + (1L<<65));

        int num = 191;

        int index = num >> 6;

        // num%64得到在byte[index]的位置, 64对应的16进制数为0x3f
        int position = num & 0x3f;

        System.out.println("index=" + index);
        System.out.println("position=" + position);



    }

    /**
     * 1-32之间数字的排序,数字个数不能超过31.
     */
    @Test
    public void sortByBitMap() {

        int container = 0;
        int[] arr = new int[]{
            10, 31, 16, 19, 12, 18, 14, 17, 15, 10
        };
        int maxLen = 32;

        int position = 0;
        for(int i = 0; i < arr.length; i ++) {
            position = arr[i];
            container |= 1 << position;
        }

        for(int j = 0; j < maxLen; j ++) {
            if((container & (1 << j)) != 0) {
                System.out.println(j);
            }
        }






    }

    @Test
    public void bigDataSortTest() {

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
        long data = 0L;
        for(long i = 0; i < 4000000000L; i ++) {
            data = 15000000001L + i;
            bitmap.add(data);
//            System.out.println("[" + data + "] added!");
        }
        bitmap.add(15010198727L);

        System.out.println("插入15010198727成功");

        long beginTime = System.currentTimeMillis();
        System.out.println("beginTime=" + beginTime);
        boolean isexsit = bitmap.contain(15010198727L);
        System.out.println("15010198727是否存在:"+isexsit);
        long endTime = System.currentTimeMillis();
        System.out.println("costTime=" + (endTime - beginTime)/1000 + "s");

        data = 15036482636L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482637L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482638L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482639L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482640L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482641L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482642L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482643L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482644L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));

        data = 15036482645L;
        System.out.println(data + " " + (bitmap.contain(data) ? "存在" : "不存在"));


        bitmap.clear(15010198727L);
        isexsit = bitmap.contain(15010198727L);
        System.out.println("15010198727是否存在:"+isexsit);

    }

    @Test
    public void bitMoveTest() {

        int data = 1;
        System.out.println("%2=" + data%2);
        System.out.println("/2=" + data/2);
        System.out.println(">>1=" + (data>>1));
        System.out.println("*2=" + data*2);
        System.out.println("<<1=" + (data<<1));
        System.out.println("----------------------");

        data = 2;
        System.out.println(data + "%2=" + data%2);
        System.out.println(data + "/2=" + data/2);
        System.out.println(data + ">>1=" + (data>>1));
        System.out.println(data + "*2=" + data*2);
        System.out.println(data + "<<1=" + (data<<1));
        System.out.println("----------------------");

        data = 3;
        System.out.println(data + "%2=" + data%2);
        System.out.println(data + "/2=" + data/2);
        System.out.println(data + ">>1=" + (data>>1));
        System.out.println(data + "*2=" + data*2);
        System.out.println(data + "<<1=" + (data<<1));

    }


}
