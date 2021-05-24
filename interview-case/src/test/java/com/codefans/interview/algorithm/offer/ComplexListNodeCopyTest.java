/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ComplexListNodeCopyTest
 * Author:   caishengzhi
 * Date:     2021/5/23 17:44
 * Description: 复杂链表的复制
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.ComplexListNode;
import com.codefans.interview.algorithm.common.ListNodeUtils;
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

    @Test
    public void complexListNodeCopyTest() {

        ComplexListNodeCopy complexListNodeCopy = new ComplexListNodeCopy();
        ComplexListNode originNode = new ComplexListNode(1);
        ComplexListNode resultNode = complexListNodeCopy.copy(originNode);
        ListNodeUtils.printComplexListNode(resultNode);

    }

}