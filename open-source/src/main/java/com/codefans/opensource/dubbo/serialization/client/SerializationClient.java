package com.codefans.opensource.dubbo.serialization.client;

import com.codefans.opensource.dubbo.serialization.ToSerializationObject;
import com.codefans.opensource.dubbo.serialization.java.CompactedJavaSerialization;
import com.codefans.opensource.dubbo.serialization.java.CompactedObjectOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author codefans
 * @date 2019-06-28 11:14
 */
public class SerializationClient {

    String host;
    int port;
    CompactedJavaSerialization compactedJavaSerialization = new CompactedJavaSerialization();
    CompactedObjectOutputStream compactedObjectOutputStream;

    public SerializationClient(String host, int port) {

        try {
//            String host = "10.58.196.127";
//            int port = 9998;
            Socket socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            compactedObjectOutputStream = new CompactedObjectOutputStream(outputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void compactedJavaSerialization(Object obj) throws IOException {
        compactedJavaSerialization.writeObject(compactedObjectOutputStream, obj);
    }


}



