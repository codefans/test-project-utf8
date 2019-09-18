package com.codefans.interview.bigdata.dulplicatephone;

import java.io.*;
import java.util.Random;

/**
 * @author: codefans
 * @date: 2019-09-11 14:33
 */
public class PhoneGenerator {

    public static String outFilePath = "/data/phoneNos.txt";
//    public static int phoneNums = 100000000;
//    public static int phoneNums = 10000;
//    public static int phoneNums = 100000;
//    public static int phoneNums = 2000000; //200万
    public static int phoneNums = 1000000000; //10亿

    private BufferedWriter bw;

    private String[] phonePrefix = new String[]{
        "139",
        "138",
        "137",
        "136",
        "135",
        "134",
        "178",
        "170",
        "188",
        "187",
        "183",
        "182",
        "159",
        "158",
        "157",
        "152",
        "150",
        "147",
        "186",
        "185",
        "170",
        "156",
        "155",
        "130",
        "131",
        "132",
        "189",
        "180",
        "170",
        "153",
        "133",
        "199",
        "198",
        "166",
    };
    private String[] phoneSuffix = new String[]{
            "00000000",
            "11111111",
            "22222222",
            "33333333",
            "44444444",
            "55555555",
            "66666666",
            "77777777",
            "88888888",
            "99999999",
            "11112222",
            "22223333",
            "33334444",
            "44445555",
            "55556666",
            "66667777",
            "77778888",
            "88889999",
            "12345555",
            "23456666",
            "66668888",
    };

    private Random random = new Random();
    private int phoneMaxSuffix = 99999999;

    public PhoneGenerator(String outFilePath, int phoneNums) throws FileNotFoundException {
        PhoneGenerator.outFilePath = outFilePath;
        PhoneGenerator.phoneNums = phoneNums;
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFilePath))));
    }

    public void generate() {
        String phoneNo = "";
        try {
            for(int i = 0; i < phoneNums; i ++) {
                phoneNo = getPhonePrefix() + getPhoneSuffix();
                bw.write(phoneNo);
                if(i != phoneNums - 1) {
                    bw.write("\n");
                }
            }
            System.out.println("total phoneNo:[" + phoneNums + "]");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(bw);
        }
    }


    public String getPhonePrefix() {
        int len = phonePrefix.length;
        int index = random.nextInt(len);
        return phonePrefix[index];
    }

    public String getPhoneSuffix() {
        String phoneSuffixStr = "";
        int suffixInt = generateInt(phoneMaxSuffix);
        if(suffixInt%9==0) {
            int len = phoneSuffix.length;
            int index = random.nextInt(len);
            phoneSuffixStr = phoneSuffix[index];
        } else {
            String suffixStr = String.valueOf(suffixInt);
            if (suffixStr.length() < 8) {
                phoneSuffixStr = appendToLen(suffixStr, 8);
            } else {
                phoneSuffixStr = suffixStr;
            }
        }
        return phoneSuffixStr;
    }

    /**
     * 如果字符串str的长度小于len,用随机数补足长度
     * @param str
     * @param len
     * @return
     */
    public String appendToLen(String str, int len) {
        if(str.length() < len) {
            int appendLen = len - str.length();
            for(int i = 0; i < appendLen; i ++) {
                str = str + generateInt(9);
            }
        }
        return str;
    }

    public int generateInt(int max) {
        return random.nextInt(max);
    }

    public void close(Writer writer) {
        try {
            if(writer != null) {
                writer.flush();
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            PhoneGenerator phoneGenerator = new PhoneGenerator(outFilePath, phoneNums);
            phoneGenerator.generate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setPhonePrefix(String[] phonePrefix) {
        this.phonePrefix = phonePrefix;
    }
}
