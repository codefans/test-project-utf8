/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ComplexListNodeCopy
 * Author:   caishengzhi
 * Date:     2021/5/23 17:43
 * Description: 复杂链表的复制
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.ComplexListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 复杂链表的复制
 *
 * @author: codefans
 * @Date: 2021/05/23 17:43
 * @since: 1.0.0
 */
public class ComplexListNodeCopy {

    /**
     * 复杂链表的复制
     * 时间复杂度O(n^2)，最差
     * @param complexListNode
     * @return
     */
    public ComplexListNode copy(ComplexListNode complexListNode) {
        ComplexListNode resultNode;
        resultNode = this.copyBasicLink(complexListNode);
        resultNode = this.copyRandomPointer(resultNode, complexListNode);
        return resultNode;
    }

    public ComplexListNode copyBasicLink(ComplexListNode complexListNode) {
        ComplexListNode resultNode = null;
        ComplexListNode cur = null;
        while(complexListNode != null) {
            if(resultNode == null) {
                resultNode = new ComplexListNode(complexListNode.val);
                cur = resultNode;
            } else {
                cur.next = new ComplexListNode(complexListNode.val);
                cur = cur.next;
            }
            complexListNode = complexListNode.next;
        }
        return resultNode;
    }

    public ComplexListNode copyRandomPointer(ComplexListNode newNode, ComplexListNode originNode) {
        ComplexListNode resultNode = newNode;
        ComplexListNode bakOriginNode = originNode;
        ComplexListNode secondNewNode;
        ComplexListNode secondOriginNode;
        while(originNode != null && newNode != null) {
            ComplexListNode randomNode = originNode.random;
            secondOriginNode = bakOriginNode;
            secondNewNode = resultNode;
            while(secondOriginNode != null && secondNewNode != null) {
                if(randomNode == secondOriginNode) {
                    newNode.random = secondNewNode;
                    break;
                }
                secondOriginNode = secondOriginNode.next;
                secondNewNode = secondNewNode.next;
            }
            originNode = originNode.next;
            newNode = newNode.next;
        }
        return resultNode;
    }

    /**
     * 复杂链表的复制
     * 时间复杂度O(n), 空间复杂度O(n)
     * @param head
     * @return
     */
    public ComplexListNode copyMethod2(ComplexListNode head) {

        /**
         * 复制链表
         */
        ComplexListNode resultNode = null;
        ComplexListNode newNode = null;
        ComplexListNode cur = null;
        ComplexListNode originHead = head;
        Map<ComplexListNode, ComplexListNode> nodeMapping = new HashMap<>();
        while(head != null) {
            if(resultNode == null) {
                newNode = new ComplexListNode(head.val);
                resultNode = newNode;
                cur = resultNode;
            } else {
                newNode = new ComplexListNode(head.val);
                cur.next = newNode;
                cur = cur.next;
            }
            nodeMapping.put(head, newNode);
            head = head.next;
        }

        /**
         * 复制随机指针
         */
        ComplexListNode headPointer = originHead;
        ComplexListNode newPointer = resultNode;
        while(headPointer != null) {
            ComplexListNode random = headPointer.random;
            newPointer.random = nodeMapping.get(random);
            headPointer = headPointer.next;
            newPointer = newPointer.next;
        }

        return resultNode;
    }

    /**
     * 复杂链表的复制
     * 时间复杂度O(n), 空间复杂度O(n)
     * @param head
     * @return
     */
    public ComplexListNode copyMethod3(ComplexListNode head) {

        /**
         * 复制链表
         */
        ComplexListNode resultNode = null;
        ComplexListNode newNode;
        ComplexListNode cur = null;
        ComplexListNode originHead = head;
        while(head != null) {
            if(resultNode == null) {
                newNode = new ComplexListNode(head.val);
                resultNode = newNode;
                cur = resultNode;
            } else {
                newNode = new ComplexListNode(head.val);
                cur.next = newNode;
                cur = cur.next;
            }
            head = head.next;
        }

        /**
         * 链表穿插连接
         */
        ComplexListNode newMergeListNode = originHead;
        ComplexListNode newOriginHead = originHead;
        ComplexListNode newNodeHead = resultNode;
        while(newOriginHead != null) {
            ComplexListNode originNext = newOriginHead.next;
            ComplexListNode newNext = newNodeHead.next;
            newOriginHead.next = newNodeHead;
            if(originNext != null) {
                newNodeHead.next = originNext;
            }
            newOriginHead = originNext;
            newNodeHead = newNext;
        }

        /**
         * 复制随机指针
         */
        ComplexListNode oddPointer = newMergeListNode;
        ComplexListNode evenPointer = oddPointer.next;
        while(oddPointer != null && evenPointer != null) {
            ComplexListNode random = oddPointer.random;
            evenPointer.random = random.next;
            oddPointer = oddPointer.next;
            evenPointer = evenPointer.next;
        }

        /**
         * 拆分链表
         */
        ComplexListNode oddHead = newMergeListNode;
        ComplexListNode evenHead = oddHead.next;
        resultNode = evenHead;
        while(oddHead.next != null && evenHead.next != null) {
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;
            oddHead = oddHead.next.next;
            evenHead = evenHead.next.next;
        }

        return resultNode;
    }


}