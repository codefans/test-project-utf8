/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CommonRpcApi
 * Author:   codefans
 * Date:     2020/2/28 7:08
 * Description: rpc测试类
 */
package com.codefans.opensource.mocking.commonobjs;


/**
 *
 * rpc测试类
 *
 * @author: codefans
 * @Date: 2020/02/28 07:08
 * @since: 1.0.0
 */
public class CommonRpcApi {

    public String add(String name) {
        System.out.println("CommonRpcApi.add()");
        return "true";
    }

    public void delete() {
        System.out.println("CommonRpcApi.delete()");
    }

    public void update() {
        System.out.println("CommonRpcApi.update()");
    }

    public void query() {
        System.out.println("CommonRpcApi.query()");
    }

}