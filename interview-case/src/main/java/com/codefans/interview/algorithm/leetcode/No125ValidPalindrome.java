package com.codefans.interview.algorithm.leetcode;

/**
 * @author: codefans
 * @date: 2019-04-02 19:29:18
 */
public class No125ValidPalindrome {

    public static void main(String[] args) {
        No125ValidPalindrome no125ValidPalindrome = new No125ValidPalindrome();
        no125ValidPalindrome.isPalindrome();
    }

    public void isPalindrome() {

        String testStr01 = "A man, a plan, a canal: Panama";
        String testStr02 = "race a car";

        boolean isPalindrome = false;
        isPalindrome = this.isPalindrome(testStr01);
        System.out.println("[" + testStr01 + "], isPalindrome=" + isPalindrome);

        isPalindrome = this.isPalindrome(testStr02);
        System.out.println("[" + testStr02 + "], isPalindrome=" + isPalindrome);




    }

    public boolean isPalindrome(String s) {
        boolean isPalindrome = false;

//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println((int)'0');
//        System.out.println((int)'9');
//        System.out.println((int)'a');
//        System.out.println((int)'z');

        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder oppositeStr = new StringBuilder();

        char c = ' ';
        for(int i = 0; i < chars.length; i ++) {
            c = chars[i];
            if(this.isValidChar(c)) {
                sb.append(c);
                oppositeStr.insert(0, c);
            }
        }
        isPalindrome = sb.toString().equals(oppositeStr.toString());

        return isPalindrome;
    }

    public boolean isValidChar(char c) {
        int val = (int)c;
        if(val >= 65 && val <= 90) {
            return true;
        }
        if(val >= 48 && val <= 57) {
            return true;
        }
        if(val >= 97 && val <= 122) {
            return true;
        }
        return false;
    }

}
