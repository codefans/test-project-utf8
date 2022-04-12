package com.codefans.basicjava.algorithm.sort;

import com.codefans.basicjava.util.CommonUtils;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Author: codefans
 * @Date: 2022-02-09 18:38
 */

public class QuickSortTest {

    @Test
    public void quickSortLongInTest() throws FileNotFoundException {

        String filePath = "G:\\GitHub\\test-project-utf8\\basic-java\\src\\test\\java\\com\\codefans\\basicjava\\algorithm\\sort\\nums.txt";
        InputStream is = new FileInputStream(new File(filePath));
        Scanner sc = new Scanner(is);
        String numLine = "";
        while(sc.hasNextLine()) {
            numLine = sc.nextLine();
        }
        String[] strArr = numLine.split(",");
        int[] arr = toIntArr(strArr);
        QuickSort quickSort = new QuickSort();
        int[] newArr = quickSort.quickSort(arr);
        for(int i = 0; i < newArr.length; i ++) {
            System.out.println(newArr[i]);
        }
    }

    private int[] toIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }

    @Test
    public void quickSort2Test() {

        int[][] dataArr = new int[][]{
            {13,19,9,5,12,8,7,4,21,2,6,11}
        };
        QuickSort quickSort = new QuickSort();
        for(int[] arr : dataArr) {
            int[] newArr = quickSort.quickSort2(arr);
            CommonUtils.printInLine(newArr);
        }
    }

}
