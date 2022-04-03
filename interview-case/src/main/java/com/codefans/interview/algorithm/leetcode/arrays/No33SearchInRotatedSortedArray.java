package com.codefans.interview.algorithm.leetcode.arrays;


/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * @author: codefans
 * @Date: 2021/10/29 10:51
 * @since: 1.0.0
 */
public class No33SearchInRotatedSortedArray {

    /**
     *
     * 示例 1：
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * 示例 2：
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     *
     * 示例 3：
     * 输入：nums = [1], target = 0
     * 输出：-1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int index = -1;
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                index = mid;
                break;
            }
            /**
             * 通过比较，判断哪部分是有序的；
             * 如果nums[0]<=nums[mid], 说明前半部分有序；
             * 否则，后半部分有序；
             */
            if(nums[0] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return index;
    }

}
