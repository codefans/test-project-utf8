package com.codefans.opensource.json.performance;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2018-05-23 09:13
 */
public class JacksonPerformanceTest {

    @Test
    public void jacksonRuntime() {

        JacksonPerformance jacksonPerformance = new JacksonPerformance();
        jacksonPerformance.runTime();


    }
}
