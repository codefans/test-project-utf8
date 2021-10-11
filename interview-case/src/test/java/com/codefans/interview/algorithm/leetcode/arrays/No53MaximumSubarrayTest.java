package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.FileUtils;
import org.junit.Test;

/**
 *
 * 最大子序和测试类
 *
 * @author: codefans
 * @Date: 2021/10/11 18:42
 * @since: 1.0.0
 */
public class No53MaximumSubarrayTest {

    /**
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     *
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     *
     * 示例 3：
     * 输入：nums = [0]
     * 输出：0
     *
     * 示例 4：
     * 输入：nums = [-1]
     * 输出：-1
     *
     * 示例 5：
     * 输入：nums = [-100000]
     * 输出：-100000
     *
     */
    @Test
    public void maxSubArrayTest() {

        No53MaximumSubarray no53MaximumSubarray = new No53MaximumSubarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxVal = no53MaximumSubarray.maxSubArray(nums);
        System.out.println("maxVal=" + maxVal);

        nums = new int[]{1};
        maxVal = no53MaximumSubarray.maxSubArray(nums);
        System.out.println("maxVal=" + maxVal);

        nums = new int[]{0};
        maxVal = no53MaximumSubarray.maxSubArray(nums);
        System.out.println("maxVal=" + maxVal);

        nums = new int[]{-1};
        maxVal = no53MaximumSubarray.maxSubArray(nums);
        System.out.println("maxVal=" + maxVal);

        nums = new int[]{-100000};
        maxVal = no53MaximumSubarray.maxSubArray(nums);
        System.out.println("maxVal=" + maxVal);

        String str = FileUtils.fileToStr(No53MaximumSubarray.class.getResourceAsStream("maximum-sub-array.txt"));
        String[] arr = str.split(",");
        System.out.println("arr.length=" + arr.length);

        nums = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        maxVal = no53MaximumSubarray.maxSubArray2(nums);
        System.out.println("maxVal=" + maxVal);

    }
}