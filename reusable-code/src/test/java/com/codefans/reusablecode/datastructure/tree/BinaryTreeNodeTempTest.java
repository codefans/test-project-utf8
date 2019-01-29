package com.codefans.reusablecode.datastructure.tree;

import com.codefans.reusablecode.common.BinaryTreeFactory;
import com.codefans.reusablecode.common.TreeFactory;
import com.codefans.reusablecode.datastructure.binarytree.BinaryTreeNode;
import org.junit.Before;

public class BinaryTreeNodeTempTest {

    BinaryTreeNode binaryTreeNode = null;

    @Before
    public void before() {
        TreeFactory<BinaryTreeNode> treeFactory = new BinaryTreeFactory();
        this.binaryTreeNode = treeFactory.create("binary");
    }



}
