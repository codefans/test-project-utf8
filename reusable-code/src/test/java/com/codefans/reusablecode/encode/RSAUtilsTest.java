package com.codefans.reusablecode.encode;

import com.codefans.reusablecode.util.Base64FileDecoderUtil;
import com.codefans.reusablecode.util.CommonUtils;
import com.codefans.reusablecode.util.DateUtils;
import com.codefans.reusablecode.util.Md5Utils;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.*;

/**
 * @author: codefans
 * @date: 2019-07-22 11:50
 */
public class RSAUtilsTest {


    @Test
    public void createPrivateAndPublicKeyTest() {

        KeyPair keyPair = RSAUtils.generateKeyPair();
        if(keyPair != null) {
            System.out.println("私钥：");
            System.out.println(keyPair.getPrivateKey());
            System.out.println("公钥：");
            System.out.println(keyPair.getPublicKey());
        } else {
            System.out.println("keyPair is null.");
        }


    }

    @Test
    public void encryptByPublicKeyTest() {

        try {


            String token = "fddfdfd";
            Integer step = 1000;
            Long timestamp = System.currentTimeMillis();
            String dataTime = DateUtils.formatYYYYMMDDHHMMSS(new Date());
            String nonce = new Random().nextInt() + "";
            String sign = "";
            /**
             * 设备标识，可选值：IOS、Android
             */
            String deviceType;
            /**
             * 设备唯一序列号
             */
            String deviceSerialNo;

            List<String> paramList = new ArrayList<String>();
            paramList.add("token");
            paramList.add("step");
            paramList.add("timestamp");
            paramList.add("dataTime");
            paramList.add("nonce");
            paramList.add("deviceType");
            paramList.add("deviceSerialNo");

            System.out.println("sort before:");
            Collections.sort(paramList);
            System.out.println("after sort:");
            CommonUtils.print(paramList);

            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwemWZYdTqqD9Z96koF7TLg3Dy/jzj0hxNwGEB+rTZaOqsj9gsheI2b5AoO/cPO4xPMCRbSUqFpeOQWa6uD60m/T9qzU5NlvCDfSVIPY7ULhWAmuswgpv9Bp/x8kNvlT1mcrnUzjLk/HMl6J+XI2z9eTVa5FRadIE0D/0RATSX7wIDAQAB";
            String data = "hello world!!!";
            Charset charset = Charset.forName("utf-8");
            String encryptData = RSAUtils.encryptByPublicKey(data, charset, publicKey);
            System.out.println("encryptData:");
            System.out.println(encryptData);

            boolean verifySuccess = RSAUtils.verifySign(data, charset, publicKey, encryptData);
            System.out.println("verifySuccess=" + verifySuccess);

            encryptData = RSAUtils.encryptByPublicKey(data, charset, publicKey);
            System.out.println("encryptData:");
            System.out.println(encryptData);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void encryptBase64StrByPublicKeyTest() {

        try {

            String publicKey = "";

            File srcFile = new File("/Users/userName/Downloads/base64Str.txt");
            Base64FileDecoderUtil decoder = new Base64FileDecoderUtil();
            String base64Str = decoder.base64Text2OneLine(srcFile);

            Charset charset = Charset.forName("utf-8");
            String encryptData = RSAUtils.encryptByPublicKey(base64Str, charset, publicKey);
            System.out.println("encryptData:");
            System.out.println(encryptData);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void decryptByPrivateKeyTest() {

        String privateKey = "";

        File srcFile = new File("/Users/userName/Downloads/encoderStr.txt");
        Base64FileDecoderUtil decoder = new Base64FileDecoderUtil();
        String encryptData = decoder.base64Text2OneLine(srcFile);

        Charset charset = Charset.forName("utf-8");
        String decryptData = RSAUtils.decryptByPrivateKey(encryptData, charset, privateKey);
        System.out.println("decryptData:");
        System.out.println(decryptData);




    }

    @Test
    public void signTest() {

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwemWZYdTqqD9Z96koF7TLg3Dy/jzj0hxNwGEB+rTZaOqsj9gsheI2b5AoO/cPO4xPMCRbSUqFpeOQWa6uD60m/T9qzU5NlvCDfSVIPY7ULhWAmuswgpv9Bp/x8kNvlT1mcrnUzjLk/HMl6J+XI2z9eTVa5FRadIE0D/0RATSX7wIDAQAB";
        String data = "hello world!!!";
//        Charset charset = Charset.forName("utf-8");
//        String encryptData = RSAUtils.encryptByPublicKey(data, charset, publicKey);
        String encryptData = Md5Utils.getMd5Str(data + ",publicKey=" + publicKey);
        System.out.println("encryptData:");
        System.out.println(encryptData);

        String encryptData2 = Md5Utils.getMd5Str(data + ",publicKey=" + publicKey);

        boolean verifySuccess = encryptData.equalsIgnoreCase(encryptData2);
        System.out.println("verifySuccess=" + verifySuccess);


    }


    @Test
    public void verifySignTest() {

    }




}
