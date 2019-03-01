package com.codefans.reusablecode.unittest.mock;

import com.codefans.reusablecode.unittest.mock.model.ElementParam;
import com.codefans.reusablecode.unittest.mock.model.ElementResult;

/**
 * @author: codefans
 * @date: 2019-03-01 10:40:34
 */
public interface ElementApi {

    public ElementResult queryElement(ElementParam elementParam);


}
