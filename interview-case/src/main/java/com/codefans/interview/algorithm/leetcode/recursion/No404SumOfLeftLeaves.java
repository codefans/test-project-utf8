package com.codefans.interview.algorithm.leetcode.recursion;

import com.codefans.reusablecode.datastructure.TreeNode;

/**
 * @author: codefans
 * @date: 2019-10-06 21:42
 */
public class No404SumOfLeftLeaves {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Sum of Left Leaves.
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return this.sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeftLeave) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            if(isLeftLeave) {
                return root.val;
            } else {
                return 0;
            }
        }

        int sum = 0;
        int leftVal = sumOfLeftLeaves(root.left, true);
        sum += leftVal;
        int rightVal = sumOfLeftLeaves(root.right, false);
        sum += rightVal;
        return sum;
    }

}
