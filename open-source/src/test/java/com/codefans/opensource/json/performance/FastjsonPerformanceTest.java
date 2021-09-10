package com.codefans.opensource.json.performance;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * @author: codefans
 * @date: 2018-05-23 09:00
 */
public class FastjsonPerformanceTest {

    @Test
    public void fastjsonTest() {

        FastjsonPerformance fastjsonPerformance = new FastjsonPerformance();
        fastjsonPerformance.runTime();

    }

    @Test
    public void fastjsonBugTest() {

//        String time = "1970-01-01 00:00:00";
        String time = "2020-04-21 00:00:00";
//        String time = "1970-01-01 00:00:00.000";
//        String time = "1970-01-01 00:00:00.000000000.000000000";
//        String time = "1970-01-01 00:00:00.000000000.000000";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("time", time);

        Timestamp timestamp = jsonObject.getTimestamp("time");
        System.out.println("time:" + timestamp);

        System.out.println(jsonObject.get("time"));

    }

}
