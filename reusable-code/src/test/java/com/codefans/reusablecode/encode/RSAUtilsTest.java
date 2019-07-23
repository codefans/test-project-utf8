package com.codefans.reusablecode.encode;

import com.codefans.reusablecode.util.CommonUtils;
import com.codefans.reusablecode.util.DateUtils;
import com.codefans.reusablecode.util.Md5Utils;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

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
    public void decryptByPrivateKeyTest() {

        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALB6ZZlh1OqoP1n3qSgXtMuDcPL+POPSHE3AYQH6tNlo6qyP2CyF4jZvkCg79w87jE8wJFtJSoWl45BZrq4PrSb9P2rNTk2W8IN9JUg9jtQuFYCa6zCCm/0Gn/HyQ2+VPWZyudTOMuT8cyXon5cjbP15NVrkVFp0gTQP/REBNJfvAgMBAAECgYAJWMIuyHatYvHQAwTrga3qpXCC/iIdctBa8dhxcWTIqvza3Nd3LDQZ6/i3mM1x+hZpT0RtrUkMIQgXahiNUXk7I+Q1WZhqoD9VbLzS/tvU8NcaEXX7Klp/0YpaXy62/J1S0RGQivPMunWX2qE3WOI8tjuSnrhZRtNRSXXca6xNQQJBANdskhVZHd1H4Pv6G5aIHGeYQwicCKtgFzsnTSRh0BQhmn5HC71P8iHS+zbJ8c/+cALBcyJSrDJ2sBgeqw67s48CQQDRt+iXFKm9M69oAAxMP3MPk4VdyvE89yVxCUghN4iwqDFDjuoR0e9eU5ZJBmYchAt5PAK67bGQZdCKjfEB+yWhAkANq78tiaVCiLA3bWzYxbR/woLmhfhq38M5psnXeDmbPXKvdtTA49Tq3pfAp1ooJ+51zk7/K53v6eZM8Y1Ldw/zAkEAykC3C51d5Z5G9+Gz+oTmjosS/9WMueMQNOdirMZGCTjr6d+WVgFE/I9YTKzjJXUjK5R4fZZmvH+0kys411RCgQJAHbSnfijRvpnc47fNcyZ8gIyy5VLqJ6b8QuYiitMd7ZCjI+bDI+UI5zW/bneQfgzQSYxtPgBCPt94xR8fuGazHw==";
        String encryptData = "Nc4uoGVvsr4X3itkaWxCtYTaX+4Bndg1UCs9glDK4dAtHs8HoOQ6Hl7AZvjKnXZ3f6xKhitzYMfQROeHzNkeLUepNwVX0vKFC+9+Vlw4enaVgWPdobGGFCLUWA78BcBPTm9fxQ/MeoubJOKi6yzsu201Q4WxEYzqmWjhtpUZXYM=";
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
