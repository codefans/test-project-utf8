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

        /**
         * 与运算符&
         * 运算规则：0&0=0;  0&1=0;   1&0=0;    1&1=1;
         * 即：两位同时为“1”，结果才为“1”，否则为0
         * 使用场景：
         *    用于判断某一位是否为1。
         */
        int n = 5;
        /**
         * 判断第3位是否为1，如果输出true，则第3位是1，否则为0。
         */
        System.out.println(n + "的第2位是否为1:[" + (((n >> 1) & 1) != 0) + "]");
        System.out.println(n + "的第3位是否为1:[" + (((n >> 2) & 1) != 0) + "]");

        /**
         * 或运算符|
         * 运算规则：0|0=0；  0|1=1；  1|0=1；   1|1=1；
         * 即 ：参加运算的两个对象只要有一个为1，其值为1。
         * 使用场景：
         *    用于将某一位设置为1。
         */
        n = 6;
        /**
         * 将第4位设置为1，如果输出14，则设置成功，否则设置失败。
         */
        System.out.println("将[" + n + "]第4位设置为1后的值为:["+ (n|(1<<3)) + "]");

        /**
         * 取反运算符~
         * 运算规则：~1=0；  ~0=1；
         * 即：对一个二进制数按位取反，即将0变1，1变0。
         * 使用场景：
         *    用于将某一位设置为0，常和与运算符&配合使用。
         */


        /**
         * ^异或，只有在两个比较的位不同时其结果是1，否则结果为0。
         * 例如通过^异或运算,不借助第3个变量完成两个值的互换。如果：
         * a = 170, 二进制数为: 1010 1010
         * b = 85, 二进制数为: 0101 0101
         * a = a^b;
         *   1010 1010
         * ^ 0101 0101
         * -----------
         * a 1111 1111
         *
         * b = a^b;
         *   1111 1111
         * ^ 0101 0101
         * -----------
         * b 1010 1010
         *
         * a = a^b;
         *   1111 1111
         * ^ 1010 1010
         * -----------
         * a 0101 0101
         */
        int a = 170;
        int b = 85;
        System.out.println("互换前a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("互换后a=" + a + ", b=" + b);

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

        //^异或，只有在两个比较的位不同时其结果是1，否则结果为0。
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }



}
