package com.codefans.opensource.redis;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-17 12:28:07
 */
public class JedisSingleClientTest {

    private JedisSingleClient jedisSingleClient;

    /**
     * 如果不存在，则设置值
     */
    private final static String NX = "NX";
    /**
     * 如果存在，则设置值
     */
    private final static String XX = "XX";
    /**
     * 过期时间单位为：秒
     */
    private final static String EX = "EX";
    /**
     * 过期时间单位为：毫秒
     */
    private final static String PX = "PX";

    @Before
    public void before() {

        String redisHost = "127.0.0.1";
        int port = 6379;
        String password = "redisPass123";
        jedisSingleClient = new JedisSingleClient(redisHost, port);
        jedisSingleClient.setAuth(password);

    }

    @Test
    public void getTest() {
        String key = "setWithNXAndEXAndExpiredTime";
        String value = jedisSingleClient.get(key);
        System.out.println("value=" + value);

    }

    @Test
    public void setTest() {
        String key = "setWithNXAndEXAndExpiredTime";
        String value = "setWithNXAndEXAndExpiredTime_value";
        String returnObj = jedisSingleClient.set(key, value);
        System.out.println("returnObj=" + returnObj);

    }

    @Test
    public void setnxTest() {

        String key = "setnxTest";
        String value = "setnxTestValue_" + System.currentTimeMillis();
        boolean setnxSuccess = jedisSingleClient.setnx(key, value);
        System.out.println("setnxSuccess=" + setnxSuccess);

    }

    @Test
    public void setNXXXTest() {

        String key = "setWithNXAndEXAndExpiredTime";
        String value = "setWithNXAndEXAndExpiredTime_value";
        String nxxx = NX;
//        String nxxx = XX;
        /**
         * 秒
         */
        String expx = EX;
        /**
         * 毫秒
         */
//        String expx = PX;
        int expiredTime = 10;
        int threadNums = 10;
        for(int i = 0; i < threadNums; i ++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        boolean setWithNXAndEXExpiredTime = jedisSingleClient.set(key, value, nxxx, expx, expiredTime);
                        System.out.println("setWithNXAndEXExpiredTime=" + setWithNXAndEXExpiredTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(50 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteTest() {
        String key = "setWithNXAndEXAndExpiredTime";
        long deleteReturnLong = jedisSingleClient.delete(key);
        System.out.println("deleteReturnLong=" + deleteReturnLong);

    }

    @Test
    public void deleteUsingEvalLuaTest() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        String key = "setWithNXAndEXAndExpiredTime";
        String value = "setWithNXAndEXAndExpiredTime_value";
        Object deleteReturnObj = jedisSingleClient.deleteUsingEvalLua(key, value, script);
        System.out.println("deleteReturnObj=" + deleteReturnObj);
    }

}
