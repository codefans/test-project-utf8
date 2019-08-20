package com.codefans.interview.algorithm.leetcode.strings;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-08-17 17:34
 *

 *
 */
public class No709ToLowerCaseTest {

    private String[] arr;

    @Before
    public void before() {
        arr = new String[]{
            "helloWorld",
            "Apple",
            "Banana",
            "Couple",
            "Dulplate",
            "Enjoy",
            "Money123",
            "@#Nothing890",
            "=-.,Where7654",
        };

    }


    @Test
    public void toLowerCaseTest() {

        No709ToLowerCase toLowerCase = new No709ToLowerCase();

        for(String str : arr) {
            System.out.println(str + ", lowerCase:" + toLowerCase.toLowerCase(str));
        }

    }


}
