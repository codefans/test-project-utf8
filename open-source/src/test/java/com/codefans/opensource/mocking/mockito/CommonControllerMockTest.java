/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CommonControllerMockTest
 * Author:   codefans
 * Date:     2020/2/28 7:13
 * Description: CommonController测试类
 */
package com.codefans.opensource.mocking.mockito;


import com.codefans.opensource.mocking.commonobjs.CommonController;
import com.codefans.opensource.mocking.commonobjs.CommonRpcApi;
import com.codefans.opensource.mocking.commonobjs.CommonService;
import com.codefans.opensource.mocking.commonobjs.CommonWrapper;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 *
 * CommonController测试类
 *
 * @author: codefans
 * @Date: 2020/02/28 07:13
 * @since: 1.0.0
 */
public class CommonControllerMockTest {

    private CommonController commonController;
    private CommonService commonService;
    private CommonWrapper commonWrapper;
    private CommonRpcApi commonRpcApi;

    @Before
    public void before() {

        commonRpcApi = mock(CommonRpcApi.class);
//        commonRpcApi = spy(CommonRpcApi.class);

        commonWrapper = new CommonWrapper();
        commonWrapper.setCommonRpcApi(commonRpcApi);

        commonService = new CommonService();
        commonService.setCommonWrapper(commonWrapper);

        commonController = new CommonController();
        commonController.setCommonService(commonService);

//        when(commonRpcApi.add(anyString())).thenThrow(new RuntimeException("commonRpcApi.add invoke"));
//        when(commonRpcApi.add(anyString())).thenReturn(true);

    }

    @Test
    public void mockTest() {

//        commonController.add();
        String result = commonRpcApi.add("hello");
        System.out.println("result:" + result);

    }

}