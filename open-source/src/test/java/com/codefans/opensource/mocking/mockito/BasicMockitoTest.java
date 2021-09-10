/**
 * Copyright (C), 2015-2020, 京东
 * FileName: BasicMockitoTest
 * Author:   codefans
 * Date:     2020/2/23 1:43
 * Description: Mockito测试类
 */
package com.codefans.opensource.mocking.mockito;


import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;


/**
 *
 * Mockito测试类
 *
 * @author: codefans
 * @Date: 2020/02/23 01:43
 * @since: 1.0.0
 */
public class BasicMockitoTest {

    @Test
    public void letsVerifySomeBehaviour() {

        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();
//        mockedList.size();

        //verification
        //验证是否进行add操作、且添加的元素是one
        verify(mockedList).add("one");
//        verify(mockedList).add("two");
        //验证改list是否调用了clear方法
        verify(mockedList).clear();
//        verify(mockedList).size();

    }

    @Test
    public void howAboutSomeStubbing() {

        //You can mock concrete classes, not just interfaces
        //你可以模拟具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        //如果后面发生get(0)操作，直接返回first
        when(mockedList.get(0)).thenReturn("first");
        //如果后面发生get(1)操作，直接抛异常
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
//        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList).get(0);

    }

    @Test
    public void argumentMatchersTest() {

        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains(argThat(isValid()))).thenReturn(true);

        //following prints "element"
        System.out.println(mockedList.get(999));

        System.out.println(mockedList.contains("element"));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
//        verify(mockedList).add(argThat(someString -> someString.length() > 5));
    }

    public ArgumentMatcher<String> isValid() {
        return new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String s) {
                return "element".equals(s);
            }
        };
    }

}