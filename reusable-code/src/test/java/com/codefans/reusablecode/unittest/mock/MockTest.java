package com.codefans.reusablecode.unittest.mock;

import com.codefans.reusablecode.unittest.mock.impl.ElementImpl;
import com.codefans.reusablecode.unittest.mock.impl.MockImpl;
import com.codefans.reusablecode.unittest.mock.model.ElementParam;
import com.codefans.reusablecode.unittest.mock.model.ElementResult;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author: codefans
 * @date: 2019-03-01 10:45:38
 *
 * (1)ElementApi elementApi = mock(ElementImpl.class);
 * (2)when(elementApi.queryElement(any(ElementParam.class))).thenReturn(elementResult);
 * 以上两句话的解释:
 *   1.when里面的elementApi必须是通过mock()方法生成的,不能是new出来的
 *   2.第(2)句的意思是:后文如果有调用elementApi.queryElement()的地方,会忽略这个方法,这个方法不会被执行,而是直接返回elementResult了。
 *   3.queryElement参数为什么是any(ElementParam.class)而不是一个具体的ElementParam对象？
 *      因为这里如果是一个具体的ElementParam对象,那么后面调用queryElement方法时,也得传同一个具体的对象,这样比较麻烦。
 *   所以如果是any(ElementParam.class),后面调queryElement方法时,参数只要是一个ElementParam对象就可以,通用且方便。
 *
 */
public class MockTest {

    private MockApi mockApi;
    ElementParam elementParam;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {

//        mockApi = mock(MockImpl.class);
        mockApi = new MockImpl();

        ElementApi elementApi = mock(ElementImpl.class);

        Field field = MockImpl.class.getDeclaredField("elementApi");
        field.setAccessible(true);
        field.set(mockApi, elementApi);

        elementParam = new ElementParam();
        elementParam.setName("paramName");
        elementParam.setAddr("paramAddr");

        ElementResult elementResult = new ElementResult();
        elementResult.setName("zhangsan");
        elementResult.setAddr("addr123");
        elementResult.setAge(10L);
        elementResult.setIdNo("1234");
//        这里不能定义一个具体的elementParam对象,
//        否则后文调elementApi.queryElement()方法时必须传同一个具体的elementParam对象,
//        才会返回自定义的elementResult结果。
        when(elementApi.queryElement(elementParam)).thenReturn(elementResult);
//        when(elementApi.queryElement(any(ElementParam.class))).thenReturn(elementResult);

//        when(mockApi.getName(anyString())).thenReturn("mockReturnName");
//        when(mockApi.getName(any(ElementParam.class), anyString())).thenReturn("mockReturnName2");


    }

    @Test
    public void testGetName() {

//        String name = mockApi.getName("idForGetName");
//        System.out.println("name1=" + name);

        String name = mockApi.getName(elementParam, "idForGetName2");
        System.out.println("name2=" + name);

    }



}
