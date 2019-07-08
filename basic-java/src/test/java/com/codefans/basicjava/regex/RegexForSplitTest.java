package com.codefans.basicjava.regex;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-07-08 11:00
 */
public class RegexForSplitTest {

    private RegexForSplit regexForSplit;

    @Before
    public void before() {
        regexForSplit = new RegexForSplit();
    }

    @Test
    public void splitTest() {

        String text = "北京市(海淀区)(朝阳区)(西城区)";
        String regex = ".*?(?=\\()";
        String result = regexForSplit.split(text, regex);
        System.out.println("result:");
        System.out.println("  " + result);

        text = "[LoanManageInterfacesImpl.loanSupply() param=LoanSupplyDTO[productNo=P1907030044,productName=测试c,productVersion=P1907030044-4,productInstanceId=345,customerNo=C190703000037,customerName=测试07,contractNo=LF03-20190703-000011,iouNo=LF03-20190703-000011-1,currency=CNY,contractAmount=150000,paymentAmount=60000,loanNo=L190703000028,lenderDate=Tue Jul 02 00:00:00 CST 2019,maturityDate=Fri Aug 02 00:00:00 CST 2019,paymentTime=2019-07-08 00:00:00]]";
        regex = "productNo=(.*?)?(?=\\])";
        result = regexForSplit.split(text, regex);
        System.out.println("result:");
        System.out.println("  " + result);

    }

}
