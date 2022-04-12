package com.codefans.basicjava.algorithm.sort;

import com.codefans.basicjava.util.CommonUtils;

import java.util.Arrays;

/**
 * @author: codefans
 * @date: 2017-11-07 21:36
 *
 * 它的基本思想是：
 *    通过一趟排序将要排序的数据分割成独立的两部分，
 *    其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 **/
public class QuickSort extends SortBase {

    /**
     * 设置两个变量i,j排序开始的时候: i=0，j=N-1;
     * 以第一个数组元素作为关键数据, 赋值给key, 即key=A[0];
     * 设置一个flag遍历, 控制i, j的移动. flag=false时移动j;flag=true时移动i;
     * 先从j开始向前搜索, 即由后开始向前搜索(j--), 找到第一个小于key的值A[j], 将A[j]和A[i]互换, i++, flag=!flag;
     * 然后从i开始向后搜索, 即由前开始向后搜索(i++), 找到第一个大于key的A[i], 将A[i]和A[j]互换, j--, flag=!flag;
     * 重复第3,4步, 直到i=j;
     *
     * @param arr
     * @param lowIndex
     * @param highIndex
     */
    public void sortAsc(int[] arr, int lowIndex, int highIndex) {

        int l = lowIndex;
        int h = highIndex;
        int temp = arr[lowIndex];

        if(l < h) {

            boolean flag = false;
            while(l < h) {

                if(!flag) {
                    if (arr[h] < temp) {
                        this.swap(arr, l, h);
                        l++;
                        flag = !flag;
                    } else {
                        h--;
                    }
                }

                if(flag) {
                    if (arr[l] > temp) {
                        this.swap(arr, l, h);
                        h--;
                        flag = !flag;
                    } else {
                        l++;
                    }

                }

            }

            if(l > lowIndex) {
                sortAsc(arr, lowIndex, l - 1);
            }

            if(h < highIndex) {
                sortAsc(arr, l + 1, highIndex);
            }


        }

    }

    public void sortDesc(int[] arr, int lowIndex, int highIndex) {
        int l = lowIndex;
        int h = highIndex;
        int temp = arr[lowIndex];

        if (l < h) {

            boolean flag = false;
            while (l < h) {

                if (!flag) {
                    if (arr[h] > temp) {
                        this.swap(arr, l, h);
                        l++;
                        flag = !flag;
                    } else {
                        h--;
                    }
                }

                if (flag) {
                    if (arr[l] < temp) {
                        this.swap(arr, l, h);
                        h--;
                        flag = !flag;
                    } else {
                        l++;
                    }

                }

            }

            if (l > lowIndex) {
                sortDesc(arr, lowIndex, l - 1);
            }

            if (h < highIndex) {
                sortDesc(arr, h + 1, highIndex);
            }
        }
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        int[] newArr = Arrays.copyOf(nums, nums.length);
        quickSort(newArr, 0, newArr.length - 1);
        return newArr;
    }

    private void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int partitionIndex = partition(nums, low, high);
            quickSort(nums, low, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, high);
        }
    }

    /**
     * 该方法的作用是：
     *    將小于基准值的挪到左边,大于基准值的挪到右边,然后返回基准值所在的下标.
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {
        int partitionIndex = -1;
        int baseIndex = low;
        int index = baseIndex + 1;
        for(int i = index; i <= high; i ++) {
            if(nums[i] < nums[baseIndex]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, baseIndex, index - 1);
        partitionIndex = index - 1;
        return partitionIndex;
    }

    /**
     * 算法导论写法-快速排序
     * @param nums
     * @return
     */
    public int[] quickSort2(int[] nums) {
        int[] newArr = Arrays.copyOf(nums, nums.length);
        quickSort2(newArr, 0, newArr.length - 1);
        return newArr;
    }

    private void quickSort2(int[] nums, int low, int high) {
        if(low < high) {
            int partitionIndex = partition2(nums, low, high);
            quickSort2(nums, low, partitionIndex - 1);
            quickSort2(nums, partitionIndex + 1, high);
        }
    }

    /**
     * 算法导论写法
     * 7.1章节
     *
     * 例如：13,19,9,5,12,8,7,4,21,2,6,11
     * 执行完一次下面的方法后，输出如下：
     * 9,19,13,5,12,8,7,4,21,2,6,11
     * 9,5,13,19,12,8,7,4,21,2,6,11
     * 9,5,8,19,12,13,7,4,21,2,6,11
     * 9,5,8,7,12,13,19,4,21,2,6,11
     * 9,5,8,7,4,13,19,12,21,2,6,11
     * 9,5,8,7,4,2,19,12,21,13,6,11
     * 9,5,8,7,4,2,6,12,21,13,19,11
     * 9,5,8,7,4,2,6,11,21,13,19,12
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition2(int[] nums, int low, int high) {
        int index = low - 1;
        for(int i = low; i <= high - 1; i ++) {
            /**
             * 小的交换到前面，是递增排序；
             * 要想实现递减排序，则改成nums[i]>=nums[high]即可。
             */
            if(nums[i] < nums[high]) {
                index++;
                swap(nums, i, index);
                CommonUtils.printInLine(nums);
            }
        }
        index++;
        swap(nums, index, high);
        CommonUtils.printInLine(nums);
        return index;
    }



}
