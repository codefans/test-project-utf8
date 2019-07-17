package com.codefans.opensource.performance;

import ch.qos.logback.classic.LoggerContext;
import com.codefans.basicjava.concurrent.threadpool.DefaultThreadPool;
import com.codefans.opensource.log4j.Log4JBase;
import com.codefans.opensource.logback.LogbackInit;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: codefans
 * @Date: 2019-07-17 22:35
 */

public class LoggerPerformanceTest extends Log4JBase {

    private DefaultThreadPool threadPool;
    private LoggerPerformance loggerPerformance;

    @Before
    public void before() {
        threadPool = new DefaultThreadPool();
        loggerPerformance = new LoggerPerformance();
    }

    @Test
    public void log4jPerformanceTest() {

        String propFile = OPEN_SOURCE_RESOURCES_ROOT + File.separator + "log4j/log4j_v1_2_9.properties";
        System.out.println("propFile:" + propFile);

        PropertyConfigurator.configure(propFile);

        org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoggerPerformanceTest.class);
        Runnable task = this.getTask(log);
        this.performanceExecute(task);

    }



    @Test
    public void log4j2PerformanceTest() {


        //初始化方式1
        System.setProperty("log4j.configurationFile", "classpath:log4j/log4j2_v2_10_0.properties");

        //初始化方式2
//            File log4jFile = new File(propFile);
//            ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jFile), log4jFile);
//            Configurator.initialize(null, source);

        //初始化方式3
//            File log4jFile = new File(propFile);
//            LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
//            loggerContext.setConfigLocation(log4jFile.toURI());

        org.apache.logging.log4j.Logger log = LogManager.getLogger(LoggerPerformanceTest.class);
        Runnable task = this.getTask(log);
        this.performanceExecute(task);

    }



    @Test
    public void logbackPerformanceTest() {

        String configFile = OPEN_SOURCE_RESOURCES_ROOT + File.separator + "logback/logback.xml";
        System.out.println("configFile:" + configFile);

        LogbackInit.initLogback(configFile);

        ch.qos.logback.classic.Logger log = new LoggerContext().getLogger(LoggerPerformanceTest.class);
        Runnable task = this.getTask(log);
        this.performanceExecute(task);


    }

    public void performanceExecute(Runnable task) {
        int taskNums = 10 * 10000;
        List<Future<?>> futureList = new ArrayList<Future<?>>(taskNums);
        for(int i = 0; i < taskNums; i ++) {
            Future<?> future = threadPool.submit(task);
            futureList.add(future);
        }

        for(int i = 0; i < taskNums; i ++) {
            Future<?> future = futureList.get(i);
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public Runnable getTask(final org.apache.log4j.Logger log) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                loggerPerformance.log4j(log);
            }
        };
        return task;
    }

    public Runnable getTask(final org.apache.logging.log4j.Logger log) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                loggerPerformance.log4j2(log);
            }
        };
        return task;
    }

    public Runnable getTask(final ch.qos.logback.classic.Logger log) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                loggerPerformance.logback(log);
            }
        };
        return task;
    }

}
