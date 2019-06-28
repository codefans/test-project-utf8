package com.codefans.opensource.dubbo.serialization.dubbo;

import com.codefans.opensource.dubbo.serialization.hessian.Hessian2Deserializer;
import com.codefans.opensource.dubbo.serialization.hessian.Hessian2Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: codefans
 * @date: 2019-06-28 18:27
 */
public class DubboSerialization {

    private static final int BUFFER_SIZE = 2048;

    public static byte[] serizlize(Object obj) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFFER_SIZE);

        try {
            DubboSerializer dubboSerializer = new DubboSerializer(baos);
            dubboSerializer.writeObject(obj);
            dubboSerializer.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }


    public static Object deserizlize(byte[] buffer) {

        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        DubboDeserializer dubboDeserializer = new DubboDeserializer(bais);
        Object obj = null;
        try {
            obj = dubboDeserializer.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;

    }

}
