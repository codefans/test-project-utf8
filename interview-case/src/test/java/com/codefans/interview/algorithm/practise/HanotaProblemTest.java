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

    @Test
    public void hanotaTest() {

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        HanotaProblem hanotaProblem = new HanotaProblem();
        hanotaProblem.hanota(A, B, C);
        PrintUtils.printIntList(A);
        PrintUtils.printIntList(B);
        PrintUtils.printIntList(C);

    }
}