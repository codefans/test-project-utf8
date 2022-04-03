package com.codefans.interview.algorithm.offer;

import com.codefans.reusablecode.datastructure.TreeNode;

import java.util.LinkedList;

/**
 * @Author: codefans
 * @Date: 2021-09-20 10:30
 */

public class BinaryTreeSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
//        dfsSerialize(root, sb);
        bfsSerialize(root, sb);
        String str = sb.toString();
        while(str.endsWith(",null")) {
            str = str.substring(0, str.lastIndexOf(",null"));
        }
        return str;
    }

    private void dfsSerialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(",null");
            return;
        }

        if(sb.length() == 0) {
            sb.append(root.val);
        } else {
            sb.append(",").append(root.val);
        }
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);

    }

    private void bfsSerialize(TreeNode root, StringBuilder sb) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.removeFirst();
                if(cur != null) {
                    if(sb.length() == 0) {
                        sb.append(cur.val);
                    } else {
                        sb.append(",").append(cur.val);
                    }
                    TreeNode left = cur.left;
                    queue.addLast(left);
                    TreeNode right = cur.right;
                    queue.addLast(right);
                } else {
                    sb.append(",null");
                }
            }
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) {
            return null;
        }
        TreeNode treeNode = null;
        String[] arr = data.split(",");
        treeNode = createTreeNode(arr);
        return treeNode;
    }

    /**
     * 根据数组创建二叉树
     * @param arr
     * @return
     */
    public static TreeNode createTreeNode(String[] arr) {
        TreeNode treeNode = null;
        if(arr == null || arr.length == 0) {
            return treeNode;
        }
        treeNode = new TreeNode(Integer.parseInt(arr[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(treeNode);

        TreeNode curNode = null;
        TreeNode left = null;
        TreeNode right = null;
        String curItem = null;
        for(int i = 1; i < arr.length; i = i + 2) {
            curNode = queue.removeFirst();
            curItem = arr[i];
            if(curItem != null && !curItem.equals("null")) {
                left = new TreeNode(Integer.parseInt(curItem));
                queue.addLast(left);
                curNode.left = left;
            } else {
                curNode.left = null;
            }
            if(i+1 <= arr.length - 1) {
                curItem = arr[i + 1];
                if (curItem != null && !curItem.equals("null")) {
                    right = new TreeNode(Integer.parseInt(curItem));
                    queue.addLast(right);
                    curNode.right = right;
                } else {
                    curNode.right = null;
                }
            }
        }
        return treeNode;
    }

}
