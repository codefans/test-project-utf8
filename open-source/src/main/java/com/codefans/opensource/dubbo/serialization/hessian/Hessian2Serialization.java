package com.codefans.opensource.dubbo.serialization.hessian;

import com.codefans.opensource.dubbo.serialization.hessian.io.Hessian2Input;
import com.codefans.opensource.dubbo.serialization.hessian.io.Hessian2Output;

import java.io.*;

/**
 * @author: codefans
 * @date: 2019-06-26 19:57
 */
public class Hessian2Serialization {

    private static final int BUFFER_SIZE = 2048;

    public static byte[] hessian2Serizlize(Object obj) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFFER_SIZE);

        try {
            Hessian2Serializer hessian2Serializer = new Hessian2Serializer(baos);
            hessian2Serializer.writeObject(obj);
            hessian2Serializer.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    public static void hessian2Serizlize(OutputStream outputStream, Object obj) {

    }

    public static Object hessian2Deserizlize(byte[] buffer) {

        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        Hessian2Deserializer hessian2Deserializer = new Hessian2Deserializer(bais);
        Object obj = null;
        try {
            obj = hessian2Deserializer.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;

    }




}
