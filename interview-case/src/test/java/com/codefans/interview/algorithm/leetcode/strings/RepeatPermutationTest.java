/**
 * Copyright (C), 2015-2021, 京东
 * FileName: RepeatPermutationTest
 * Author:   caishengzhi
 * Date:     2021/9/27 10:25
 * Description: 含重复字符的排列测试类
 */
package com.codefans.interview.algorithm.leetcode.strings;


import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

/**
 *
 * 含重复字符的排列测试类
 *
 * @author: codefans
 * @Date: 2021/09/27 10:25
 * @since: 1.0.0
 */
public class RepeatPermutationTest {
    @Test
    public void permutationTest() {

        RepeatPermutation repeatPermutation = new RepeatPermutation();
        String str = "aabc";
        String[] permutions = repeatPermutation.permutation(str);
        PrintUtils.printStrArray(permutions);

    }

}