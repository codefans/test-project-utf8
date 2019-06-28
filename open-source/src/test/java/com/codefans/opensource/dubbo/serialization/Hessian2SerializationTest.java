package com.codefans.opensource.dubbo.serialization;

import com.codefans.opensource.dubbo.serialization.hessian.Hessian2Serialization;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-28 16:13
 */
public class Hessian2SerializationTest {

    private Hessian2Serialization hessian2Serialization;

    @Before
    public void before() {


    }

    @Test
    public void hessian2SerialTest() {

        ToSerializationObject toSerializationObject = new ToSerializationObject();
        toSerializationObject.setI(127);
        toSerializationObject.setC('D');
        toSerializationObject.setB(true);
        toSerializationObject.setF(1.2f);
        byte[] dataArr = Hessian2Serialization.hessian2Serizlize(toSerializationObject);

        ToSerializationObject deserializedObj = (ToSerializationObject) Hessian2Serialization.hessian2Deserizlize(dataArr);
        System.out.println(deserializedObj);


    }



}
