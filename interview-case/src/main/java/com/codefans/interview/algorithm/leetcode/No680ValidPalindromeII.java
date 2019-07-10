package com.codefans.interview.algorithm.leetcode;

/**
 * @Author: codefans
 * @Date: 2019-07-10 23:22
 *
 */

public class No680ValidPalindromeII {

    public static void main(String[] args) {
        No680ValidPalindromeII no680ValidPalindromeII = new No680ValidPalindromeII();
        String[] arr = new String[]{
            "atbbga",
            "aba",
            "abba",
            "abcba",
            "abbca",
            "abbcaca",
            "abcdefabcdefghiihgfedcbafedcba",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            "bbbbbbbbbbbbbbbbbbbcbbbbbbbbbbbbbbbbbbbbbbbbb",
            "dddddddddddddddddddddddddddddddddddddddddddddde",
        };
        no680ValidPalindromeII.validPalindrome(arr);

    }

    public void validPalindrome(String[] arr) {
        for(String str : arr) {
            boolean isValidPalindrome = this.validPalindrome(str);
            System.out.println("str=" + str + ", isValidPalindrome=" + isValidPalindrome);
        }
    }


    /**
     * Runtime: 33 ms
     * Memory Usage: 39 MB
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        boolean validPalindrome = false;
        //System.out.println('a' == 'a');
        //System.out.println(s + ',');
        //validPalindrome = this.isPalindrome(s);
        //System.out.println(s + (validPalindrome ? " is validPalindrome" : " is not validPalindrome"));

        if(s.length() <= 2) {
            return true;
        }

        //if(!validPalindrome) {
        char[] chars = s.toCharArray();
        StringBuilder builder = null;
        StringBuilder opositeBuilder = null;
        int len = chars.length;
        int lowIndex = 0;
        int highIndex = len - 1;
        char lowChar = ' ';
        char highChar = ' ';
        boolean lowTurn = true;
        int loopTimes = 0;
        while(true) {
            //System.out.println("111");
            if(loopTimes == len) {
                //System.out.println("loopTimes == len");
                break;
            }
            lowChar = chars[lowIndex];
            highChar = chars[highIndex];
            if(lowChar != highChar) {

                boolean isPalindrome = isPalindrome(getSubString(chars, lowIndex));
                isPalindrome = isPalindrome || isPalindrome(getSubString(chars, highIndex));
                if(isPalindrome) {
                    validPalindrome = true;
                } else {
                    validPalindrome = false;
                }
                break;
            } else {
                lowIndex++;
                highIndex--;
                validPalindrome = true;
            }

            if(highIndex<=lowIndex) {
                break;
            }
            loopTimes++;

        }

        //}

        return validPalindrome;
    }

    public boolean isPalindrome(String s) {
        boolean isPalindrome = false;
        if(s == null || s.trim().equals("")) {
            isPalindrome = true;
        } else {
            char[] chars = s.toLowerCase().toCharArray();
            int len = chars.length;
            int lowIndex = 0;
            int highIndex = len - 1;
            char lowChar = ' ';
            char highChar = ' ';
            int loopTimes = 0;
            while(true) {
                //System.out.println("222");
                if(loopTimes == len) {
                    break;
                }
                lowChar = chars[lowIndex];
                highChar = chars[highIndex];
                //System.out.println("lowIndex=" + lowIndex + ",lowChar=" + lowChar + ",highIndex=" + highIndex + ", highChar=" + highChar);
                if(lowChar == highChar) {
                    lowIndex++;
                    highIndex--;
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                    break;
                }
                if(highIndex<=lowIndex) {
                    break;
                }
                loopTimes++;
            }
        }
        return isPalindrome;
    }

    public String getSubString(char[] arr, int excludedIndex) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i ++) {
            if(i != excludedIndex) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

}
