package com.codefans.opensource.redis.sharding;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: codefans
 * @date: 2019-07-11 09:21
 */
public class ShardedJedisTemplate {

    private JedisPool jedisPool;
    public ShardedJedisTemplate(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     *
     * @param key
     * @param callback
     * @param rw
     * @param <R>
     * @return
     *
     * 如果不是这种形式，常规的代码如下：
     * public String set(String key, String value) {
     *     Jedis jedis = null;
     *     String result = "";
     *     try {
     *         jedis = jedisPool.getResource();
     *         result = jedis.set(key, value);
     *     } catch (Exception e) {
     *         e.printStackTrace();
     *     } finally {
     *         if (jedis != null) {
     *             jedis.close();
     *         }
     *     }
     *     return result;
     * }
     * 所以这种的好处：可以省去每次调用时申请资源、释放资源的代码
     *
     */
    public <R> R execute(String key, TaskCallback<R> callback, RW rw){
        Jedis jedis = null;
        R result = null;
        try{
            if(key == null || key.trim().length() == 0){
                throw new IllegalArgumentException("key set to redis can't be null!");
            }
            jedis = jedisPool.getResource();
            //执行回调逻辑，获取执行结果。
            result = callback.call(jedis);
        }catch(Throwable e){
            e.printStackTrace();
        }finally{
            /**
             * 回收jedis
             * 参考JedisPool.returnBrokenResource()方法源码说明
             */
            jedis.close();
        }
        return result;
    }

}
