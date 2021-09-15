/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BinaryTreeSubStructure
 * Author:   caishengzhi
 * Date:     2021/9/15 10:50
 * Description: 判断是否是二叉树的子结构
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.TreeNode;
import lombok.val;

import java.util.Stack;

/**
 *
 * 判断是否是二叉树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *           3
 *          / \
 *         4   5
 *        / \
 *       1   2
 * 给定的树 B：
 *
 *      4
 *     /
 *    1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: codefans
 * @Date: 2021/09/15 10:50
 * @since: 1.0.0
 */
public class BinaryTreeSubStructure {

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        boolean isSubStructure = false;
        if(b == null) {
            return isSubStructure;
        }
        isSubStructure = findNode(a, b);
        return isSubStructure;
    }

    /**
     * 从a中找到值和b的根节点一样的节点
     * @param a
     * @param b
     * @return
     */
    public boolean findNode(TreeNode a, TreeNode b) {
        boolean isFound = false;
        if(a == null || b == null) {
            return isFound;
        }
        if(a.val == b.val) {
            boolean isTheSame = this.isTheSame(a, b);
            if(isTheSame) {
                isFound = true;
            }
        } else {
            boolean leftFound = findNode(a.left, b);
            boolean rightFound = findNode(a.right, b);
            isFound = leftFound || rightFound;
        }
        return isFound;
    }

    /**
     * 判断两棵树是否相同
     * @param a
     * @param b
     */
    public boolean isTheSame(TreeNode a, TreeNode b) {
        boolean isTheSame = false;
        if((a == null && b != null) || (a != null && b == null)) {
            return isTheSame;
        }
        Stack<TreeNode> aNodeStack = new Stack<>();
        Stack<TreeNode> bNodeStack = new Stack<>();
        aNodeStack.push(a);
        bNodeStack.push(b);

        boolean sameRoot = false;
        boolean sameLeft = false;
        boolean sameRight = false;
        while(!aNodeStack.isEmpty() && !bNodeStack.isEmpty()) {
            TreeNode aCurr = aNodeStack.pop();
            TreeNode bCurr = bNodeStack.pop();
            if(aCurr.val != bCurr.val) {
                sameRoot = false;
                break;
            } else {
                sameRoot = true;
            }

            TreeNode aLeft = aCurr.left;
            TreeNode aRight = aCurr.right;
            TreeNode bLeft = bCurr.left;
            TreeNode bRight = bCurr.right;
            if(aLeft != null && bLeft != null && aLeft.val == bLeft.val) {
                aNodeStack.push(aLeft);
                bNodeStack.push(bLeft);
                sameLeft = true;
            } else {
                sameLeft = false;
            }
            if(aRight != null && bRight != null && aRight.val == bRight.val) {
                aNodeStack.push(aRight);
                bNodeStack.push(bRight);
                sameRight = true;
            } else {
                sameRight = false;
            }

            if((sameRoot && sameLeft) || (sameRoot && sameRight)) {
                isTheSame = true;
            } else {
                isTheSame = false;
                break;
            }
        }
//        isTheSame = isTheSame && (aNodeStack.size() == bNodeStack.size());
        return isTheSame;
    }

}