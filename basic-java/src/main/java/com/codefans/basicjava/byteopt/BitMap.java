package com.codefans.basicjava.byteopt;

/**
 * @author: codefans
 * @date: 2019-04-28 18:55:03
 */
public class BitMap {

    private long[] datas;

    private long capacity;

    public BitMap(long capacity){
        this.capacity = capacity;

        //1个long能存储64个数据，那么capacity数据需要多少个long呢，capacity/64+1,右移6位相当于除以64
        datas = new long[(int)(capacity >> 6 )+1];
    }

    public void add(long num){
        // num/64得到datas[]的index.(取前64-6=58位)
        long arrayIndex = num >> 6; //这里的6是由num的类型决定的, 如果num是int类型, 则不是6而是5.

        // num%64得到在byte[index]的位置, 63对应的16进制数为0x3f.(取后6位)
//        long position = num & 0x3f;
        //直接写成63也行
        long position = num & 63;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
        datas[(int)arrayIndex] |= 1 << position;
    }

    public boolean contain(long num){
        // num/64得到datas[]的index
        long arrayIndex = num >> 6;

        // num%64得到在datas[index]的位置
//        long position = num & 0x3f;
        //直接写成63也行
        long position = num & 63;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (datas[(int)arrayIndex] & (1 << position)) !=0;
        /**
         * 不等于0,不代表等于1。所以下面这种写法是不对的。
         */
//        return (datas[(int)arrayIndex] & (1 << position)) == 1;
    }

    public void clear(long num){
        // num/64得到byte[]的index
        long arrayIndex = num >> 6;

        // num%64得到在byte[index]的位置
//        long position = num & 0x3f;
        //直接写成63也行
        long position = num & 63;

        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        datas[(int)arrayIndex] &= ~(1 << position);

    }


}
