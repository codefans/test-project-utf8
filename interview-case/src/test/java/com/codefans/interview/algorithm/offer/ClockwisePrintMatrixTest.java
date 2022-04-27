package com.codefans.interview.algorithm.offer;

import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2022-04-27 16:34
 */

public class ClockwisePrintMatrixTest {

    @Test
    public void printTest() {

        int[][] arr = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
//            {1,2,3,4},
//            {5,6,7,8},
//            {9,10,11,12}
        };
        ClockwisePrintMatrix printMatrix = new ClockwisePrintMatrix();
//        printMatrix.print(arr);
//        int[] resArr = printMatrix.spiralOrderByKrahets(arr);
        int[] resArr = printMatrix.spiralOrder(arr);
        PrintUtils.printIntArray(resArr);
    }
}
