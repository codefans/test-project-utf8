package com.codefans.interview.algorithm.offer;

import com.codefans.interview.algorithm.common.TreeNode;

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
//        serialize(root, sb);
        bfsSerialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(",null");
            return;
        }
        if(sb.length() == 0) {
            sb.append(root.val);
        } else {
            sb.append(",").append(root.val);
        }
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    private void bfsSerialize(TreeNode root, StringBuilder sb) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder childStr = new StringBuilder();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.pop();
                if(sb.length() == 0) {
                    sb.append(cur.val);
                } else {
                    sb.append(",").append(cur.val);
                }

                TreeNode left = cur.left;
                if(left == null) {
                    childStr.append(",null");
                } else {
                    queue.offer(left);
                }
                TreeNode right = cur.right;
                if(right == null) {
                    childStr.append(",null");
                } else {
                    queue.offer(right);
                }

            }
            sb.append(childStr.toString());
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode treeNode = null;

        return treeNode;
    }

}
