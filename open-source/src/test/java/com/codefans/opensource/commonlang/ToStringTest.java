package com.codefans.opensource.commonlang;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2018-05-29 16:30
 */
public class ToStringTest {

    @Test
    public void toStringTest() {

        DomainBean domainBean = new DomainBean();
        domainBean.setId(1000L);
        domainBean.setUsername("lisi");

        System.out.println(domainBean);

    }

}
