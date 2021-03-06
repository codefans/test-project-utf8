package com.codefans.interview.algorithm.leetcode.concurrency;

import com.codefans.interview.concurrent.onebyone.RunOneByOneApi;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author: codefans
 * @Date: 2019-10-14 21:58
 */

public class No1114PrintInOrder_PipedStream implements RunOneByOneApi {

    private PipedInputStream pis = new PipedInputStream();
    private PipedInputStream pis2 = new PipedInputStream();
    private PipedOutputStream pos = new PipedOutputStream();
    private PipedOutputStream pos2 = new PipedOutputStream();

    private String OK = "ok";
    private byte[] buffer = new byte[OK.length()];

    public No1114PrintInOrder_PipedStream() {
        try {
            pis.connect(pos);
            pis2.connect(pos2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {


        printFirst.run();

        try {
            pos.write(OK.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {

        try {
            int len = pis.read(buffer);
            if(len > 0) {
                String ctn = new String(buffer);
                if(OK.equals(ctn)) {
                    printSecond.run();
                    pos2.write(OK.getBytes());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {

        try {
            int len = pis2.read(buffer);
            if(len > 0) {
                String ctn = new String(buffer);
                if(OK.equals(ctn)) {
                    printThird.run();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
