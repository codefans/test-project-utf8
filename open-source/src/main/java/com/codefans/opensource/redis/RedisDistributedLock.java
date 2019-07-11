package com.codefans.opensource.redis;

/**
 * @author: codefans
 * @date: 2019-06-17 10:34:22
 * Redis分布式锁
 */
public interface RedisDistributedLock {

    final static String NX = "NX";
    final static String XX = "XX";
    /**
     * 秒
     */
    final static String EX = "EX";
    /**
     * 毫秒
     */
    final static String PX = "PX";

    public boolean getLock(String key, String value);

    public boolean getLockWithExpireTime(String key, int expiredTime);

    public boolean getLockWithNXEX(String key, String value, int expiredTime);

    public boolean getLockWithNXEXLock(String key, String value, int expiredTime);

    public boolean getLockWithNXPX(String key, String value, int expiredTime);

    public boolean getLockWithXXEX(String key, String value, int expiredTime);

    public boolean getLockWithXXPX(String key, String value, int expiredTime);

    public void releaseLock(String key);

    public void releaseLock(String key, String value);

    public void releaseLockUsingEvalLua(String key, String value);

    public void releaseLockUsingEvalLuaConcurrency(String key, String value);

}
