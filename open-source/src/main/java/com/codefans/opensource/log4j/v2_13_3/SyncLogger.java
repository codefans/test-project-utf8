/**
 * Copyright (C), 2015-2020, 京东
 * FileName: SyncLogger
 * Author:   codefans
 * Date:     2020/6/28 15:28
 * Description: 同步Logger
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
 * 同步Logger
 *
 * @author codefans
 * @date 2020/06/28 15:28
 * @since 1.0.0
 */
public class SyncLogger extends Log4JBase {

    private Logger log = null;

    public static void main(String[] args) {

        SyncLogger syncLogger = new SyncLogger();
        syncLogger.print();

    }

    public void print() {
        try {

            String fileName = "log4j2_sync.xml";
            String propFile = OPEN_SOURCE_RESOURCES_LOG4J + File.separator + fileName;
            System.out.println("propFile:" + propFile);

            //初始化方式1
            System.setProperty("log4j.configurationFile", propFile);

            log = LogManager.getLogger(SyncLogger.class);

            log.info("hello world!");
            log.debug("hello world from debug info");

            new Log4j2DebugLog();
            new Log4j2InfoLog();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}