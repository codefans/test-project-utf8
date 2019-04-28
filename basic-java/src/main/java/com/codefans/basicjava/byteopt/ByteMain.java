package com.codefans.basicjava.byteopt;

/**
 * @author: codefans
 * @date: 2019-01-23 18:28:13
 */
public class ByteMain {

    public static void main(String[] args) {
        ByteMain bitMain = new ByteMain();
        bitMain.test();
    }


    public void test() {

        this.basicGrammar();
        this.divisionConvertToBitAnd();
        this.swap();


    }

    /**
     * 1.左移运算符（<<）规则
     * 　　按二进制形式把所有的数字向左移动对应的位数，高位移出(舍弃)，低位的空位补零。
     * 语法格式:
     *    需要移位的数字 << 移位的次数
     * 　　例如： 3 << 2，则是将数字3左移2位
     * 计算过程：
     *    3 << 2
     * 　　首先把3转换为二进制数字0000 0000 0000 0000 0000 0000 0000 0011，然后把该数字高位(左侧)的两个零移出，其他的数字都朝左平移2位，最后在低位(右侧)的两个空位补零。则得到的最终结果是0000 0000 0000 0000 0000 0000 0000 1100，则转换为十进制是12。
     * 数学意义：
     *    在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
     *
     * 2.右移运算符（>>）规则
     *    按二进制形式把所有的数字向右移动对应位移位数，低位移出(舍弃)，高位的空位补符号位，即正数补零，负数补1。
     * 语法格式：
     *    需要移位的数字 >> 移位的次数
     * 　　例如11 >> 2，则是将数字11右移2位
     * 计算过程：
     * 11的二进制形式为：0000 0000 0000 0000 0000 0000 0000 1011，然后把低位的最后两个数字移出，因为该数字是正数，所以在高位补零。则得到的最终结果是0000 0000 0000 0000 0000 0000 0000 0010。转换为十进制是2。
     * 数学意义：
     * 右移一位相当于除2，右移n位相当于除以2的n次方。
     *
     * 3.无符号右移运算符规则
     *    按二进制形式把所有的数字向右移动对应位数，低位移出(舍弃)，高位的空位补零。对于正数来说和带符号右移相同，对于负数来说不同。
     * 　　其他结构和>>相似。
     */
    public void basicGrammar() {

        /**
         * 将数字1右移6位
         */
        System.out.println(1<<6);

        /**
         * 将数字6右移1位
         */
        System.out.println(6<<1);

    }

    /**
     * HashMap中定位槽的方法:
     * static int indexFor(int h, int length) {
     *      return h & (length-1);
     * }
     *
     * 其中只有length为2的幂时,h&(length-1)才会等于h%length
     */
    public void divisionConvertToBitAnd() {

        System.out.println("5%2=" + 5%2);
        System.out.println("(5 & (2 - 1))=" + (5 & (2 - 1)));

        System.out.println("7%4=" + 7%4);
        System.out.println("(7 & (4 - 1))=" + (7 & (4 - 1)));

        System.out.println("13%8=" + 13%8);
        System.out.println("(13 & (8 - 1))=" + (13 & (8 - 1)));

        System.out.println("23%16=" + 23%16);
        System.out.println("(23 & (16 - 1))=" + (23 & (16 - 1)));

    }

    public void swap() {

        this.swapIntUsingNoTemp();
        this.swapIntUsingByteMove();

    }

    public void swapIntUsingNoTemp() {

        System.out.println("swapIntUsingNoTemp:");

        int a = 3;
        int b = 5;

        System.out.println("a=" + a);
        System.out.println("b=" + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public void swapIntUsingByteMove() {

        System.out.println("swapIntUsingByteMove:");

        int a = 3;
        int b = 5;

        System.out.println("a=" + a);
        System.out.println("b=" + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }



}
