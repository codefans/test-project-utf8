package com.codefans.interview.algorithm;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2022-04-14 17:29
 */

public class BigIntegerAddTest {

    @Test
    public void strAddTest() {

        BigIntegerAdd bia = new BigIntegerAdd();
        String num1 = "000123";
        String num2 = "000321";
        System.out.println(bia.addStrings(num1, num2));

        num1 = "999999999999999999";
        num2 = "100000000000000001";
        System.out.println(bia.addStrings(num1, num2));


    }
}
