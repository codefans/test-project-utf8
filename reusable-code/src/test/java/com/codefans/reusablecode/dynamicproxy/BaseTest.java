package com.codefans.reusablecode.dynamicproxy;

import java.text.DecimalFormat;

/**
 * @author: codefans
 * @date: 2019-06-25 15:22
 */
public class BaseTest {

    protected void test(CountService service, String label)
            throws Exception {
        service.count(); // warm up
        int count = 10000000;
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            service.count();
        }
        time = System.currentTimeMillis() - time;
        if(time == 0) {
            System.out.println(label + time + " ms, " + time + " t/s");
        } else {
            System.out.println(label + time + " ms, " + new DecimalFormat().format(count * 1000 / time) + " t/s");
        }
    }

}
