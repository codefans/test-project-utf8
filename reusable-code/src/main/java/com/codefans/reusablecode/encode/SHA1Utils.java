package com.codefans.reusablecode.encode;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * @Author: codefans
 * @Date: 2022-05-13 17:39
 */

public class SHA1Utils {


    /**
     * @return
     * @Comment SHA1实现
     */
    public static String sha1Encode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String javaSha1Encode(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        return sha1Encode(fis);
    }

    /**
     * @return
     * @Comment SHA1实现
     */
    public static String sha1Encode(InputStream input) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        int len = 0;
        byte[] byteCache = new byte[2048];
        while((len = input.read(byteCache)) != -1) {
            sha.update(byteCache, 0, len);
        }
        byte[] md5Bytes = sha.digest();
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String apacheSha1EncodeStr(String content) throws Exception {
        return apacheSha1EncodeStr(content, "UTF-8");
    }

    public static String apacheSha1EncodeStr(String content, String charsetName) throws Exception {
        return DigestUtils.sha1Hex(content.getBytes(charsetName));
    }

    public static String apacheSha1Encode(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        return sha1ApacheEncode(fis);
    }

    /**
     * @return
     * @Comment SHA1实现
     */
    public static String sha1ApacheEncode(InputStream input) throws Exception {
        return DigestUtils.sha1Hex(input);
    }

    public static void main(String args[]) throws Exception {
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("Java SHA1后：" + sha1Encode(str));
        System.out.println("Apache SHA1后：" + apacheSha1EncodeStr(str));

        String sha256Source = "d20a515f294a50c2f5286b36626d816ae242f47c8ae65476a527fd73a87ec677";
        String filePath = "C:\\Users\\Adminstrator\\Downloads\\ideaIU-2022.1.1.win.zip";
        long beginTime = System.currentTimeMillis();
        String sha256dest = javaSha1Encode(filePath);
        System.out.println("Java SHA1, " + sha256Source.equals(sha256dest) + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

        beginTime = System.currentTimeMillis();
        sha256dest = apacheSha1Encode(filePath);
        System.out.println("Apache SHA1, " + sha256Source.equals(sha256dest) + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");


    }

}
