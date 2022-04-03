/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ComplexListNodeCopy
 * Author:   caishengzhi
 * Date:     2021/5/23 17:43
 * Description: 复杂链表的复制
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.reusablecode.datastructure.ComplexListNode;
import com.codefans.reusablecode.datastructure.ListNodeUtils;

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

        ComplexListNode originHead = head;

        /**
         * 复制链表
         */
        ComplexListNode resultNode = this.copyNext(head);

        System.out.println("老链表：");
        ListNodeUtils.printComplexListNode(originHead);
        System.out.println("新链表：");
        ListNodeUtils.printComplexListNode(resultNode);

        /**
         * 链表穿插连接
         */
//        ComplexListNode newMergeListNode = this.merge(originHead, resultNode);
        ComplexListNode newMergeListNode = this.mergeNotModifyOrigin(originHead, resultNode);
        System.out.println("originHead在merge之后：");
        ListNodeUtils.printComplexListNode(originHead);

//        ComplexListNode newOriginHead = originHead;
//        ComplexListNode newNodeHead = resultNode;
//        while(newOriginHead != null) {
//            ComplexListNode originNext = newOriginHead.next;
//            ComplexListNode newNext = newNodeHead.next;
//            newOriginHead.next = newNodeHead;
//            if(originNext != null) {
//                newNodeHead.next = originNext;
//            }
//            newOriginHead = originNext;
//            newNodeHead = newNext;
//        }


        System.out.println("链表合并：");
        ListNodeUtils.printComplexListNode(newMergeListNode);

        /**
         * 复制随机指针
         */
//        ComplexListNode oddPointer = newMergeListNode;
//        ComplexListNode evenPointer = oddPointer.next;
//        while(oddPointer != null && evenPointer != null) {
//            ComplexListNode random = oddPointer.random;
//            if(random != null) {
//                evenPointer.random = random.next;
//            }
//            oddPointer = oddPointer.next;
//            evenPointer = evenPointer.next;
//        }
        newMergeListNode = this.copyRandom(newMergeListNode);
        System.out.println("复制随机指针后: ");
        ListNodeUtils.printComplexListNode(newMergeListNode);

        /**
         * 拆分链表
         */
        ComplexListNode oddHead = newMergeListNode;
        ComplexListNode evenHead = oddHead.next;
        resultNode = evenHead;
        while(evenHead != null) {
//            if(oddHead.next != null && oddHead.next.next != null) {
//                oddHead.next = oddHead.next.next;
//                oddHead = oddHead.next;
//            }
            if(evenHead.next != null && evenHead.next.next != null) {
                evenHead.next = evenHead.next.next;
            } else {
                evenHead.next = null;
            }
            evenHead = evenHead.next;
        }

//        System.out.println("拆分后，打印oddHead：");
//        ListNodeUtils.printComplexListNode(oddHead);
        System.out.println("拆分后，打印evenHead：");
        ListNodeUtils.printComplexListNode(evenHead);

        return resultNode;
    }

    /**
     * 复制next指针
     * @param head
     * @return
     */
    public ComplexListNode copyNext(ComplexListNode head) {
        ComplexListNode resultNode = null;
        ComplexListNode newNode;
        ComplexListNode cur = null;
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
        return resultNode;
    }

    /**
     * 穿插合并两个链表
     * 会改变head1
     * @param head1
     * @param head2
     * @return
     */
    public ComplexListNode merge(ComplexListNode head1, ComplexListNode head2) {
        ComplexListNode resultNode = head1;
        ComplexListNode newOriginHead = head1;
        ComplexListNode newNodeHead = head2;
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
        return resultNode;
    }

    /**
     * 穿插合并两个链表
     * 不会修改head1
     * @param head1
     * @param head2
     * @return
     */
    public ComplexListNode mergeNotModifyOrigin(ComplexListNode head1, ComplexListNode head2) {
        ComplexListNode resultNode = null;
        ComplexListNode cur = null;
        ComplexListNode newOriginHead = head1;
        ComplexListNode newNodeHead = head2;
        while(newOriginHead != null) {
            if(resultNode == null) {
                resultNode = new ComplexListNode(newOriginHead.val);
                cur = resultNode;
                cur.random = newOriginHead.random;
            } else {
                ComplexListNode originNext = newOriginHead.next;
                ComplexListNode newNext = newNodeHead.next;
                cur.next = newNodeHead;
                cur.random = newOriginHead.random;

                if(originNext != null) {
                    newNodeHead.next = originNext;
                }
                cur = originNext;
                newOriginHead = originNext;
                newNodeHead = newNext;

            }

        }
        return resultNode;
    }

    /**
     * 复制随机指针
     * @param head
     * @return
     */
    public ComplexListNode copyRandom(ComplexListNode head) {
        ComplexListNode newMergeListNode = head;
        ComplexListNode oddPointer = head;
        ComplexListNode evenPointer = oddPointer.next;
        while(oddPointer != null && evenPointer != null) {
            ComplexListNode random = oddPointer.random;
            if(random != null) {
                evenPointer.random = random;
            }
            if(oddPointer.next != null) {
                oddPointer = oddPointer.next.next;
            }
            if(evenPointer.next != null) {
                evenPointer = evenPointer.next.next;
            }
        }
        return newMergeListNode;
    }
}
