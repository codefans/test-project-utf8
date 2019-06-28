package com.codefans.opensource.dubbo.serialization.java;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: codefans
 * @date: 2019-06-27 10:55
 */
public class CompactedJavaSerialization {

    public void writeBytes(ObjectOutputStream outputStream, byte[] v) throws IOException {
        if (v == null) {
            outputStream.writeInt(-1);
        } else {
            writeBytes(outputStream, v, 0, v.length);
        }
    }

    public void writeBytes(ObjectOutputStream outputStream, byte[] v, int off, int len) throws IOException {
        if (v == null) {
            outputStream.writeInt(-1);
        } else {
            outputStream.writeInt(len);
            outputStream.write(v, off, len);
        }
    }

    public byte[] readBytes(CompactedObjectInputStream inputStream) throws IOException {
        int len = inputStream.readInt();
        if (len < 0) {
            return null;
        } else if (len == 0) {
            return new byte[]{};
        } else {
            byte[] result = new byte[len];
            inputStream.readFully(result);
            return result;
        }
    }

    public Object readObject(CompactedObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        return inputStream.readObject();
    }

    public void writeObject(CompactedObjectOutputStream outputStream, Object obj) throws IOException {
        outputStream.writeObject(obj);
    }

}
