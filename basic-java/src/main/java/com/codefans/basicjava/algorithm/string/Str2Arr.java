package com.codefans.basicjava.algorithm.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: codefans
 * @date: 2019-07-08 10:26
 */
public class Str2Arr {

    /**
     * [LoanManageInterfacesImpl.loanSupply() param=LoanSupplyDTO[productNo=P1907030044,productName=测试c,productVersion=P1907030044-4,productInstanceId=345,customerNo=C190703000037,customerName=测试07,contractNo=LF03-20190703-000011,iouNo=LF03-20190703-000011-1,currency=CNY,contractAmount=150000,paymentAmount=60000,loanNo=L190703000028,lenderDate=Tue Jul 02 00:00:00 CST 2019,maturityDate=Fri Aug 02 00:00:00 CST 2019,paymentTime=2019-07-08 00:00:00]]
     * @param str
     * @return
     */
    public String[] str2arrByJava(String str) {
        String[] arr = null;
        if(str != null && str.length() > 0) {
            String prefix = "[LoanManageInterfacesImpl.loanSupply() param=LoanSupplyDTO[";
            String suffix = "]]";
            if(str.startsWith(prefix) && str.endsWith(suffix)) {
                str = str.substring(str.indexOf(prefix) + prefix.length(), str.indexOf(suffix));
                System.out.println("str:");
                System.out.println(str);
                arr = str.split(",");
            }
        }
        return arr;
    }

    public String[] str2arrByRegex(String str, String regex) {
        String[] arr = null;
//        String regex = ".*?(?=\\[).*?(?=\\])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
        return arr;
    }

}
