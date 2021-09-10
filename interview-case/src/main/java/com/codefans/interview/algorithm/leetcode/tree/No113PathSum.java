/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No113PathSum
 * Author:   caishengzhi
 * Date:     2021/9/9 11:36
 * Description: 二叉树中和位某一个值的路径
 */
package com.codefans.interview.algorithm.leetcode.tree;

import com.codefans.interview.algorithm.common.TreeNode;

import java.util.*;

/**
 *
 * 二叉树中和位某一个值的路径
 *
 * @author: codefans
 * @Date: 2021/09/09 11:36
 * @since: 1.0.0
 */
public class No113PathSum {

    /**
     * 深度优先-计算路径
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSumDfs(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        pathSumDfs(root, currentSum, targetSum, stack, list);
        return list;
    }

    /**
     * 功能：计算一条路径的和
     * 终止条件：root==null
     * 递推公式：sum(n) = currVal + sum(n-1)
     *
     * @param root
     * @param list
     * @return
     */
    private void pathSumDfs(TreeNode root, int currentSum, int targetSum, Stack<Integer> stack, List<List<Integer>> list) {
        if(root == null) {
            return;
        }
        int curVal = root.val;
        currentSum += curVal;
        stack.push(curVal);
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean isLeaf = (left == null) && (right == null);
        if(currentSum == targetSum && isLeaf) {
            Iterator<Integer> iter = stack.iterator();
            List<Integer> subList = new ArrayList<>(stack.size());
            while(iter.hasNext()) {
                subList.add(iter.next());
            }
            list.add(subList);
        }
        if(left != null) {
            pathSumDfs(left, currentSum, targetSum, stack, list);
        }
        if(right != null) {
            pathSumDfs(right, currentSum, targetSum, stack, list);
        }
        stack.pop();
    }

    /**
     * 广度优先-计算路径
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSumBfs(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        pathSumBfs(root, targetSum, map, list);
        return list;
    }

    private void pathSumBfs(TreeNode root, int targetSum, Map<TreeNode, TreeNode> map, List<List<Integer>> list) {
        if(root == null) {
            return;
        }

        LinkedList<TreeNode> queueNode = new LinkedList<>();
        LinkedList<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);
        while(!queueNode.isEmpty()) {
            TreeNode curNode = queueNode.poll();
            int curSum = queueSum.poll() + curNode.val;
            TreeNode left = curNode.left;
            TreeNode right = curNode.right;
            if(left == null && right == null) {
                if(curSum == targetSum) {
                    List<Integer> pathList = getPath(curNode, map);
                    list.add(pathList);
                }
            } else {
                if(left != null) {
                    queueNode.offer(left);
                    map.put(left, curNode);
                    queueSum.offer(curSum);
                }
                if(right != null) {
                    queueNode.offer(right);
                    map.put(right, curNode);
                    queueSum.offer(curSum);
                }
            }
        }


    }

    private List<Integer> getPath(TreeNode root, Map<TreeNode, TreeNode> map) {
        List<Integer> tmpList = new ArrayList<>();
        while(root != null) {
            tmpList.add(root.val);
            root = map.get(root);
        }
        Collections.reverse(tmpList);
        return tmpList;
    }


    public void print(List<List<Integer>> list) {
        for(int i = 0; i < list.size(); i ++) {
            List<Integer> subList = list.get(i);
            for(int j = 0; j < subList.size(); j ++) {
                if(j != 0) {
                    System.out.print(",");
                }
                System.out.print(subList.get(j));
            }
            System.out.println();
        }
    }

}