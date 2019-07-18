package com.codefans.reusablecode.encode;

import com.google.common.io.BaseEncoding;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

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

    private static final BaseEncoding BASE64 = BaseEncoding.base64();

    public static String base64Encode(byte[] data) {
        return BASE64.encode(data);
    }

    public static String base64Encode(String data, String charset) {
        byte[] bytes = data.getBytes(Charset.forName(charset));
        return BASE64.encode(bytes);
    }

    public static String base64Encode(String data) {
        return base64Encode(data.getBytes(Charset.defaultCharset()));
    }

    public static byte[] base64Decode(String data) {
        return BASE64.decode(data);
    }


}
