/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArraySorter
 * Author:   caishengzhi
 * Date:     2021/6/1 16:30
 * Description: 数组排序
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ArrayUtils;

/**
 *
 * 数组排序
 * 冒择路希快归堆
 * @author: codefans
 * @Date: 2021/06/01 16:30
 * @since: 1.0.0
 */
public class ArraySorter {

    /**
     * 冒泡排序
     * 时间复杂度：
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            for(int j = arr.length - 1; j > i; j --) {
                if(arr[j] < arr[j - 1]) {
                    ArrayUtils.swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：
     * @param arr
     */
    public void selectSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            for(int j = i + 1; j < arr.length; j ++) {
                if(arr[j] < arr[i]) {
                    ArrayUtils.swap(arr, j, i);
                }
            }
        }
    }

    /**
     * 选择排序-改进版
     * @param arr
     */
    public void selectSortOpti(int[] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j ++) {
                if(arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                ArrayUtils.swap(arr, minIndex, i);
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度：
     * @param arr
     */
    public void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i ++) {
            int minIndex = i;
            int minVal = arr[i];
            for(int j = i - 1; j >= 0; j --) {
                if(arr[j] > minVal) {
                    arr[j + 1] = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = minVal;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度：
     * @param arr
     */
    public void shellSort(int[] arr) {

        int len = arr.length;
        int step = len;

        while(true) {
            step = step / 2;
            for(int i = 0; i < step; i ++) {
                for(int j = i + step; j < len; j = j + step) {
                    int minIndex = j;
                    int minVal = arr[j];
                    for(int k = j - step; k >= i; k = k - step) {
                        if(arr[k] > minVal) {
                            arr[k + step] = arr[k];
                            minIndex = k;
                        }
                    }
                    arr[minIndex] = minVal;
                }
            }
            if(step == 1) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：
     * @param arr
     */
    public void quickSort(int[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int partition = this.partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    /**
     * 算法描述：
     *    以最后一个元素为基准值，设置变量i，从0开始递增，用来记录当前比基准值小的值的下标，
     * 例如，测试数据1,8,2,5,7,4,6,3可以用来推导这个算法，只要最后一个元素是中间值，就可以用来带入程序进行理解。
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int partitionIndex;
        int basic = arr[right];
        int i = left - 1;
        for(int j = left; j <= right; j ++) {
            if(arr[j] < basic) {
                i++;
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, i+1, right);
        partitionIndex = i + 1;
        return partitionIndex;
    }

    /**
     * 归并排序
     * 时间复杂度：
     * @param arr
     */
    public void mergeSort(int[] arr) {
        this.mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private void mergeSort(int[] arr, int lowIndex, int highIndex, int[] temp) {
        if(lowIndex < highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            mergeSort(arr, lowIndex, mid, temp);
            mergeSort(arr, mid + 1, highIndex, temp);
            mergeArray(arr, lowIndex, mid, highIndex, temp);
        }
    }

    /**
     * 合并两个数组
     * @param arr
     * @param lowIndex
     * @param midIndex
     * @param highIndex
     * @param temp
     */
    private void mergeArray(int[] arr, int lowIndex, int midIndex, int highIndex, int[] temp) {
        int i = lowIndex;
        int m = midIndex;
        int j = midIndex + 1;
        int n = highIndex;
        int k = 0;
        while(i <= m && j <= n) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i <= m) {
            temp[k++] = arr[i++];
        }
        while(j <= n) {
            temp[k++] = arr[j++];
        }
        for(int h = 0; h < k; h ++) {
            arr[lowIndex + h] = temp[h];
        }

    }

    /**
     * 堆排序
     * 时间复杂度：
     * @param arr
     */
    public void heapSort(int[] arr) {

        buildMaxHeapify(arr);

//        for(int i = arr.length - 1; i >= 0; i --) {
//            swap(arr, i, 0);
//            maxHeapify(arr, i, 0);
//        }
    }

    /**
     * 构建最大堆
     * @param arr
     */
    private void buildMaxHeapify(int[] arr) {
        int parentIndex = getParentIndex(arr.length);
        for(int i = parentIndex; i >= 0; i --) {
            maxHeapify(arr, arr.length, i);
        }
    }

    /**
     * 维护最大堆的特性
     * @param arr
     * @param heapSize
     * @param i
     */
    private void maxHeapify(int[] arr, int heapSize, int i) {
        int left = this.getLeftIndex(i);
        int right = this.getRightIndex(i);
        int largest = i;
        if(left < heapSize && arr[left] > arr[i]) {
            largest = left;
        }
        if(right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, heapSize, largest);
        }
    }

    /**
     * 下标i和j位置的两个数相互交换
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 获取父节点下标
     * @param i
     * @return
     */
    private int getParentIndex(int i) {
        return i >> 1;
    }

    /**
     * 获取左节点下标
     * @param i
     * @return
     */
    private int getLeftIndex(int i) {
        return (i << 1) + 1;
    }

    /**
     * 获取右节点下标
     * @param i
     * @return
     */
    private int getRightIndex(int i) {
        return (i << 1) + 2;
    }


}