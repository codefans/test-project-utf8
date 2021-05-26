/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ComplexListNodeCopyTest
 * Author:   caishengzhi
 * Date:     2021/5/23 17:44
 * Description: 复杂链表的复制
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.ComplexListNode;
import com.codefans.interview.algorithm.common.ComplexListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 复杂链表的复制
 *
 * @author: codefans
 * @Date: 2021/05/23 17:44
 * @since: 1.0.0
 */
public class ComplexListNodeCopyTest {

    /**
     *
     */
    private ComplexListNodeCopy complexListNodeCopy;

    @Before
    public void before() {
        complexListNodeCopy = new ComplexListNodeCopy();
    }

    @Test
    public void copyNextTest() {


        ComplexListNode originNode = ComplexListNodeFactory.generateThreeNodeList();
        ComplexListNode resultNode = complexListNodeCopy.copyNext(originNode);
        System.out.println("原链表：");
        ListNodeUtils.printComplexListNode(originNode);
        System.out.println("复制的链表：");
        ListNodeUtils.printComplexListNode(resultNode);

    }

    @Test
    public void mergeTest() {

//        ComplexListNode originNode = ComplexListNodeFactory.generateThreeNodeList();
//        ComplexListNode copiedNode = complexListNodeCopy.copyNext(originNode);
//        System.out.println("原链表：");
//        ListNodeUtils.printComplexListNode(originNode);
//        System.out.println("复制的链表：");
//        ListNodeUtils.printComplexListNode(copiedNode);
//        ComplexListNode mergeNode = complexListNodeCopy.merge(originNode, copiedNode);

        ComplexListNode oneNode = ComplexListNodeFactory.generateThreeNodeList();
        ComplexListNode twoNode = ComplexListNodeFactory.generateThreeNodeList2();
        System.out.println("链表1：");
        ListNodeUtils.printComplexListNode(oneNode);
        System.out.println("链表2：");
        ListNodeUtils.printComplexListNode(twoNode);

//        ComplexListNode mergeNode = complexListNodeCopy.merge(oneNode, twoNode);
        ComplexListNode mergeNode = complexListNodeCopy.mergeNotModifyOrigin(oneNode, twoNode);
        System.out.println("穿插合并后的链表为：");
        ListNodeUtils.printComplexListNode(mergeNode);

    }

    @Test
    public void complexListNodeCopyTest() {

        ComplexListNodeCopy complexListNodeCopy = new ComplexListNodeCopy();
        ComplexListNode originNode = ComplexListNodeFactory.generateThreeNodeList();
//        ComplexListNode resultNode = complexListNodeCopy.copy(originNode);
//        ComplexListNode resultNode = complexListNodeCopy.copyMethod2(originNode);
        ComplexListNode resultNode = complexListNodeCopy.copyMethod3(originNode);
        System.out.println("看看originNode是否改变：");
        ListNodeUtils.printComplexListNode(originNode);
        ListNodeUtils.printComplexListNode(resultNode);

//        int index = 1;
//        while(originNode != null && resultNode != null) {
//            if(originNode == resultNode) {
//                originNode = originNode.next;
//                resultNode = resultNode.next;
//                index++;
//                continue;
//            } else {
//                System.out.println("第[" + index + "]节点不一致：originNode.val=" + originNode.val + ", resultNode.val=" + resultNode.val);
//                break;
//            }
//        }

    }

}