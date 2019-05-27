package com.codefans.practicetask.ebbinghausmemory;

import org.junit.Test;

import java.util.Date;

/**
 * @author: codefans
 * @date: 2019-05-27 15:07:37
 */
public class TimePointUtilTest {

    @Test
    public void timePointGenerateTest() {

        ReviewTimePoint reviewTimePoint = TimePointUtil.timePointGenerate(new Date());
        System.out.println(reviewTimePoint);

    }

}
