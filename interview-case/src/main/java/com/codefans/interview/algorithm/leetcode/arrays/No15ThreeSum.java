package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No15-三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * @author: codefans
 * @Date: 2021/10/22 10:42
 * @since: 1.0.0
 */
public class No15ThreeSum {

    /**
     * 示例 1：
     *     输入：nums = [-1,0,1,2,-1,-4]
     *     输出：[[-1,-1,2],[-1,0,1]]
     *
     * 示例 2：
     *     输入：nums = []
     *     输出：[]
     *
     * 示例 3：
     *     输入：nums = [0]
     *     输出：[]
     *
     * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * 解题方案
     * 思路
     * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum判断是否满足为 0，满足则添加进结果集
     * 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R−−
     * 时间复杂度：O(n^2)，n为数组长度
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) {
            return resultList;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    resultList.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return resultList;
    }

    /**
     * {14,-11,-2,-3,4,-3,-3,-8,-15,11,11,-6,-14,-13,5,-10,-13,0,-12,-8,14,-12,-10,2,-4,9,13,10,2,7,-2,-7,4,11,5,-7,-15,10,-7,-14,6,11,-5,7,6,8,5,8,-7,8,-15,14,11,13,1,-15,7,0,10,-14,14,-15,-14,3,4,6,4,4,-7,12,5,14,0,8,7,13,1,-11,-2,9,12,-1,8,0,-11,-5,0,11,2,-13,4,1,-12,5,-10,-1,-12,9,-12,-11,-2,9,-12,5,-6,2,4,10,6,-13,4,3,-7,-11,11,-3,-9,-4,-15,8,-9,-4,-13,-14,8,14}
     * 这个用例会超出时间限制。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int len = nums.length;
        if(len < 3) {
            return resultList;
        }
        for(int i = 0; i < len; i ++) {
            for(int j = 0; j < len; j ++) {
                for(int k = 0; k < len; k ++) {
                    if(i != j && j != k && i != k && nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if(!contain(resultList, list)) {
                            resultList.add(list);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    private boolean contain(List<List<Integer>> dataList, List<Integer> list) {
        boolean isContain = false;
        for(List<Integer> item : dataList) {
            if(equals(item, list)) {
                isContain = true;
                break;
            } else {
                isContain = false;
            }
        }
        return isContain;
    }

    private boolean equals(List<Integer> data, List<Integer> item) {
        boolean isEquals = false;
        if(data == null && item != null) {
            return isEquals;
        }
        if(data != null && item == null) {
            return isEquals;
        }
        int len = data.size();
        int len2 = item.size();
        if(len != len2) {
            return isEquals;
        }
        for(int i = 0, j = 0; i < len && j < len2; i ++, j ++) {
            if(data.contains(item.get(j)) && item.contains(data.get(i))) {
                isEquals = true;
            } else {
                isEquals = false;
                break;
            }
        }
        return isEquals;
    }

}
