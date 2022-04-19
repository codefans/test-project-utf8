package com.codefans.interview.algorithm.leetcode.arrays;

import com.codefans.reusablecode.util.ArrayUtils;
import org.junit.Test;

/**
 * 区间加法
 * @Author: codefans
 * @Date: 2022-03-11 7:54
 */

public class No370RangeAdditionTest {


    @Test
    public void incrementTest() {

        int[] arr = new int[5];
        System.out.println("排序之前: ");
        ArrayUtils.print(arr);
        No370RangeAddition no370RangeAddition = new No370RangeAddition(arr);
        no370RangeAddition.increment(1, 3, 2);
        int[] newArr = no370RangeAddition.result();
        System.out.println("从下标1到3分别加2之后：");
        ArrayUtils.print(newArr);

        no370RangeAddition.increment(3, 4, 2);
        newArr = no370RangeAddition.result();
        System.out.println("从下标3到4分别加2之后：");
        ArrayUtils.print(newArr);


    }

}
