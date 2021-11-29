/**
 * Copyright (C), 2015-2021, 京东
 * FileName: NoRepeatPermutationTest
 * Author:   caishengzhi
 * Date:     2021/9/27 10:20
 * Description: 无重复字符的排列测试类
 */
package com.codefans.interview.algorithm.leetcode.strings;


import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

/**
 *
 * 无重复字符的排列测试类
 *
 * @author: codefans
 * @Date: 2021/09/27 10:20
 * @since: 1.0.0
 */
public class NoRepeatPermutationTest {

    @Test
    public void permutationTest() {

        NoRepeatPermutation noRepeatPermutation = new NoRepeatPermutation();
        String str = "abc";
        String[] permutions = noRepeatPermutation.permutation(str);
        PrintUtils.printStrArray(permutions);

    }

}