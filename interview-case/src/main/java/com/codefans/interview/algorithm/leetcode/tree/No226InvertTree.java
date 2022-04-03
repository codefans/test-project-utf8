/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No226InvertTree
 * Author:   codefans
 * Date:     2021/8/24 19:00
 * Description: 二叉树镜像（翻转二叉树）
 */
package com.codefans.interview.algorithm.leetcode.tree;

import com.codefans.reusablecode.datastructure.BinaryTreeNode;

import java.util.LinkedList;

/**
 *
 * 二叉树镜像（翻转二叉树）
 *
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author: codefans
 * @Date: 2021/08/24 19:00
 * @since: 1.0.0
 */
public class No226InvertTree {

    /**
     * 翻转二叉树
     * 算法描述：
     *    从队列中取出一个节点，然后把这个节点的左右节点放入队列中，并将该节点的左右节点互换。
     *
     * @param node
     * @return
     */
    public BinaryTreeNode invertTree(BinaryTreeNode node) {
        BinaryTreeNode binaryTreeNode = node;
        if(node != null) {
            LinkedList<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()) {
                BinaryTreeNode firstNode = queue.removeFirst();
                if(firstNode != null) {
                    BinaryTreeNode left = firstNode.getLeft();
                    if(left != null) {
                        queue.addLast(left);
                    }
                    BinaryTreeNode right = firstNode.getRight();
                    if(right != null) {
                        queue.addLast(right);
                    }
                    firstNode.setLeft(right);
                    firstNode.setRight(left);
                }

            }
        }
        return binaryTreeNode;
    }

    /**
     * 二叉树的镜像
     * @param node
     * @return
     */
    public BinaryTreeNode mirrorTree(BinaryTreeNode node) {
        return this.invertTree(node);
    }

}
