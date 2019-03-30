package com.codefans.reusablecode.encode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author: codefans
 * @date: 2019-03-30 09:39:24
 */
public class Base64 {

    public static String encode(String content) throws UnsupportedEncodingException {
        String base64Str = "";
        base64Str = new BASE64Encoder().encode(content.getBytes("utf-8"));
        return base64Str;
    }

    public static String decode(String encodedContent) throws IOException {
        String decodeContent = "";
        byte[] content = new BASE64Decoder().decodeBuffer(encodedContent);
        decodeContent = new String(content, "utf-8");
        return decodeContent;
    }



}
