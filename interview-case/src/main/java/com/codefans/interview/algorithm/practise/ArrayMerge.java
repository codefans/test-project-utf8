/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArrayMerge
 * Author:   caishengzhi
 * Date:     2021/6/2 16:55
 * Description: 数组合并
 */
package com.codefans.interview.algorithm.practise;


import java.util.Arrays;

/**
 *
 * 数组合并
 *
 * @author: codefans
 * @Date: 2021/06/02 16:55
 * @since: 1.0.0
 */
public class ArrayMerge {

    /**
     * 两个有序数组的合并
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] mergeSortedArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null) {
            return arr1 == null ? arr2 : arr1;
        }
        int i = 0, j = 0, index = 0;
        int len1 = arr1.length, len2 = arr2.length;
        int[] resultArr = new int[len1 + len2];
        while(i < len1 && j < len2) {
            if(arr1[i] < arr2[j]) {
                resultArr[index++] = arr1[i++];
            } else {
                resultArr[index++] = arr2[j++];
            }
        }
        while(i < len1) {
            resultArr[index++] = arr1[i++];
        }
        while(j < len2) {
            resultArr[index++] = arr2[j++];
        }
        return resultArr;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
     * 方法三：逆向双指针-最优解
     * 方法二中，之所以要使用临时变量，是因为如果直接合并到数组nums1中，nums1中的元素可能会在取出之前被覆盖。
     * 那么如何直接避免覆盖nums1中的元素呢？观察可知，nums1的后半部分是空的，可以直接覆盖而不会影响结果。
     * 因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进nums1的最后面。
     * 严格来说，在此遍历过程中的任意一个时刻，nums1数组中有 m-p1-1个元素被放入nums1的后半部，
     * nums2数组中有n-p2-1个元素被放入nums1的后半部，而在指针p1的后面，nums1数组有 m+n-p1−1 个位置。由于
     *     m+n-p1-1 >= m-p1+n-p2-1
     * 等价于：
     *     p2>=-1
     * 永远成立，因此p1后面的位置永远足够容纳被插入的元素，不会产生p1的元素被覆盖的情况。
     *
     * 时间复杂度：O(m+n)
     *     指针移动单调递减，最多移动 m+n 次，因此时间复杂度为 O(m+n)。
     * 空间复杂度：O(1)
     *     直接对数组nums1原地修改，不需要额外空间。
     *
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
     * 方法二：双指针
     * 方法一没有利用数组nums1与nums2已经被排序的性质。为了利用这一性质，我们可以使用双指针方法。
     * 这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。
     *
     * 时间复杂度：O(m+n)
     * 指针移动单调递增，最多移动 m+n 次，因此时间复杂度为O(m+n)。
     *
     * 空间复杂度：O(m+n)
     * 需要建立长度为 m+n 的中间数组sorted。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSortedArray4(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
     * 方法一：直接合并后排序
     * 算法
     * 最直观的方法是先将数组nums2放进数组nums1的尾部，然后直接对整个数组进行排序。
     *
     * 时间复杂度：O((m+n)log(m+n))。
     * 排序序列长度为m+n，套用快速排序的时间复杂度即可，平均情况为O((m+n)log(m+n))。
     *
     * 空间复杂度：O(log(m+n))。
     * 排序序列长度为m+n，套用快速排序的空间复杂度即可，平均情况为O(log(m+n))。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSortedArray5(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 两个有序数组的合并
     * https://leetcode-cn.com/problems/merge-sorted-array/
     *
     * 示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     * 示例 2：
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     *
     * 示例 3：
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     *
     * 没考虑到的测试用例：
     * 输入：nums1 = [0,0,0,0,0], m = 0, nums2 = [1,2,3,4,5], n = 5
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了17.56%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了12.87%的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public void mergeSortedArray6(int[] nums1, int m, int[] nums2, int n) {
        int totalLen = nums1.length;
        if(totalLen == n && m == 0) {
            for(int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int index1 = 0;
        int index2 = 0;
        while(index1 < totalLen && index2 < n) {
            if(nums1[index1] < nums2[index2]) {
                index1++;
                if(index1 == m) {
                    nums1[index1] = nums2[index2];
                    index2++;
                    m++;
                }
            } else {
                int low = index1 == 0 ? index1 + 1 : index1;
                for(int i = totalLen - 1; i >= low; i --) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[index1] = nums2[index2];
                index1++;
                index2++;
                m++;
            }
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSortedArray2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/88-by-ikaruga/
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSortedArray3(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        m--;
        n--;
        while (n >= 0) {
            while (m >= 0 && nums1[m] > nums2[n]) {
                swap(nums1, i--, m--);
            }
            swap(nums1, i--, nums2, n--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void swap(int[] arr, int i, int[] arr2, int j) {
        int tmp = arr[i];
        arr[i] = arr2[j];
        arr2[j] = tmp;
    }

}