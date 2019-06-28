package com.codefans.opensource.dubbo.serialization.client;

import com.codefans.opensource.dubbo.serialization.ToSerializationObject;
import org.junit.Test;

import java.io.IOException;

/**
 * @author codefans
 * @date 2019-06-28 11:23
 */
public class SerializationClientTest {

    @Test
    public void test() {

        try {

            String host = "10.58.196.127";
            int port = 9998;
            SerializationClient serializationClient = new SerializationClient(host, port);
            ToSerializationObject toSerializationObject = new ToSerializationObject();
            toSerializationObject.setC('a');
            toSerializationObject.setB(true);
            toSerializationObject.setD(2.2d);
            System.out.println(toSerializationObject);

            serializationClient.compactedJavaSerialization(toSerializationObject);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
