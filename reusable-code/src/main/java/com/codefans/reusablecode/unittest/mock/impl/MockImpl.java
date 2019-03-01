package com.codefans.reusablecode.unittest.mock.impl;

import com.codefans.reusablecode.unittest.mock.ElementApi;
import com.codefans.reusablecode.unittest.mock.MockApi;
import com.codefans.reusablecode.unittest.mock.model.ElementParam;
import com.codefans.reusablecode.unittest.mock.model.ElementResult;

/**
 * @author: codefans
 * @date: 2019-03-01 10:37:40
 */
public class MockImpl implements MockApi {

    private ElementApi elementApi;

    @Override
    public String getName(String id) {
        System.out.println("id=" + id);
        String name = "张三";

        ElementParam elementParam = new ElementParam();
        elementParam.setName("namesss");
        elementParam.setAddr("addrsss");
        ElementResult elementResult = elementApi.queryElement(elementParam);
        System.out.println(elementResult.toString());

        return name;
    }

    @Override
    public String getName(ElementParam elementParam, String id) {
        System.out.println("id=" + id);
        String name = "李四";

        ElementResult elementResult = elementApi.queryElement(elementParam);
        System.out.println(elementResult.toString());

        return name;
    }


}
