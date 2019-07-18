package com.codefans.reusablecode.encode;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

/**
 * @author: codefans
 * @date: 2019-06-25 16:57
 */
public class CodecUtils {

    public void decode() {


    }

    public void encode() {

        Base64 codec = new Base64();
        try {
            codec.encode(new String("fdfd"));
        } catch (EncoderException e) {
            e.printStackTrace();
        }

    }

}
