package com.codefans.opensource.rocketmq;

import org.apache.rocketmq.common.MixAll;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-08 23:51:39
 */
public class NamesrvTest {

    @Test
    public void namesrvGet() {

        String namesrvEnv = System.getenv(MixAll.NAMESRV_ADDR_ENV);
        System.out.println("namesrvEnv:" + namesrvEnv);

        String namesrvProperty = System.getProperty(MixAll.NAMESRV_ADDR_PROPERTY);
        System.out.println("namesrvProperty:" + namesrvProperty);


    }
}
