package com.codefans.interview.algorithm.leetcode;

/**
 * @author: codefans
 * @date: 2019-03-29 22:25:32
 *
 * 121
 *   x=12, rev=1
 *   x=1, rev=12
 *
 * 1221
 *   x=122, rev=1
 *   x=12, rev=12
 *
 * 12321
 *   x=1232, rev=1
 *   x=123, rev=12
 *   x=12, rev=123
 *
 *
 */
public class No9PalindromeNumber {

    public static void main(String[] args) {
        No9PalindromeNumber no9PalindromeNumber = new No9PalindromeNumber();
        no9PalindromeNumber.isPalindrome();
    }

    public void isPalindrome() {

        int num1 = 1;
        int num2 = 11;
        int num3 = 121;
        int num4 = 1221;
        int num5 = 12321;
        int num6 = -1;
        int num7 = 10;
        int num8 = -121;
        int num9 = 1001;
        int num10 = 1232;
        int num11 = 1234554321;

//        System.out.printf("%d " + (isPalindrome(num1) ? "is" : " is not ") + " palindrome", num1);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num2) ? "is" : " is not ") + " palindrome", num2);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num3) ? "is" : " is not ") + " palindrome", num3);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num4) ? "is" : " is not ") + " palindrome", num4);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num5) ? "is" : " is not ") + " palindrome", num5);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num6) ? "is" : " is not ") + " palindrome", num6);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num7) ? "is" : " is not ") + " palindrome", num7);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num8) ? "is" : " is not ") + " palindrome", num8);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num9) ? "is" : " is not ") + " palindrome", num9);System.out.println();
//        System.out.printf("%d " + (isPalindrome(num10) ? "is" : " is not ") + " palindrome", num10);System.out.println();
        System.out.printf("%d " + (isPalindrome(num11) ? "is" : " is not ") + " palindrome", num11);System.out.println();


    }

    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
            System.out.printf("x=%d, rev=%d", x, rev);System.out.println();
        }
        System.out.println();
        return (x==rev || x==rev/10);
    }

}
