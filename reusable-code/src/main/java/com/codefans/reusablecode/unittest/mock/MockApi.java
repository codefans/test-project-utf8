package com.codefans.reusablecode.unittest.mock;

import com.codefans.reusablecode.unittest.mock.model.ElementParam;

/**
 * @author: codefans
 * @date: 2019-03-01 10:37:03
 */
public interface MockApi {

    public String getName(String id);

    public String getName(ElementParam elementParam, String id);


}
