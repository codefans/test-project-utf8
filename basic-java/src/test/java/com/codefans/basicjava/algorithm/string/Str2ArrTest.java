package com.codefans.basicjava.algorithm.string;

import org.junit.Test;

import static com.codefans.basicjava.util.CommonUtils.print;

/**
 * @author: codefans
 * @date: 2019-07-08 10:26
 */
public class Str2ArrTest {

    @Test
    public void str2arrTest() {

        Str2Arr str2Arr = new Str2Arr();

        String str = "[LoanManageInterfacesImpl.loanSupply() param=LoanSupplyDTO[productNo=P1907030044,productName=测试c,productVersion=P1907030044-4,productInstanceId=345,customerNo=C190703000037,customerName=测试07,contractNo=LF03-20190703-000011,iouNo=LF03-20190703-000011-1,currency=CNY,contractAmount=150000,paymentAmount=60000,loanNo=L190703000028,lenderDate=Tue Jul 02 00:00:00 CST 2019,maturityDate=Fri Aug 02 00:00:00 CST 2019,paymentTime=2019-07-08 00:00:00]]";
//        String[] arr = str2Arr.str2arrByJava(str);
//        print(arr);

//        str = "<?xml version='1.0' encoding='UTF-8'?><ufinterface billtype='gl' filename='e:\1.xml' isexchange='Y' proc='add' receiver='1060337@1060337-003' replace='Y' roottag='sendresult' sender='01' successful='Y'><sendresult><billpk></billpk><bdocid>w764</bdocid><filename>e:\1.xml</filename><resultcode>1</resultcode><resultdescription>单据w764开始处理...单据w764处理完毕!</resultdescription><content>2017.09-记账凭证-1</content></sendresult><sendresult><billpk></billpk><bdocid>w1007</bdocid><filename>e:\1.xml</filename><resultcode>1</resultcode><resultdescription>单据w1007开始处理...单据w1007处理完毕!</resultdescription><content>2017.10-记账凭证-1</content></sendresult><sendresult><billpk></billpk><bdocid>w516</bdocid><filename>e:\1.xml</filename><resultcode>1</resultcode><resultdescription>单据w516开始处理...单据w516处理完毕!</resultdescription><content>2017.07-记账凭证-50</content></sendresult></ufinterface>";
        //String str = "abc3443abcfgjhgabcgfjabc";
//        String regex = "<bdocid>(.*?)</bdocid>";
        String regex = "productNo=(.*?)?(?=\\])";

        str2Arr.str2arrByRegex(str, regex);

    }



}
