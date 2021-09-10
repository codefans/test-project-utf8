/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CommonController
 * Author:   codefans
 * Date:     2020/2/28 7:07
 * Description: 模拟通用controller类
 */
package com.codefans.opensource.mocking.commonobjs;


import org.mockito.InjectMocks;

/**
 *
 * 模拟通用controller类
 *
 * @author: codefans
 * @Date: 2020/02/28 07:07
 * @since: 1.0.0
 */
public class CommonController {

    @InjectMocks
    private CommonService commonService;

    public void add() {
        commonService.add();
        System.out.println("CommonController.add()");
    }

    public void delete() {
        commonService.delete();
        System.out.println("CommonController.delete()");
    }

    public void update() {
        commonService.update();
        System.out.println("CommonController.update()");
    }

    public void query() {
        commonService.query();
        System.out.println("CommonController.query()");
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }
}