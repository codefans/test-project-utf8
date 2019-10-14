package com.codefans.interview.concurrent.crossexec;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author: codefans
 * @date: 2019-10-08 18:00
 */
public class PipedStreamImpl {

    public static void main(String[] args) throws IOException {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        PipedInputStream input1 = new PipedInputStream();
        PipedInputStream input2 = new PipedInputStream();
        PipedOutputStream output1 = new PipedOutputStream();
        PipedOutputStream output2 = new PipedOutputStream();

        input1.connect(output1);
        input2.connect(output2);

        String msg = "Your Turn";
        byte[] buffer = new byte[9];


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aI) {

                        input1.read(buffer);

                        if(new String(buffer).equals(msg)) {
                            System.out.print(c);
                        }

                        output2.write(msg.getBytes());

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aC) {

                        System.out.print(c);

                        output1.write(msg.getBytes());

                        input2.read(buffer);

                        if(new String(buffer).equals(msg)) {
                            continue;
                        }

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }

            }
        }, "t2");

        t1.start();
        t2.start();

    }

}
