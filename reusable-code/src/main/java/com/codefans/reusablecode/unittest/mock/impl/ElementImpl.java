package com.codefans.reusablecode.unittest.mock.impl;

import com.codefans.reusablecode.unittest.mock.ElementApi;
import com.codefans.reusablecode.unittest.mock.model.ElementParam;
import com.codefans.reusablecode.unittest.mock.model.ElementResult;

/**
 * @author: codefans
 * @date: 2019-03-01 10:40:44
 */
public class ElementImpl implements ElementApi {

    @Override
    public ElementResult queryElement(ElementParam elementParam) {
        System.out.println("name=" + elementParam.getName());
        System.out.println("addr=" + elementParam.getAddr());

        ElementResult elementResult = new ElementResult();
        elementResult.setIdNo("customIdNo");
        elementResult.setName("customName");
        elementResult.setAge(22L);
        elementResult.setAddr("customAddr");

        return elementResult;
    }
}
