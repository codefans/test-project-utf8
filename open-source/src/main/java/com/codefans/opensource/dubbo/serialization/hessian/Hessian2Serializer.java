package com.codefans.opensource.dubbo.serialization.hessian;

import com.codefans.opensource.dubbo.serialization.hessian.io.Hessian2Input;
import com.codefans.opensource.dubbo.serialization.hessian.io.Hessian2Output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author: codefans
 * @date: 2019-06-28 15:41
 */
public class Hessian2Serializer {

    private Hessian2Output mH2o;

    public Hessian2Serializer(OutputStream os) {
        mH2o = new Hessian2Output(os);
        mH2o.setSerializerFactory(Hessian2SerializerFactory.SERIALIZER_FACTORY);
    }

    public void writeObject(Object obj) throws IOException {
        mH2o.writeObject(obj);
    }

    public void flushBuffer() throws IOException {
        mH2o.flushBuffer();
    }


}
