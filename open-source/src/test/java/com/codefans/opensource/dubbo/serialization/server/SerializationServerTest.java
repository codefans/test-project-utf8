package com.codefans.opensource.dubbo.serialization.server;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-28 11:15
 */
public class SerializationServerTest {

    @Test
    public void startupCompactedJavaSerializationServerTest() {

        int port = 9998;
        SerializationServer serializationServer = new SerializationServer(port);
        serializationServer.startupCompactedJavaSerializationServer();

    }


}
