package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.ArrayUtils;
import org.junit.Test;

/**
 *
 * 两数之和测试类
 *
 * @author: codefans
 * @Date: 2021/10/11 17:58
 * @since: 1.0.0
 */
public class No1TwoSumTest {


    /**
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     */
    @Test
    public void twoSumTest() {

        No1TwoSum no1TwoSum = new No1TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] indexArr = no1TwoSum.twoSum(nums, target);
        ArrayUtils.print(indexArr);

        nums = new int[]{3,2,4};
        target = 6;
        indexArr = no1TwoSum.twoSum(nums, target);
        if(indexArr != null) {
            ArrayUtils.print(indexArr);
        } else {
            System.out.println("测试用例2未找到记录");
        }
        nums = new int[]{3,3};
        target = 6;
        indexArr = no1TwoSum.twoSum(nums, target);
        if(indexArr != null) {
            ArrayUtils.print(indexArr);
        } else {
            System.out.println("测试用例3未找到记录");
        }

    }

}
