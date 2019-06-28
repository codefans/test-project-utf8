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

    /**
     * @TODO 如何读取类描述信息 - 2019-06-28
     */
    @Test
    public void readClassDescriptorTest() {

        try {

            String fullClassName = "com.codefans.opensource.dubbo.serialization.java.ClassDescriptorUtils";

            ClassDescriptorUtils classDescriptorUtils = new ClassDescriptorUtils();
            Class cls = Class.forName(fullClassName);

            ObjectStreamClass objectStreamClass = ClassDescriptorUtils.readClassDescriptor(fullClassName);
            System.out.println("result=" + JSON.toJSONString(objectStreamClass));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
