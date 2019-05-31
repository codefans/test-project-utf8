package com.codefans.reusablecode.util;

import org.junit.Test;

import java.text.ParseException;

/**
 * @author: mpif
 * @date: 2019-05-29 16:09:11
 */
public class DateUtilsTest {

    @Test
    public void minusTest() {

        try {

            String beginDate = "2018-08-27 00:00:00";
            String endDate = "2019-08-26 00:00:00";
            long days = 0L;
            days = DateUtils.minus(endDate, beginDate);
            System.out.println("间隔[" + days + "]天");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



}
