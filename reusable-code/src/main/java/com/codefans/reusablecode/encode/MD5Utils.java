package com.codefans.reusablecode.encode;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @Author: codefans
 * @Date: 2022-05-13 17:03
 */

public class MD5Utils {

    /**
     * 普通MD5方法 容易被破解
     */
    public static String md5(String input) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = input.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
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


    public static String fileJavaMD5(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        return md5(fis);
    }

    public static String md5(InputStream input) throws IOException {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = new byte[2048];
        int len = 0;
        while((len = input.read(byteArray)) != -1) {
            md5.update(byteArray, 0, len);
        }
        byte[] md5Bytes = md5.digest();
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



    /**
     * 加盐MD5
     * 生成的md5字符串中, 有16位是盐。
     * @param password
     * @return
     */
    public static String md5WithSalt(String password) {
        String salt = randomSalt();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    private static String randomSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /**
     * 校验加盐后是否和原文一致
     * @author daniel
     * @time 2016-6-11 下午8:45:39
     * @param password
     * @param md5
     * @return
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static String textApacheMD5(String text) throws UnsupportedEncodingException {
        return textApacheMD5(text, "UTF-8");
    }

    public static String textApacheMD5(String text, String charsetName) throws UnsupportedEncodingException {
        return DigestUtils.md5Hex(text.getBytes(charsetName));
    }

    public static String fileApacheMD5(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        return fileApacheMD5(fis);
    }

    public static String fileApacheMD5(InputStream inputStream) throws IOException {
        return DigestUtils.md5Hex(inputStream);
    }

    public static void main(String[] args) throws IOException {
        String md5 = md5("admin");
        System.out.println(md5);
        System.out.println(md5.length());

        String mdsSalt = md5WithSalt("admin");
        System.out.println(mdsSalt);
        System.out.println(mdsSalt.length());
        System.out.println(verify("admin",mdsSalt));

        String filePath = "C:\\Users\\Adminstrator\\Downloads\\ideaIU-2022.1.1.win.zip";
        long beginTime = System.currentTimeMillis();
        String javaMD5Str = fileJavaMD5(filePath);
        System.out.println("Java MD5, " + javaMD5Str + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

        beginTime = System.currentTimeMillis();
        String apacheMD5Str = fileApacheMD5(filePath);
        System.out.println("Apache MD5, " + apacheMD5Str + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

    }

}
