package com.codefans.interview.algorithm.offer;

/**
 * @Author: codefans
 * @Date: 2018-04-02 20:46
 */

public class ClockwisePrintMatrix {

    //输出1,2,3,4->8,12,16->15,14,13->9,5->6,7->11,10
    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//            {1}
//        };
//        int[][] matrix = new int[][] {
//                {1,2,3,4}
//        };
        int[][] matrix = new int[][] {
                {1,2,3,4},
                {5,6,7,8}
        };
//        int[][] matrix = new int[][] {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}
//        };
//        int[][] matrix = new int[][] {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
        ClockwisePrintMatrix cpm = new ClockwisePrintMatrix();
        cpm.print(matrix);
    }

    /**
    (0,0)
    (0,1)
    (0,2)
    (0,3)

    (1,3)
    (2,3)
    (3,3)

    (3,2)
    (3,1)
    (3,0)

    (2,0)
    (1,0)

    (1,1)
    (1,2)

    (2,2)

    (2,1)
    **/
    public void print(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while(columns > start * 2 && rows > start * 2) {
            this.printMatrixClockwisely(matrix, columns, rows, start);
            start++;
        }

    }

    public void printMatrixClockwisely(int[][] matrix, int columns, int rows, int start) {
        int endX = rows - 1 - start;
        int endY = columns - 1 - start;
        for(int i = start; i <= endX; i ++) {
            int number = matrix[start][i];
            this.printNumber(number);
        }

        if(start < endY) {
            for(int i = start + 1; i <= endY; i ++) {
                int number = matrix[i][endX];
                this.printNumber(number);
            }
        }

        if(start < endX && start < endY) {
            for(int i = endX - 1; i >= start; --i) {
                int number = matrix[endY][i];
                this.printNumber(number);
            }
        }

        if(start < endX && start < endY - 1) {
            for(int i = endY - 1; i >= start + 1; --i) {
                int number = matrix[i][start];
                this.printNumber(number);
            }
        }



    }

    public void printNumber(int number) {
        System.out.print(number + ", ");
    }

    /**
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrderByKrahets(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length <= 0) {
            return new int[0];
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int left = 0, right = colLen - 1;
        int top = 0, bottom = rowLen - 1;
        int[] res = new int[rowLen * colLen];
        int index = 0;
        while(true) {
            for(int i = left; i <= right; i ++) {
                //System.out.print(matrix[rowIndex][colIndex++] + ",");
                res[index++] = matrix[top][i];
            }
            if(++top > bottom) {
                break;
            }
            for(int i = top; i <= bottom; i ++) {
                //System.out.print(matrix[rowIndex++][colIndex] + ",");
                res[index++] = matrix[i][right];
            }
            if(--right < left) {
                break;
            }
            for(int i = right; i >= left; i --) {
                //System.out.print(matrix[rowIndex][colIndex--] + ",");
                res[index++] = matrix[bottom][i];
            }
            if(--bottom < top) {
                break;
            }
            for(int i = bottom; i >= top; i --) {
                //System.out.print(matrix[rowIndex--][colIndex] + ",");
                res[index++] = matrix[i][left];
            }
            if(++left > right) {
                break;
            }
        }
        return res;
    }

}
