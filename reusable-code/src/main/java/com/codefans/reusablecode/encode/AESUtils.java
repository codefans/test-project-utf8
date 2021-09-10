package com.codefans.reusablecode.encode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author: codefans
 * @date: 2019-07-18 19:40
 */
public class AESUtils {

    private static final String AES = "AES";

    private static final String UTF_8 = "utf-8";
    /**
     * 密钥-长度为16
     */
    private static final String KEY_LEN_16 = "LQp8ANg2S3ROPjWZ";

    /**
     * 秘钥-长度为24
     */
    private static final String KEY_LEN_24 = "LQp8ANg2S3ROPjWZjku79jh3";

    /**
     * 算法
     */
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        System.out.println("密钥：" + KEY_LEN_16);

        String content = "url：findNames.actionfdfdfdfdfdfdfd";
        System.out.println("加密前：" + content);

//        String encrypt = aesEncrypt(content, KEY_LEN_16);
        String encrypt = encrypt(content);
        System.out.println("加密后：" + encrypt);
        System.out.println("密文长度: " + encrypt.length());

//        String decrypt = aesDecrypt(encrypt, KEY_LEN_16);
        String decrypt = decrypt(encrypt);

        System.out.println("解密后：" + decrypt);
        System.out.println("加密前=解密后: " + content.equals(decrypt));
    }

    public static String encrypt(String data) throws UnsupportedEncodingException {
        return encrypt(data, KEY_LEN_24);
    }

    public static String encrypt(String data, String key) throws UnsupportedEncodingException {
        return encrypt(data.getBytes(UTF_8), key.getBytes(UTF_8));
    }

    public static String encrypt(byte[] data, byte[] key) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(AES);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key);
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] result = cipher.doFinal(data);
            String encriptStr = new BASE64Encoder().encode(result);

            return encriptStr;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String decrypt(String data) throws UnsupportedEncodingException {
        return decrypt(data, KEY_LEN_24);
    }

    public static String decrypt(String data, String key) throws UnsupportedEncodingException {
        return decrypt(data, key.getBytes(UTF_8));
    }

    public static String decrypt(String decryptStr, byte[] key) {
        byte[] content;
        try {
            content = new BASE64Decoder().decodeBuffer(decryptStr);

            KeyGenerator kgen = KeyGenerator.getInstance(AES);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key);
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] doFinal = cipher.doFinal(content);
            return new String(doFinal, UTF_8);

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    /**
     * 加密为base64串
     *
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base64串
     *
     * 该方法已废弃，原因是encryptKey的长度只能是16。
     *
     */
    @Deprecated
    private static String aesEncrypt(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        byte[] data = cipher.doFinal(content.getBytes("utf-8"));
        return new BASE64Encoder().encode(data);
    }


    /**
     * 将base64串解密
     *
     * @param encryptStr 待解密的base64串
     * @param decryptKey 解密密钥
     * @return 解密后的string
     *
     * 该方法已废弃，原因是decryptKey的长度只能是16。
     *
     */
    @Deprecated
    private static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {

        byte[] encryptBytes = new BASE64Decoder().decodeBuffer(encryptStr);

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);

        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);


    }




}
