package com.codefans.basicjava.byteopt;

import org.apache.commons.lang.BooleanUtils;

/**
 * @author: codefans
 * @date: 2019-05-02 17:54:03
 *
 * 参考资料：
 *      Java基础数据类型二进制转换
 *      http://www.cnblogs.com/fangfan/p/4086662.html
 */
public class ConvertToBit {

    public static void main(String[] args) {

        /**
         * 1个字节
         */
        byte b = 1;
        /**
         * 1个字节
         */
        boolean flag = false;
        /**
         * 2个字节
         */
        short s = 1;
        /**
         * 2个字节
         */
        char c = '1';
        /**
         * 4个字节
         */
        int n = 1;
        /**
         * 4个字节
         */
        float f = 1f;
        /**
         * 8个字节
         */
        long l = 1L;
        /**
         * 8个字节
         */
        double d = 1;

//        System.out.println(Byte.parseByte("1"));

        ConvertToBit convertToBit = new ConvertToBit();
//        convertToBit.minAndMaxValue();
//        convertToBit.byte2bit();
        convertToBit.boolean2bit();
//        convertToBit.short2bit();
//        convertToBit.char2bit();
//        convertToBit.int2bit();
//        convertToBit.long2bit();

        System.out.println(convertToBit.byte2bit(b));
        System.out.println(convertToBit.short2bit(s));
        System.out.println(convertToBit.char2bit(c));
        System.out.println(convertToBit.int2bit(n));
        System.out.println(convertToBit.float2bit(f));
        System.out.println(convertToBit.double2bit());

    }

    public void minAndMaxValue() {
        System.out.println("Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println("Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println("Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println("Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println("Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE=" + Double.MAX_VALUE);
    }


    public void byte2bit() {
        byte b = 1;
        String bStr = Byte.toString(b);
        System.out.println(bStr);
        System.out.println(Byte.toUnsignedInt(b));
        System.out.println(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1));

        int maxByte = 255;
        for(int i = 0; i <= maxByte; i ++) {
//            b = (byte)this.setHigh24ToZero(i);
            b = (byte)i;
            System.out.println("byte[" + b + "]的二进制字符串为=" + this.byte2bit(b));
        }


    }

    /**
     * 将高24位设置为0
     * @param n
     * @return
     */
    public int setHigh24ToZero(int n) {
        for(int i = 8; i < 32; i ++) {
            n &= ~(1<<i);
        }
        return n;
    }

    public String byte2bit(byte b) {
        StringBuffer sb = new StringBuffer();

        int bitLen = 8;
        for(int i = 0; i < bitLen; i ++) {
            if((b & (1<<i)) != 0) {
                sb.insert(0, "1");
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    public void boolean2bit() {

        System.out.println(Boolean.hashCode(true));
        System.out.println(Boolean.hashCode(false));

        int booleanInt = BooleanUtils.toInteger(true);
        System.out.println("booleanInt:" + booleanInt);

    }

    public String boolean2bit(boolean flag) {
        StringBuffer sb = new StringBuffer();

        int bitLen = 8;
        for(int i = 0; i < bitLen; i ++) {
//            if((Boolean.toString(flag) & (1<<i)) != 0) {
//                sb.insert(0, "1");
//            } else {
//                sb.insert(0, "0");
//            }
        }

        return sb.toString();
    }

    public void short2bit() {

//        int maxShort = Math.abs(Short.MIN_VALUE) + Short.MAX_VALUE;
        short maxShort = Short.MAX_VALUE;
        System.out.println("Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE=" + Short.MAX_VALUE); //32767
        System.out.println("maxShort=" + maxShort);

        int n = 65546;
        short s = (short)n;
        System.out.println("int[" + n + "]的二进制字符串为=" + this.int2bit(n));
        System.out.println("short[" + s + "]的二进制字符串为=" + this.short2bit(s));

        short one = 1;
        short two = 2;
//        short sun = one + two;

        /**
         * 如果是i<=maxShort，会导致死循环，可能是i++导致，由于两个short相加会自动转换int型，再转成short型，这样就会损失精度，变为负数。
         *
         * 疑问：
         *    如果两个short相加，超过short类型的最大值Short.MAX_VALUE，为什么结果会变成负数？
         *
         */
        for(short i = 0; i <= maxShort; i ++) {
            s = i;
            if(i == Short.MIN_VALUE) {
                System.out.println(i);
            }
            if(i == Short.MAX_VALUE) {
                System.out.println(i);
            }

            System.out.println("第[" + (s+one) + "]行，short[" + s + "]的二进制字符串为=" + this.short2bit(s));
        }

    }

    /**
     * short类型，占2个字节
     * @param s
     * @return
     */
    public String short2bit(short s) {
        StringBuffer sb = new StringBuffer();
        int bitLen = 16;
        for(int i = 0; i < bitLen; i ++) {
            if((s & (1<<i)) != 0) {
                sb.insert(0, "1");
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    public void char2bit() {
        char[] chars = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=', '{', '}', '|', '[', ']', '\\',
            ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/'
        };

        char c = ' ';
        for(int i = 0; i < chars.length; i ++) {
            c = chars[i];
            System.out.println("字符[" + c + "],对应的ASCII码为:[" + (int)c + "],对应的二进制字符串为:[" + char2bit(c) + "]");
        }

    }

    /**
     * char类型，占2个字节
     * @param c
     * @return
     */
    public String char2bit(char c) {
        StringBuffer sb = new StringBuffer();
        int bitLen = 16;
        for(int i = 0; i < bitLen; i ++) {
            if((c & (1<<i)) != 0) {
                sb.insert(0, "1");
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    public void int2bit() {
        int n = 0;
        int maxInt = Integer.MAX_VALUE;
        for(int i = 0; i < maxInt; i ++) {
            n = i;
            System.out.println("int[" + n + "]的二进制字符串为=" + this.int2bit(n));
        }
    }

    public String int2bit(int n) {
        StringBuffer sb = new StringBuffer();
        int bitLen = 32;
        for(int i = 0; i < bitLen; i ++) {
            if((n & (1<<i)) != 0) {
                sb.insert(0, "1");
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    public String float2bit() {
        StringBuffer sb = new StringBuffer();

        return sb.toString();
    }

    public String float2bit(float f) {
        StringBuffer sb = new StringBuffer();

        int fInt = Float.floatToIntBits(f);
        int bitLen = 32;
        for(int i = 0; i < bitLen; i ++) {
            if((fInt & (1<<i)) != 0) {
                sb.insert(0, "1");
            } else {
                sb.insert(0, "0");
            }
        }

        return sb.toString();
    }

    public void long2bit() {
        long l = 0;
        long maxLong = Long.MAX_VALUE;
        for(int i = 0; i < maxLong; i ++) {
            l = i;
            System.out.println("long[" + l + "]的二进制字符串为=" + this.long2bit(l));
        }
    }

    public String long2bit(long l) {
        StringBuffer sb = new StringBuffer();
        int bitLen = 64;
        for(int i = 0; i < bitLen; i ++) {
            if((l & (1<<i)) != 0) {
                sb.insert(0, "1");
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    public String double2bit() {
        StringBuffer sb = new StringBuffer();

        return sb.toString();
    }

    public String double2bit(double d) {
        long dLong = Double.doubleToLongBits(d);
        return this.long2bit(dLong);
    }

//    public String core2bit(int bitLen) {
//
//    }



}
