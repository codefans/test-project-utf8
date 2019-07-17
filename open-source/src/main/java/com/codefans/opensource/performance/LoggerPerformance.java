package com.codefans.opensource.performance;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.Logger;

//import ch.qos.logback.classic.Logger;

/**
 * @Author: codefans
 * @Date: 2019-07-17 22:13
 */

public class LoggerPerformance {

    public void log4j(Logger log) {

        log.error("log4j error method...");
        log.warn("log4j warn method...");
        log.info("log4j info method...");
        log.trace("log4j trace method...");
        log.debug("log4j debug method...");
    }

    public void log4j2(org.apache.logging.log4j.Logger log) {
        log.fatal("log4j2 fatal method...");
        log.error("log4j2 error method...");
        log.warn("log4j2 warn method...");
        log.info("log4j2 info method...");

        log.debug("log4j2 debug method...");
        log.trace("log4j2 trace method...");
    }

    public void logback(ch.qos.logback.classic.Logger log) {

        log.error("log4j error method...");
        log.warn("log4j warn method...");
        log.info("log4j info method...");
        log.debug("log4j debug method...");
        log.trace("log4j trace method...");
    }


}
