package com.codefans.interview.algorithm;

import java.util.Arrays;

/**
 * @Author: codefans
 * @Date: 2019-01-29 21:28
 *
 * //评测题目: 请实现如下功能：

    1. 以字符串的形式给出两个整数，例如"12234237948283472974927349827349837492734"，给出的整数很大，会超出int型的最大长度，称之为大整数

    2. 请实现一个方法，输出两个大整数的加和

    3. 注意不要使用BigInteger这样的工具类

 */

public class BigIntegerAdd {

    public static void main(String[] args) {
        BigIntegerAdd bigIntegerAdd = new BigIntegerAdd();
        bigIntegerAdd.add();
    }

    public void add() {
        int num0 = 1234567890;

//        String num1 = "12345678987654321";
//        String num2 = "87654321012345679";

        //错误2: 最前面的0没有截取调
//        String num1 = "12345678987654321";
//        String num2 =    "54321012345679";

//        String num1 =    "45678987654321";
//        String num2 = "87654321012345679";

//        String num1 =    "45678987654321";
//        String num2 = " ";

//        String num1 =    null;
//        String num2 = "87654321012345679";

        String num1 =    "45678987654321";
        String num2 = "0";

        System.out.println("num1+num2=" + add(num1, num2));

    }

    public String addStrings(String num1, String num2) {
        num1 = this.filtePrefixZero(num1);
        num2 = this.filtePrefixZero(num2);
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int cur = 0;
        int added = 0;
        while(i >= 0 || j >= 0) {
            if(i >= 0 && j >= 0) {
                cur = toInt(num1.charAt(i)) + toInt(num2.charAt(j)) + added;
                //System.out.println(cur + ":" + toInt(num1.charAt(i)) + ":" + toInt(num2.charAt(j)));
            } else if(i >= 0) {
                cur = toInt(num1.charAt(i)) + added;
            } else if(j >= 0) {
                cur = toInt(num2.charAt(j)) + added;
            }
            added = cur / 10;
            cur = cur % 10;
            res.insert(0, cur);
            i--;
            j--;
        }
        if(added != 0) {
            res.insert(0, added);
        }
        return res.toString();
    }

    private int toInt(char c) {
        return c - 48;
    }

    /**
     * 过滤字符串最前面的0
     * @param str
     * @return
     */
    private String filtePrefixZero(String str) {
        int index = 0;
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        return str.substring(index, str.length());
    }

    public String add(String num1, String num2) {
        String result = "";

        if(this.isEmpty(num1) && this.isEmpty(num2)) {
            return result;
        } else if(this.isEmpty(num1) && this.isNotEmpty(num2)) {
            return num2;
        } else if(this.isNotEmpty(num1) && this.isEmpty(num2)) {
            return num1;
        }


        int len1 = num1.length();
        int len2 = num2.length();
        int length = 0;
        if(len1 >= len2) {
            length = len1;
        } else { //错误3: else漏了
            length = len2;
        }

        length = length + 1;
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        char[] resArr = new char[length];
        int add = 0;
        int sum = 0;
        if(len1 >= len2) {
            int index = arr2.length - 1;
            for(int i = arr1.length - 1; i >= 0;i --) {
                if(index >= 0) {
                    sum = parseInt(arr1[i]) + parseInt(arr2[index--]) + add;
                } else {
                    sum = parseInt(arr1[i]) + add;
                }
                resArr[--length] = int2char(sum % 10);
                add = sum / 10;
            }
            resArr[0] = int2char(add);
        } else {
            int index = arr1.length - 1;
            for(int i = arr2.length - 1; i >= 0;i --) {
                if(index >= 0) {
                    sum = parseInt(arr2[i]) + parseInt(arr1[index--]) + add;
                } else {
                    sum = parseInt(arr2[i]) + add;
                }
                resArr[--length] = int2char(sum % 10);
                add = sum / 10;
            }
            resArr[0] = int2char(add);
        }
        result = toString(resArr).trim();
        return result;
    }



    public boolean isEmpty(String str) {
        if(str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public String toString(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i ++) {
            if(i == 0 && chars[i] == '0') {

            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 错误1: char 转 int
     * @param c
     * @return
     */
    public int parseInt(char c) {
        return Integer.parseInt(c+"");
    }

    /**
     * 错误: int 转 char
     * @param n
     * @return
     */
    public char int2char(int n) {
        if(n == 0) {
            return '0';
        } else if(n == 1) {
            return '1';
        } else if(n == 2) {
            return '2';
        } else if(n == 3) {
            return '3';
        } else if(n == 4) {
            return '4';
        } else if(n == 5) {
            return '5';
        } else if(n == 6) {
            return '6';
        } else if(n == 7) {
            return '7';
        } else if(n == 8) {
            return '8';
        } else if(n == 9) {
            return '9';
        } else {
            return ' ';
        }
    }

}
