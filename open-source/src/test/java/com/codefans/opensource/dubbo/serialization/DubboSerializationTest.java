package com.codefans.opensource.dubbo.serialization;

import com.codefans.opensource.dubbo.serialization.dubbo.DubboSerialization;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-28 18:34
 */
public class DubboSerializationTest {

    @Test
    public void dubboSerialTest() {

        ToSerializationObject toSerializationObject = new ToSerializationObject();
        toSerializationObject.setI(127);
        toSerializationObject.setC('D');
        toSerializationObject.setB(true);
        toSerializationObject.setF(1.2f);
        toSerializationObject.setD(2.4d);
        toSerializationObject.setaByte(new Byte("120"));
        byte[] dataArr = DubboSerialization.serizlize(toSerializationObject);

        ToSerializationObject deserializedObj = (ToSerializationObject) DubboSerialization.deserizlize(dataArr);
        System.out.println(deserializedObj);


    }

}
