package com.codefans.opensource.dubbo.serialization;

import com.codefans.opensource.dubbo.serialization.java.CompactedJavaSerialization;
import com.codefans.opensource.dubbo.serialization.java.CompactedObjectInputStream;
import com.codefans.opensource.dubbo.serialization.java.CompactedObjectOutputStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author: codefans
 * @date: 2019-06-27 14:47
 */
public class CompactedJavaSerializationTest {

    @Test
    public void test() {

        try {

            ToSerializationObject toSerializationObject = new ToSerializationObject();
            toSerializationObject.setB(true);
            toSerializationObject.setC('c');
            toSerializationObject.setI(110);

            CompactedJavaSerialization compactedJavaSerialization = new CompactedJavaSerialization();

            byte[] bytes = new byte[1024*1024];
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream(1024*1024);
            CompactedObjectOutputStream outputStream = new CompactedObjectOutputStream(byteArray);

            compactedJavaSerialization.writeObject(outputStream, toSerializationObject);
            CompactedObjectInputStream inputStream = new CompactedObjectInputStream(new ByteArrayInputStream(byteArray.toByteArray()));

            ToSerializationObject deserializationObj = (ToSerializationObject)compactedJavaSerialization.readObject(inputStream);
            System.out.println("ToSerializationObject=" + deserializationObj);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
