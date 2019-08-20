package com.codefans.interview.algorithm.leetcode.strings;

/**
 * @author: codefans
 * @date: 2019-08-17 18:24
 *
 * Runtime: 7 ms, faster than 65.47% of Java online submissions for Robot Return to Origin.
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Robot Return to Origin.
 *
 */
public class No657RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int uCount = 0;
        int dCount = 0;
        int lCount = 0;
        int rCount = 0;
        char[] steps = moves.toCharArray();
        for(char c : steps) {
            if(c == 'U') {
                uCount++;
            } else if(c == 'D') {
                dCount++;
            } else if(c == 'L') {
                lCount++;
            } else if(c == 'R') {
                rCount++;
            }
        }
        return (uCount == dCount) && (lCount == rCount);
    }

}
