package com.codefans.interview.algorithm.leetcode.recursion;

import com.codefans.reusablecode.datastructure.TreeNode;

/**
 * @author: codefans
 * @date: 2019-10-04 11:50
 */
public class No938RangeSumOfBST {

    /**
     * Runtime: 1 ms, faster than 51.60% of Java online submissions for Range Sum of BST.
     * Memory Usage: 44.2 MB, less than 98.84% of Java online submissions for Range Sum of BST.
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.val >= L && root.val <= R) {
            sum += root.val;
        }

        sum += rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

        return sum;

    }

}
