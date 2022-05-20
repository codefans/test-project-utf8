package com.codefans.reusablecode.encode;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.function.Function;

/**
 * @Author: codefans
 * @Date: 2022-05-13 22:51
 */

public class EncoderPerformanceCompare {

    public static void main(String[] args) {
        EncoderPerformanceCompare epc = new EncoderPerformanceCompare();
//        epc.smallSingle();
        epc.smallMulti();
//        epc.smallMultiFunctionProgramming();
//        epc.bigFilePerformance();
    }

    public void smallSingle() {
        try {
            String content = "https://www.baidu.com/s?wd=idea&rsv_spt=1&rsv_iqid=0xc8a07b1900097512&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=4&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&inputT=724&rsv_sug4=725";

            long beginTime = System.currentTimeMillis();
            String javaMD5Result = MD5Utils.md5(content);
            System.out.println("Java MD5 result=" + javaMD5Result + ", len=" + javaMD5Result.length() + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

            beginTime = System.currentTimeMillis();
            String apacheMD5Result = MD5Utils.textApacheMD5(content);
            System.out.println("Apache MD5 result=" + apacheMD5Result + ", len=" + apacheMD5Result.length() + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

            beginTime = System.currentTimeMillis();
            String javaSHA256Result = SHA256Utils.sha256UsingJava(content);
            System.out.println("Java SHA256 result=" + javaSHA256Result + ", len=" + javaSHA256Result.length() + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

            beginTime = System.currentTimeMillis();
            String apacheSHA256Result = SHA256Utils.sha256ApacheEncode(content);
            System.out.println("Apache SHA256 result=" + apacheSHA256Result + ", len=" + apacheSHA256Result.length() + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void smallMulti() {
        try {
            String content = "https://www.baidu.com/s?wd=idea&rsv_spt=1&rsv_iqid=0xc8a07b1900097512&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=4&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&inputT=724&rsv_sug4=725";
            int loopCount = 1000000;
            int bound = 999999;

            long beginTime = System.currentTimeMillis();
            Random random = new Random();
            for(int i = 0; i < loopCount; i ++) {
                MD5Utils.md5(content + random.nextInt(bound));
            }
            System.out.println("Java MD5, loopCount=" + loopCount + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

            beginTime = System.currentTimeMillis();
            for(int i = 0; i < loopCount; i ++) {
                MD5Utils.textApacheMD5(content + random.nextInt(bound));
            }
            System.out.println("Apache MD5, loopCount=" + loopCount + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

            beginTime = System.currentTimeMillis();
            for(int i = 0; i < loopCount; i ++) {
                SHA256Utils.sha256UsingJava(content + random.nextInt(bound));
            }
            System.out.println("Java SHA256, loopCount=" + loopCount + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

            beginTime = System.currentTimeMillis();
            for(int i = 0; i < loopCount; i ++) {
                SHA256Utils.sha256ApacheEncode(content+random.nextInt(bound));
            }
            System.out.println("Apache SHA256, loopCount=" + loopCount + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void smallMultiFunctionProgramming() {
        try {
            String content = "https://www.baidu.com/s?wd=idea&rsv_spt=1&rsv_iqid=0xc8a07b1900097512&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=4&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&inputT=724&rsv_sug4=725";
            int loopCount = 10000;
            mainLoop(input->MD5Utils.md5(input), loopCount, "JavaMD5", content);

            mainLoop(text -> {
                try {
                    return MD5Utils.textApacheMD5(text);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }, loopCount, "ApacheMD5", content);

            mainLoop(text -> {
                try {
                    return SHA256Utils.sha256UsingJava(text);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, loopCount, "JavaSHA256", content);

            mainLoop(text -> {
                try {
                    return SHA256Utils.sha256ApacheEncode(text);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, loopCount, "ApacheSHA256", content);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void mainLoop(Function<String, String> callback, int loopCount, String encodeMethod, String param) {
        long beginTime = System.currentTimeMillis();
        Random random = new Random();
        for(int i = 0; i < loopCount; i ++) {
            String result = callback.apply(param + random.nextInt(9999999));
//            System.out.println("result=" + result + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");
        }
        System.out.println("签名算法:[" + encodeMethod + "], 签名次数:[" + loopCount + ", cost:[" + (System.currentTimeMillis() - beginTime) + "ms]");
    }

    public void bigFilePerformance() {

    }
}
