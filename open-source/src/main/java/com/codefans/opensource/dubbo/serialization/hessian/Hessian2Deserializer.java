package com.codefans.opensource.dubbo.serialization.hessian;

import com.codefans.opensource.dubbo.serialization.hessian.io.Hessian2Input;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: codefans
 * @date: 2019-06-28 15:40
 */
public class Hessian2Deserializer {

    private Hessian2Input mH2i;

    public Hessian2Deserializer(InputStream is) {
        mH2i = new Hessian2Input(is);
        mH2i.setSerializerFactory(Hessian2SerializerFactory.SERIALIZER_FACTORY);
    }

    public Object readObject() throws IOException {
        return mH2i.readObject();
    }



}
