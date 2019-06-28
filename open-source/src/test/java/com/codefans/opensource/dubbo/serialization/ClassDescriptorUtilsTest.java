package com.codefans.opensource.dubbo.serialization;

import com.alibaba.fastjson.JSON;
import com.codefans.opensource.dubbo.serialization.java.ClassDescriptorUtils;
import org.junit.Test;

import java.io.ObjectStreamClass;

/**
 * @author: codefans
 * @date: 2019-06-28 09:35
 */
public class ClassDescriptorUtilsTest {

    @Test
    public void readClassDescriptorTest() {

        try {

            String fullClassName = "com.codefans.opensource.dubbo.serialization.java.ClassDescriptorUtils";
            ObjectStreamClass objectStreamClass = ClassDescriptorUtils.readClassDescriptor(fullClassName);
            System.out.println("result=" + JSON.toJSONString(objectStreamClass));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
