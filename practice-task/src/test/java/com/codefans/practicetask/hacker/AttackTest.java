package com.codefans.practicetask.hacker;

import com.codefans.reusablecode.util.DateUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author: codefans
 * @date: 2019-08-06 13:55
 */
public class AttackTest {

    @Test
    public void attachTest() {


    }

    @Test
    public void printUnicode() {

        String[] unicodeArr = new String[]{
                "\u9648\u9e4f\u9716",
                "\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801",
                "\u8f93\u5165\u9a8c\u8bc1\u7801\u9519\u8bef",
                "\u6bcf\u4eba\u6bcf\u65e5\u53ea\u80fd\u62951\u7968\uff0c\u660e\u5929\u518d\u6765\u5427",
                "\u6bcf\u4eba\u6bcf\u65e5\u53ea\u80fd\u62951\u7968\uff0c\u660e\u5929\u518d\u6765\u5427"
        };
        String unicode = "";
        for(int i = 0; i < unicodeArr.length; i ++) {
            unicode = unicodeArr[i];
            System.out.println(unicode);
        }

    }

    @Test
    public void unicodeNameDecodeTest() throws UnsupportedEncodingException {
        String[] unicodeArr = new String[]{
            "\u9648\u9e4f\u9716",
            "\u9648\u9e4f\u9716",
            "\u5f90\u81f4\u8fdc",
            "\u5e94\u5b87\u70e8",
            "\u5085\u7ae0\u7118"
        };
        String unicode = "";
        for(int i = 0; i < unicodeArr.length; i ++) {
            unicode = unicodeArr[i];
            System.out.println(unicode);
//            System.out.println("filterChar=" + this.filterChar(unicode));
//            String decodeName = this.decodeUnicodeName(unicode);
//            System.out.println("unicode=" + unicode + ", decodeName=" + decodeName);
        }
    }

    @Test
    public void timestampTest() {

        /**
         * 1565056774 - 这个长度的时间, 不包含毫秒, 后面加3个0, 就是完整的时间了
         */
        long[] timestampArr = new long[]{
            1565066362,1565081613,1565094138,1565147330,1565158448
        };


        long timestamp = 0L;
        for(int i = 0; i < timestampArr.length; i ++) {
            timestamp = timestampArr[i];
            if(String.valueOf(timestamp).length() == 10) {
                timestamp = Long.parseLong(timestamp + "000");
            }
            System.out.println("timestamp=" + timestamp + ", format=" + DateUtils.formatYYYYMMDDHHMMSS_SSS(timestamp));

        }

    }

    public String filterChar(String source) {
        char[] chars = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isFirst = false;
        char c = ' ';

        for(int i = 0; i < chars.length; i ++) {
            c = chars[i];
            if(c == '\\') {
                if(!isFirst) {
                    sb.append(c);
                    isFirst = true;
                } else {
                    isFirst = false;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeUnicodeName(String unicodeName) throws UnsupportedEncodingException {
        return new String(unicodeName.getBytes("utf-8"), "utf-8");
    }

}
