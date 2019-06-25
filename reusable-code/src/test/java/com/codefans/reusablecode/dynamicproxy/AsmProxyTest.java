package com.codefans.reusablecode.dynamicproxy;

import com.codefans.reusablecode.dynamicproxy.asm.AsmProxy;
import org.apache.poi.ss.formula.functions.Count;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author: codefans
 * @date: 2019-06-25 15:11
 */
public class AsmProxyTest extends BaseTest {

    @Test
    public void proxyTest() {

        CountService service = new CountServiceImpl();

        try {
            long time = System.currentTimeMillis();
            CountService asmBytecodeProxy = (CountService) AsmProxy.newProxyInstance(service, CountService.class, "count");
            time = System.currentTimeMillis() - time;
            System.out.println("Create ASM Proxy: " + time + " ms");
            System.out.println("================");

            for (int i = 0; i < 3; i++) {
                test(asmBytecodeProxy, "Run ASM Bytecode Proxy: ");
                System.out.println("----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
