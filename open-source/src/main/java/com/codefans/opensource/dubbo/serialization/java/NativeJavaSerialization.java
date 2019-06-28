package com.codefans.opensource.dubbo.serialization.java;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: codefans
 * @date: 2019-06-27 09:49
 */
public class NativeJavaSerialization {

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

    public void flushBuffer(ObjectOutputStream outputStream) throws IOException {
        outputStream.flush();
    }

    public byte[] readBytes(ObjectInputStream inputStream) throws IOException {
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

    public Object readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        return inputStream.readObject();
    }

    public void writeObject(ObjectOutputStream outputStream, Object obj) throws IOException {
        outputStream.writeObject(obj);
    }

}
