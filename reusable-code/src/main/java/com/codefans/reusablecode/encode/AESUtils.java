package com.codefans.reusablecode.encode;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author: codefans
 * @date: 2019-07-18 19:40
 */
public class AESUtils {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key 加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return org.apache.commons.codec.binary.Base64.encodeBase64String(result);//通过Base64转码返回
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content, String key) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));

            //执行操作
            byte[] result = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(content));

            return new String(result, "utf-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKey getSecretKey(final String key) {

        try {

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
            DESKeySpec keySpec = new DESKeySpec(key.getBytes());
            keyFactory.generateSecret(keySpec);
            return keyFactory.generateSecret(keySpec);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
//        String content = "hello,您好";
//        String key = "sde@5f98H*^hsff%dfs$r344&df8543*er";
//        System.out.println("content:" + content);
//        String s1 = AESUtils.encrypt(content, key);
//        System.out.println("s1:" + s1);
//        System.out.println("s2:"+AESUtils.decrypt(s1, key));


        jdkAES();

    }

    public static void aesEncrypt() {
        try {
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
//        byte[] keybytes = secretKey.getEncoded();
            byte[] keybytes = "abcdefghijklmnopqrstuvwxyz".getBytes();


            // key的转换
            Key key = new SecretKeySpec(keybytes, "AES");

            // 加密
            // AES/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String src = "abc123defg";
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt : " + org.apache.commons.codec.binary.Base64.encodeBase64String(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }


    }
    public static void jdkAES() {

        try {
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
//            byte[] keybytes = secretKey.getEncoded();
            byte[] keybytes = "abcdefghijklmnopqrstuvwxyz".getBytes();

            // key的转换
            Key key = new SecretKeySpec(keybytes, "AES");

            // 加密
            // AES/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String src = "abc123defg";
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt : " + org.apache.commons.codec.binary.Base64.encodeBase64String(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println("jdk aes decrypt : " + new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
