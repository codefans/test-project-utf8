/**
 * Copyright (C), 2015-2020, 京东
 * FileName: ExchangerTest
 * Author:   caishengzhi
 * Date:     2020/10/30 16:00
 * Description: Exchanger测试
 */
package com.codefans.basicjava.util;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 *
 * Exchanger测试
 *
 * @author codefans
 * @date 2020/10/30 16:00
 * @since 1.0.0
 */
public class ExchangerTest {

    @Test
    public void test() {

        final Exchanger<Map<String, String>> exchanger = new Exchanger<Map<String, String>>();
        final int loopCount = 10;

        Thread producer = new Thread() {
            @Override
            public void run() {

                try {

                    String paramValue = "";
                    for(int i = 0; i < loopCount; i ++) {
                        paramValue = "this is paramIndex_" + i;
                        Map<String, String> dataMap = new HashMap<String, String>();
                        dataMap.put("param_name", paramValue);
                        Map<String, String> resultMap = exchanger.exchange(dataMap);
                        System.out.println("producer record[" + (i + 1) + "], param=[" + paramValue + "], result=[" + resultMap.get("result") + "]");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread consumer = new Thread() {
            @Override
            public void run() {
                try {

                    String resultValue = "";
                    for(int i = 0; i < loopCount; i ++) {
                        resultValue = "resultFromConsumer_" + i;
                        Map<String, String> dataMap = new HashMap<String, String>();
                        dataMap.put("result", resultValue);
                        Map<String, String> resultMap = exchanger.exchange(dataMap);
                        System.out.println("consumer record[" + (i + 1) + "], param=[" + resultValue + "], result=[" + resultMap.get("param_name") + "]");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}