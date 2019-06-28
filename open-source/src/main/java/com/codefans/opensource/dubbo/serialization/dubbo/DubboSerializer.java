package com.codefans.opensource.dubbo.serialization.dubbo;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: codefans
 * @date: 2019-06-28 18:25
 */
public class DubboSerializer {

    private GenericObjectOutput genericObjectOutput;

    public DubboSerializer(OutputStream out) {
        genericObjectOutput = new GenericObjectOutput(out);
    }

    public void writeObject(Object obj) throws IOException {
        genericObjectOutput.writeObject(obj);
    }

    public void flushBuffer() throws IOException {
        genericObjectOutput.flushBuffer();
    }



}
