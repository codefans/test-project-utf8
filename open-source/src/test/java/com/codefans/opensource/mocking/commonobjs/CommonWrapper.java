/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CommonWrapper
 * Author:   codefans
 * Date:     2020/2/28 7:08
 * Description: wrapper测试类
 */
package com.codefans.opensource.mocking.commonobjs;


import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 *
 * wrapper测试类
 *
 * @author: codefans
 * @Date: 2020/02/28 07:08
 * @since: 1.0.0
 */
public class CommonWrapper {

    @Mock
    private CommonRpcApi commonRpcApi;

    public void add() {
        commonRpcApi.add("zhangsan");
        System.out.println("CommonWrapper.add()");
    }

    public void delete() {
        commonRpcApi.delete();
        System.out.println("CommonWrapper.delete()");
    }

    public void update() {
        commonRpcApi.update();
        System.out.println("CommonWrapper.update()");
    }

    public void query() {
        commonRpcApi.query();
        System.out.println("CommonWrapper.query()");
    }

    public CommonRpcApi getCommonRpcApi() {
        return commonRpcApi;
    }

    public void setCommonRpcApi(CommonRpcApi commonRpcApi) {
        this.commonRpcApi = commonRpcApi;
    }
}