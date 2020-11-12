/**
 * Copyright (C), 2015-2020, 京东
 * FileName: AutoMockTest
 * Author:   codefans
 * Date:     2020/3/6 22:20
 * Description: 自动注入测试类
 */
package com.codefans.opensource.mocking.mockito;


import com.codefans.opensource.mocking.commonobjs.CommonController;
import com.codefans.opensource.mocking.commonobjs.CommonRpcApi;
import com.codefans.opensource.mocking.commonobjs.CommonService;
import com.codefans.opensource.mocking.commonobjs.CommonWrapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.mock;

/**
 *
 * 自动注入测试类
 *
 * @author: codefans
 * @Date: 2020/03/06 22:20
 * @since: 1.0.0
 */
public class AutoMockTest {

    @InjectMocks
    private CommonController commonController;


    @Spy
    private CommonService commonService;

    @Spy
    private CommonWrapper commonWrapper;

    @Mock
    private CommonRpcApi commonRpcApi;

    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void mockTest() {

        commonController.add();
//        String result = commonRpcApi.add("hello");
//        System.out.println("result:" + result);

    }

}