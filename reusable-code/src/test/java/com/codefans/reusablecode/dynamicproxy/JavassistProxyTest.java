package com.codefans.reusablecode.dynamicproxy;

import com.codefans.reusablecode.dynamicproxy.asm.AsmProxy;
import com.codefans.reusablecode.dynamicproxy.javassist.JavassistProxy;
import javassist.util.proxy.MethodHandler;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: codefans
 * @date: 2019-06-25 15:20
 */
public class JavassistProxyTest extends BaseTest {

    @Test
    public void proxyTest() {

        CountService service = new CountServiceImpl();

        try {
            long time = System.currentTimeMillis();
            CountService javassistProxy = (CountService) JavassistProxy.newProxyInstance(new Class[]{CountService.class}, new JavaAssitInterceptor(service));
            time = System.currentTimeMillis() - time;
            System.out.println("Create JAVASSIST Proxy: " + time + " ms");
            System.out.println("================");

            for (int i = 0; i < 3; i++) {
                test(javassistProxy, "Run JAVASSIST Proxy: ");
                System.out.println("----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class JavaAssitInterceptor implements MethodHandler {

        final Object delegate;

        JavaAssitInterceptor(Object delegate) {
            this.delegate = delegate;
        }

        public Object invoke(Object self, Method m, Method proceed,
                             Object[] args) throws Throwable {
            return m.invoke(delegate, args);
        }
    }



}
