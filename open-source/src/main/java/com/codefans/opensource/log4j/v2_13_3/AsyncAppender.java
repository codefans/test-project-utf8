/**
 * Copyright (C), 2015-2020, 京东
 * FileName: AsyncAppender
 * Author:   caishengzhi
 * Date:     2020/6/28 15:29
 * Description: 异步appender
 */
package com.codefans.opensource.log4j.v2_13_3;


import com.codefans.opensource.log4j.Log4JBase;
import com.codefans.opensource.log4j.v2_10_0.Log4j2DebugLog;
import com.codefans.opensource.log4j.v2_10_0.Log4j2InfoLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 *
 * 异步appender
 *
 * @author codefans
 * @date 2020/06/28 15:29
 * @since 1.0.0
 */
public class AsyncAppender extends Log4JBase {

    private Logger log = null;

    public static void main(String[] args) {

        AsyncAppender asyncAppender = new AsyncAppender();
        asyncAppender.print();

    }

    public void print() {
        try {

            String fileName = "log4j2_async_appender.xml";
            String propFile = OPEN_SOURCE_RESOURCES_LOG4J + File.separator + fileName;
            System.out.println("propFile:" + propFile);

            //初始化方式1
            System.setProperty("log4j.configurationFile", propFile);

            log = LogManager.getLogger(AsyncAppender.class);

            log.info("hello world!");
            log.debug("hello world from debug info");

            new Log4j2DebugLog();
            new Log4j2InfoLog();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}