package com.codefans.practicetask.redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisMovedDataException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: codefans
 * @Date: 2023-04-14 11:32
 */

public class RedisHelper {

    public static void main(String[] args) {

        RedisHelper redisHelper = new RedisHelper();
        String key = "18245457878";
//        String key = "App:Disc:20230414002-3-018112349874";
//        String clusterAddr = "10.18.1.76:7000,10.18.1.76:7001,10.18.1.76:7002,10.18.1.76:7003,10.18.1.76:7004,10.18.1.76:7005";
        String clusterAddr = "10.18.1.111:7000,10.18.1.111:7001,10.18.1.111:7002,10.18.1.111:7003,10.18.1.111:7004,10.18.1.111:7005";
        redisHelper.search(key, clusterAddr);

    }


    public void search(String key, String clusterAddr) {
        String storeAddr = "";
        String val = "";
        JedisCluster jedisCluster = this.jedisCluster(clusterAddr);

        AtomicInteger count = new AtomicInteger();

        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        Iterator<String> keyIter = clusterNodes.keySet().iterator();
        String clusterKey = null;

        while(keyIter.hasNext()) {
            clusterKey = keyIter.next();
            System.out.println("clusterKey=" + clusterKey);
        }
        for (Iterator<JedisPool> it = clusterNodes.values().iterator(); it.hasNext(); ) {
            JedisPool pool = it.next();
            Jedis jedis = null;
            try {
                jedis = pool.getResource();

                ScanParams scanParams = new ScanParams();
                scanParams.match("*" + key + "*");
                scanParams.count(1024);
                String scanRet = "0";
                int matchCount = 0;
                Client client = jedis.getClient();
                String redisAddr = client.getHost() + ":" + client.getPort();
                do {
                    ScanResult<String> result = jedis.scan(scanRet, scanParams);
                    scanRet = result.getStringCursor();
                    for (String keyStr : result.getResult()) {
                        try {
                            if (jedis.exists(keyStr)) { // && keyStr.equals(key)
                                matchCount++;
                                String keyVal = jedis.get(keyStr);
                                System.out.println(keyVal);
                                val = keyVal;
                            }
                        } catch (Exception e) {
                            if(e instanceof JedisMovedDataException) {
                                JedisMovedDataException movedDataException = (JedisMovedDataException) e;
                                String message = movedDataException.getMessage();
                                System.out.println(message);
                                String movedAddr = message.split(" ")[2];
                                System.out.println("current:" + redisAddr + ", moved:" + movedAddr);
                                JedisPool jedisPool = clusterNodes.get(movedAddr);
                                jedis = jedisPool.getResource();
                                break;
                            }
                        }
                    }
                } while (!scanRet.equals("0")) ;
                System.out.println("共从Redis[" + redisAddr + "]中获取到：" + matchCount + "条数据");
            } catch(Exception e){
                e.printStackTrace();
            } finally{
                if (null != jedis)
                    jedis.close();
            }
        }
        System.out.println(key + "=" + val);
    }

    public JedisCluster jedisCluster(String clusterAddr){

        int connectionTimeout = 3000;
        int soTimeout = 3000;


        int maxAttempts = 3;
        int minIdle = 30;
        int maxIdle = 30;
        int maxTotal = 50;

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);

        //获取redis集群的ip及端口号等相关信息；
        String[] serverArray = clusterAddr.split(",");
        Set<HostAndPort> nodes = new HashSet<>();

        //遍历add到HostAndPort中；
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        //构建对象并返回；
        return new JedisCluster(nodes, connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

}
