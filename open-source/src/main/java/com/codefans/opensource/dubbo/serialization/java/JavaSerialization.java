package com.codefans.opensource.dubbo.serialization.java;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: codefans
 * @date: 2019-06-27 09:49
 */
public class JavaSerialization {

    public final static int MAX_BYTE_ARRAY_LENGTH = 8 * 1024 * 1024;

    public void writeObject(ObjectOutputStream outputStream, Object obj) throws IOException {
        if (obj == null) {
            outputStream.writeByte(0);
        } else {
            outputStream.writeByte(1);
            outputStream.writeObject(obj);
        }
    }

    public void flushBuffer(ObjectOutputStream outputStream) throws IOException {
        outputStream.flush();
    }

    public Object readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        byte b = inputStream.readByte();
        if (b == 0)
            return null;

        return inputStream.readObject();
    }

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

    public byte[] readBytes(ObjectInputStream inputStream) throws IOException {
        int len = inputStream.readInt();
        if (len < 0)
            return null;
        if (len == 0)
            return new byte[0];
        if (len > MAX_BYTE_ARRAY_LENGTH)
            throw new IOException("Byte array length too large. " + len);

        byte[] b = new byte[len];
        inputStream.readFully(b);
        return b;
    }


}
