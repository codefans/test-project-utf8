package com.codefans.opensource.dubbo.serialization.dubbo;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: codefans
 * @date: 2019-06-28 18:24
 */
public class DubboDeserializer {

    private GenericObjectInput genericObjectInput;

    public DubboDeserializer(InputStream inputStream) {
        genericObjectInput = new GenericObjectInput(inputStream);
    }

    public Object readObject() throws IOException {
        return genericObjectInput.readObject();
    }


}
