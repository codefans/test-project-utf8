package com.codefans.reusablecode.encode;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: codefans
 * @Date: 2022-05-13 17:40
 */

public class SHA256Utils {

    /**
     * 利用java原生的摘要实现SHA256加密
     *
     * @param str 加密后的报文
     * @return
     */
    public static String sha256UsingJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    public static String sha256EncodeFile(String filePath) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sha256UsingJava(fis);
    }

    /**
     * 利用java原生的摘要实现SHA256加密
     *
     * @param input 加密后的报文
     * @return
     */
    public static String sha256UsingJava(InputStream input) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            int len = 0;
            byte[] byteCache = new byte[2048];
            while((len = input.read(byteCache)) != -1) {
                messageDigest.update(byteCache, 0, len);
            }
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /**
     * @param inputStr
     * @return
     * @throws Exception
     */
    public static String sha256ApacheEncode(String inputStr) throws Exception {
        return sha256ApacheEncode(inputStr, "UTF-8");
    }

    public static String sha256ApacheEncode(String inputStr, String charsetName) throws Exception {
        return DigestUtils.sha256Hex(inputStr.getBytes(charsetName));
    }

    public static String sha256ApacheEncodeFile(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        return sha256ApacheEncode(fis);
    }

    /**
     * @return
     * @Comment SHA256实现
     */
    public static String sha256ApacheEncode(InputStream input) throws Exception {
        return DigestUtils.sha256Hex(input);
    }

    public static void main(String args[]) throws Exception {
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("Java SHA256后：" + sha256UsingJava(str));
        System.out.println("Apache SHA256后：" + sha256ApacheEncode(str));

        String sha256Source = "d20a515f294a50c2f5286b36626d816ae242f47c8ae65476a527fd73a87ec677";
        String filePath = "C:\\Users\\Adminstrator\\Downloads\\ideaIU-2022.1.1.win.zip";
        long beginTime = System.currentTimeMillis();
        String sha256dest = sha256EncodeFile(filePath);
        System.out.println("Java SHA256, " + sha256Source.equals(sha256dest) + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

        beginTime = System.currentTimeMillis();
        sha256dest = sha256ApacheEncodeFile(filePath);
        System.out.println("Apache SHA256, " + sha256Source.equals(sha256dest) + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

    }

}
