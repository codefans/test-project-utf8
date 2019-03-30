package com.codefans.reusablecode.encode;

import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author: codefans
 * @date: 2019-03-30 09:40:34
 */
public class Base64Test {

    @Test
    public void encodeTest() {

        try {

            String originStr = "";
            System.out.println("encodeStr=" + Base64.encode(originStr));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void decodeTest() {

        try {
            String encodedStr = "";
            System.out.println("decodeStr=" + Base64.decode(encodedStr));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
