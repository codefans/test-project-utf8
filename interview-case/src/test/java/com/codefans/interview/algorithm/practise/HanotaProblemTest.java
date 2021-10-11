package com.codefans.interview.algorithm.practise;


import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 汉诺塔问题测试
 *
 * @author: codefans
 * @Date: 2021/09/24 18:34
 * @since: 1.0.0
 */
public class HanotaProblemTest {

    /**
     * 示例1:
     *  输入：A = [2, 1, 0], B = [], C = []
     *  输出：C = [2, 1, 0]
     *
     * 示例2:
     *  输入：A = [1, 0], B = [], C = []
     *  输出：C = [1, 0]
     *
     */
    @Test
    public void hanotaTest() {

        List<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        HanotaProblem hanotaProblem = new HanotaProblem();
        hanotaProblem.hanota(A, B, C);
        PrintUtils.printIntList(A);
        PrintUtils.printIntList(B);
        PrintUtils.printIntList(C);

    }
}