package com.codefans.opensource.dubbo.serialization.server;

import com.codefans.opensource.dubbo.serialization.ToSerializationObject;
import com.codefans.opensource.dubbo.serialization.java.CompactedJavaSerialization;
import com.codefans.opensource.dubbo.serialization.java.CompactedObjectInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: codefans
 * @date: 2019-06-28 11:05
 */
public class SerializationServer {

    int port;
    ServerSocket serverSocket;

    public SerializationServer(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startupCompactedJavaSerializationServer() {

        CompactedJavaSerialization compactedJavaSerialization = new CompactedJavaSerialization();
        Socket socket = null;

        for(;;) {

            InputStream is = null;

            try {
                socket = serverSocket.accept();

                is = socket.getInputStream();
                ToSerializationObject toSerializationObject = (ToSerializationObject) compactedJavaSerialization.readObject(new CompactedObjectInputStream(is));
                System.out.println(toSerializationObject);


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(is != null) {
                        is.close();
                        is = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
