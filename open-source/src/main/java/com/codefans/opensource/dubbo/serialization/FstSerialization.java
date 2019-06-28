package com.codefans.opensource.dubbo.serialization;

import org.nustaq.serialization.FSTConfiguration;

/**
 * @author: codefans
 * @date: 2019-06-26 20:35
 */
public class FstSerialization {

    static FSTConfiguration configuration = FSTConfiguration
            // .createDefaultConfiguration();
            .createStructConfiguration();

    public static byte[] serialize(Object obj) {
        return configuration.asByteArray(obj);
    }

    public static Object unserialize(byte[] sec) {
        return configuration.asObject(sec);
    }



}
