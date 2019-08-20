package com.codefans.interview.algorithm.leetcode.strings;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-08-17 18:25
 */
public class No657RobotReturnToOriginTest {

    private String[] movesArr;
    private No657RobotReturnToOrigin robotReturnToOrigin;

    @Before
    public void before() {

        movesArr = new String[]{
            "UD",
            "LR",
            "DUU",
            "LLLRR",
            "LlmnR98",
            "LmDnR3dfU",
            "LLRRUD",
        };
        robotReturnToOrigin = new No657RobotReturnToOrigin();

    }

    @Test
    public void robotReturnToOriginTest() {

        for(String moves : movesArr) {
            System.out.println(moves + ", isReturnToOrigin=" + robotReturnToOrigin.judgeCircle(moves));
        }
    }

}
