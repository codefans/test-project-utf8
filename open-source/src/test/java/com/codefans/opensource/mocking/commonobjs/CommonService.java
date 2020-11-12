/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CommonService
 * Author:   codefans
 * Date:     2020/2/28 7:08
 * Description: service测试类
 */
package com.codefans.opensource.mocking.commonobjs;


import org.mockito.InjectMocks;
import org.mockito.Spy;

/**
 *
 * service测试类
 *
 * @author: codefans
 * @Date: 2020/02/28 07:08
 * @since: 1.0.0
 */
public class CommonService {

    @InjectMocks
    private CommonWrapper commonWrapper;

    public void add() {
        commonWrapper.add();
        System.out.println("CommonService.add()");
    }

    public void delete() {
        commonWrapper.delete();
        System.out.println("CommonService.delete()");
    }

    public void update() {
        commonWrapper.update();
        System.out.println("CommonService.update()");
    }

    public void query() {
        commonWrapper.query();
        System.out.println("CommonService.query()");
    }

    public CommonWrapper getCommonWrapper() {
        return commonWrapper;
    }

    public void setCommonWrapper(CommonWrapper commonWrapper) {
        this.commonWrapper = commonWrapper;
    }
}