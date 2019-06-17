package com.codefans.opensource.redis;

/**
 * @author: codefans
 * @date: 2019-06-17 10:19:43
 * 单节点模式实现分布式锁
 * 注释：
 *    由于单节点模式，redis只有一个，且redis又是单线程，所以多个客户端的命令都得一个一个执行，就不会有并发的问题。
 * 但是如果是集群模式，虽然相同的key会路由到同一台redis里，但是集群间复制数据、或者主从切换、或者故障转移，新机器可能没有这个key，
 * 原来已经获取到的锁，也可能再次被其他客户端获取。所以集群模式下，需要配合乐观锁，才是最完善的解决方案。
 */
public class RedisSingleModeDistributedLock implements RedisDistributedLock {

    private JedisSingleClient redisSigleClient;

    public RedisSingleModeDistributedLock(JedisSingleClient redisSigleClient) {
        this.redisSigleClient = redisSigleClient;
    }
    /**
     *
     * @param key
     * @param value
     * @return
     * 存在的问题：
     *    如果加锁后，客户端crash了，锁无法释放。
     */
    @Override
    public boolean getLock(String key, String value) {
        if(redisSigleClient.setnx(key, value)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param key
     * @param expireTime
     * @return
     * 存在的问题：
     *    过期之前，客户端A加锁成功即setnx成功，
     *    客户端B、客户端C执行setnx失败却getSet成功了，
     *    这时客户端A、客户端B和客户端C都获取到了这把锁。
     */
    @Override
    public boolean getLockWithExpireTime(String key, int expireTime) {
        String totalKey = "keyPrefix_" + key;
        long currentTime = System.currentTimeMillis();
        String expireStr = String.valueOf(currentTime + expireTime*1000 + 1);
        if (redisSigleClient.setnx(totalKey, expireStr)) {
            //成功获取到锁
            return true;
        }

        String currentValueStr = redisSigleClient.getString(totalKey);
        //判断原来的锁是否已过期
        if (currentValueStr == null || Long.parseLong(currentValueStr) < currentTime) {
            String oldValueStr = redisSigleClient.getSet(totalKey, expireStr);
            if (oldValueStr == null || Long.parseLong(currentValueStr) < currentTime) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param key
     * @param value
     * @param expiredTime
     * @return
     * 推荐方案
     */
    @Override
    public boolean getLockWithNXEX(String key, String value, int expiredTime) {
        return redisSigleClient.set(key, value, NX, EX, expiredTime);
    }

    /**
     *
     * @param key
     * @param value
     * @param expiredTime
     * @return
     * 推荐方案
     */
    @Override
    public boolean getLockWithNXPX(String key, String value, int expiredTime) {
        return redisSigleClient.set(key, value, NX, PX, expiredTime);
    }

    /**
     *
     * @param key
     * @param value
     * @param expiredTime
     * @return
     * 推荐方案
     */
    @Override
    public boolean getLockWithXXEX(String key, String value, int expiredTime) {
        return redisSigleClient.set(key, value, XX, EX, expiredTime);
    }

    /**
     *
     * @param key
     * @param value
     * @param expiredTime
     * @return
     * 推荐方案
     */
    @Override
    public boolean getLockWithXXPX(String key, String value, int expiredTime) {
        return redisSigleClient.set(key, value, XX, PX, expiredTime);
    }

    /**
     *
     * @param key
     * 存在问题：
     *    只有key，没有客户端标识，会删除别的客户端获取到的锁。
     * 例如客户端A获取到锁后，业务代码执行较长的时间，此时客户端A获取到的锁已经过期并释放，
     * 然后被客户端B获取到锁，这时客户端A的业务代码执行完，来执行delete操作释放锁，
     * 就会将客户端B获得的锁给释放了。
     */
    @Override
    public void releaseLock(String key) {
        redisSigleClient.delete(key);
    }

    /**
     *
     * @param key
     * 存在问题：
     *    有key，也有客户端标识，但是get和del不是原子操作，所以还是会删除别的客户端获取到的锁。
     * 例如客户端A获取到锁后，因为网络或者虚拟机卡顿等原因需要较长的时间采取执行del，
     * 此时客户端A获取到的锁已经过期并释放，然后被客户端B获取到锁，
     * 这时客户端A又执行del操作释放锁，就会将客户端B获得的锁给释放了。
     */
    @Override
    public void releaseLock(String key, String value) {
        redisSigleClient.delete(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * 推荐方案
     */
    @Override
    public void releaseLockUsingEvalLua(String key, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        redisSigleClient.deleteUsingEvalLua(key, value, script);
    }
}
