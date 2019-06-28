package com.codefans.opensource.json.performance;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2018-05-23 09:32
 */
public class GsonPerformanceTest {

    @Test
    public void gsonTest() {

        String optType = "toJson";
        GsonPerformance gson = new GsonPerformance(optType);
        gson.runTime();
        gson.costTime();

    }

}
