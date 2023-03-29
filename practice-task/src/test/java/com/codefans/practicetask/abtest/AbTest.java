package com.codefans.practicetask.abtest;

import com.codefans.reusablecode.bigdata.bloomfilter.MurmurHash;
import com.codefans.reusablecode.encode.MD5Utils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: codefans
 * @Date: 2023-03-27 11:42
 */

public class AbTest {


    @Test
    public void randomTest() {

        Random random = new Random();
        int resInt = 0;

        long experimentalPercent = 3;
        int experimentalGroup = 0;
        int controlGroup = 0;

        long loopCount = 0;
        while(true) {
            resInt = random.nextInt(10);
            if(resInt < experimentalPercent) {
                experimentalGroup ++;
            } else {
                controlGroup ++;
            }
            if(loopCount % 10000 == 0) {
                System.out.println("experimentalGroup=[" + experimentalGroup + "], controlGroup=[" + controlGroup + "], percent=[" + percent(experimentalGroup, controlGroup) + "]");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(loopCount == 100000000) {
                    break;
                }
            }
            loopCount++;
        }






    }

    @Test
    public void randomMurmurHashTest() {

        long resInt = 0;
        MurmurHash murmurHash = new MurmurHash();
        long experimentalPercent = 3;
        int experimentalGroup = 0;
        int controlGroup = 0;

        long loopCount = 0;
        while(true) {
            resInt = Math.abs(murmurHash.guavaMurmur3_32Hash(UUID.randomUUID().toString())%10);
//            System.out.println("resInt=" + resInt);
            if(resInt < experimentalPercent) {
                experimentalGroup ++;
            } else {
                controlGroup ++;
            }
            if(loopCount % 10000 == 0) {
                System.out.println("experimentalGroup=[" + experimentalGroup + "], controlGroup=[" + controlGroup + "], experimentalPercent=[" + percent(experimentalGroup, controlGroup) + "]");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(loopCount == 100000000) {
                    break;
                }
            }
            loopCount++;
        }






    }

    private BigDecimal percent(long expNum, long controlNum) {
        BigDecimal experimentNum = new BigDecimal(expNum);
        BigDecimal num = new BigDecimal(expNum + controlNum);
//        System.out.println("expNum=" + experimentNum + ", num=" + num);
        BigDecimal res = experimentNum.divide(num, 2, RoundingMode.HALF_DOWN);
//        System.out.println(res);
        return res;
    }

}
