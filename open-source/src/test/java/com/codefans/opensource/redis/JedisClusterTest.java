package com.codefans.opensource.redis;

import com.codefans.basicjava.concurrent.threadpool.DefaultThreadPool;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.*;

/**
 * @author: codefans
 * @date: 2018-05-06 16:41
 */
public class JedisClusterTest extends JedisClientBase {

    JedisCluster jedisCluster;
    
    @Before
    public void before() {
        this.initLocalEnv();
//        this.initDevEnv();
//        this.initTestEnv();
    }

    public void initLocalEnv() {
        host = "127.0.0.1";
        port = 3793;
        password = "redisPass123";
        connectionTimeout = 10000;
        soTimeout = 10000;

//        jedis = new Jedis(host, port, connectionTimeout, soTimeout);
//        jedis.auth(password);

        maxAttempts = 3;
        poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);


        HostAndPort hostAndPort = new HostAndPort(host, port);
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        hostAndPortSet.add(hostAndPort);
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3794));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3795));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3796));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3797));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3798));

        jedisCluster = new JedisCluster(hostAndPortSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);

        System.out.println("cluster.size():" + jedisCluster.getClusterNodes().size());

    }

    public void initDevEnv() {
        host = "10.60.58.139";
        port = 6379;
        password = "Lsjrxd";
        connectionTimeout = 10000;
        soTimeout = 10000;

//        jedis = new Jedis(host, port, connectionTimeout, soTimeout);
//        jedis.auth(password);

        maxAttempts = 3;
        poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);


        HostAndPort hostAndPort = new HostAndPort(host, port);
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
//        hostAndPortSet.add(hostAndPort);
        hostAndPortSet.add(new HostAndPort(host, 6000));
        hostAndPortSet.add(new HostAndPort(host, 6001));

        jedisCluster = new JedisCluster(hostAndPortSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);

        System.out.println("cluster.size():" + jedisCluster.getClusterNodes().size());

    }

    public void initTestEnv() {

        maxAttempts = 3;
        poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);


        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        hostAndPortSet.add(new HostAndPort("10.60.54.227", 6479));
        hostAndPortSet.add(new HostAndPort("10.60.54.229", 6379));

        jedisCluster = new JedisCluster(hostAndPortSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);

        System.out.println("cluster.size():" + jedisCluster.getClusterNodes().size());

    }


    @Test
    public void setGetTest() {

        String key = "key0001";
        String value = "value0001";

        jedisCluster.set(key, value);

        value = jedisCluster.get(key);
        System.out.println("value:" + value);


    }

    @Test
    public void jedisClusterInMultiThreadEnvTest() {

        final String key = "jedisClusterSetTestKey";
        final String value = "jedisClusterSetTestKey_value";
        final String nxxx = "NX";
        final String expx = "EX";
        final int timeout = 60;

        int threadNums = 10;

//        ReentrantLock lock = new ReentrantLock();

        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        Runnable task = new Runnable() {
            @Override
            public void run() {
//                lock.lock();
//                try {
                String newKey = key + System.currentTimeMillis();
                    String result = jedisCluster.set(newKey, value, nxxx, expx, timeout);
                    System.out.println("key=" + newKey + ", result=" + result + ", redisAddr=" + RedisContext.getAddr());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
            }
        };

//        for(int i = 0; i < threadNums; i ++) {
//            defaultThreadPool.execute(task);
//        }

        defaultThreadPool.submit(threadNums, task);


    }

    /**
     * 字符串操作
     */
    @Test
    public void stringOperations() {
        System.out.println("=== 字符串操作 ===");

        // 设置值
        jedisCluster.set("user:1:name", "张三");
        jedisCluster.set("user:1:age", "25");

        //修改值
        jedisCluster.set("user:1:age", "26");
        System.out.println("将年龄改成26岁");

        // 获取值
        String name = jedisCluster.get("user:1:name");
        String age = jedisCluster.get("user:1:age");
        System.out.println("姓名: " + name + ", 年龄: " + age);

        // 原子递增
        jedisCluster.incr("counter");
        Long counter = Long.parseLong(jedisCluster.get("counter"));
        System.out.println("计数器: " + counter);

        // 设置带过期时间的值
        jedisCluster.setex("temp_key", 60, "临时数据");

        // 删除键
        jedisCluster.del("user:1:age");
        System.out.println("删除后的年龄: " + jedisCluster.get("user:1:age"));
    }

    /**
     * Hash操作
     */
    @Test
    public void hashOperations() {
        System.out.println("\n=== Hash操作 ===");

        // 设置Hash值
//		Map<String, String> user = new HashMap<>();
//		user.put("name", "李四");
//		user.put("age", "30");
//		user.put("city", "北京");
//		jedisCluster.hmset("user:2", user);

        jedisCluster.hset("user:2", "name", "李四");
        jedisCluster.hset("user:2", "age", "30");
        jedisCluster.hset("user:2", "city", "北京");

        //修改字段
        jedisCluster.hset("user:2", "age", "35");
        System.out.println("将年龄改成35岁");

        // 获取单个字段
        String userName = jedisCluster.hget("user:2", "name");
        System.out.println("用户姓名: " + userName);

        // 获取所有字段
        Map<String, String> userInfo = jedisCluster.hgetAll("user:2");
        System.out.println("用户信息: " + userInfo);

        // 删除字段
        jedisCluster.hdel("user:2", "city");
        System.out.println("删除city后的用户信息: " + jedisCluster.hgetAll("user:2"));
    }

    /**
     * List操作
     */
    @Test
    public void listOperations() {
        System.out.println("\n=== List操作 ===");

        // 从左侧添加元素
        jedisCluster.lpush("tasks", "task1", "task2", "task3");

        // 获取列表长度
        Long length = jedisCluster.llen("tasks");
        System.out.println("任务列表长度: " + length);

        // 获取列表所有元素
        List<String> tasks = jedisCluster.lrange("tasks", 0, -1);
        System.out.println("所有任务: " + tasks);

        // 从右侧弹出元素
        String rTask = jedisCluster.rpop("tasks");
        System.out.println("右侧弹出的任务: " + rTask);

        // 从左侧弹出元素
        String lTask = jedisCluster.lpop("tasks");
        System.out.println("左侧弹出的任务: " + lTask);

        // 获取更新后的列表
        System.out.println("更新后的任务列表: " + jedisCluster.lrange("tasks", 0, -1));
    }

    /**
     * Set操作
     */
    @Test
    public void setOperations() {
        System.out.println("\n=== Set操作 ===");

        // 添加元素到集合
        jedisCluster.sadd("tags:post:1", "Java", "Redis", "编程");

        // 获取集合所有元素
        Set<String> tags = jedisCluster.smembers("tags:post:1");
        System.out.println("文章标签: " + tags);

        // 检查元素是否存在
        boolean exists = jedisCluster.sismember("tags:post:1", "Redis");
        System.out.println("Redis标签是否存在: " + exists);

        // 删除元素
        jedisCluster.srem("tags:post:1", "编程");
        System.out.println("删除后的标签: " + jedisCluster.smembers("tags:post:1"));

    }

    /**
     * Sorted Set操作
     */
    @Test
    public void sortedSetOperations() {
        System.out.println("\n=== Sorted Set操作 ===");

        // 添加元素到有序集合
        jedisCluster.zadd("rank:scores", 95, "张三");
        jedisCluster.zadd("rank:scores", 88, "李四");
        jedisCluster.zadd("rank:scores", 92, "王五");

        // 获取指定范围内的元素(按分数从小到大)
        Set<String> topStudents = jedisCluster.zrange("rank:scores", 0, -1);
        System.out.println("所有学生(按分数排序): " + topStudents);

        // 获取指定范围内的元素(按分数从大到小)
        Set<String> topStudentsDesc = jedisCluster.zrevrange("rank:scores", 0, 1);
        System.out.println("前两名学生: " + topStudentsDesc);

        // 获取元素的分数
        Double score = jedisCluster.zscore("rank:scores", "张三");
        System.out.println("张三的分数: " + score);

        // 获取元素的排名(从0开始)
        Long rank = jedisCluster.zrank("rank:scores", "李四");
        System.out.println("李四的排名: " + (rank + 1));

        jedisCluster.zrem("rank:scores", "王五");
        System.out.println(jedisCluster.zrange("rank:scores", 0, -1));
    }

    /**
     * 分布式锁实现 (使用Lua脚本)
     */
    @Test
    public void distributedLockWithLua() {
        System.out.println("\n=== 分布式锁操作 ===");

        String lockKey = "product:1001:lock";
        String requestId = UUID.randomUUID().toString();
        int expireTime = 10; // 锁过期时间(秒)

        // 使用Lua脚本实现原子性的获取锁操作
        String lockScript =
                "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then " +
                        "   redis.call('expire', KEYS[1], ARGV[2]) " +
                        "   return 1 " +
                        "else " +
                        "   return 0 " +
                        "end";

        // 执行Lua脚本获取锁
        Object result = jedisCluster.eval(lockScript, Collections.singletonList(lockKey),
                Arrays.asList(requestId, String.valueOf(expireTime)));

        if (result instanceof Long && (Long) result == 1) {
            try {
                // 获取锁成功，执行业务逻辑
                System.out.println("获取锁成功，开始执行业务逻辑");
                // 模拟业务处理
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 释放锁
                String unlockScript =
                        "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                                "   return redis.call('del', KEYS[1]) " +
                                "else " +
                                "   return 0 " +
                                "end";

                jedisCluster.eval(unlockScript, Collections.singletonList(lockKey),
                        Collections.singletonList(requestId));
                System.out.println("业务逻辑执行完毕，释放锁");
            }
        } else {
            System.out.println("获取锁失败，稍后重试");
        }
    }

    /**
     * 事务操作 (单节点事务)
     */
    @Test
    public void transactionOperations() {
        System.out.println("\n=== 事务操作 ===");

        // 确保所有键在同一个槽位中 - 使用Hash Tag
        String key1 = "{transaction}:balance:user1";
        String key2 = "{transaction}:balance:user2";

        // 设置初始值
        jedisCluster.set(key1, "100");
        jedisCluster.set(key2, "200");

        // 获取键所在的节点连接
        HostAndPort targetNode = null;
        try {
            // 注意：这里需要通过反射或其他方式获取JedisClusterInfoCache
            // 下面代码仅为示例，实际实现可能需要根据Jedis 2.9.3源码调整
            // Field cacheField = JedisCluster.class.getDeclaredField("cache");
            // cacheField.setAccessible(true);
            // JedisClusterInfoCache cache = (JedisClusterInfoCache) cacheField.get(jedisCluster);
            // targetNode = cache.getSlotHostMap().get(JedisClusterCRC16.getSlot(key1));

            // 简化示例：假设我们知道节点位置
            targetNode = new HostAndPort("127.0.0.1", 7000);

            // 从节点获取连接
            try (Jedis jedis = new Jedis(targetNode.getHost(), targetNode.getPort())) {
                // 开启事务
                jedis.watch(key1, key2);

                // 检查余额
                int balance1 = Integer.parseInt(jedis.get(key1));
                if (balance1 >= 50) {
                    // 开始事务
                    Transaction transaction = jedis.multi();
                    transaction.decrBy(key1, 50);
                    transaction.incrBy(key2, 50);

                    // 执行事务
                    List<Object> results = transaction.exec();

                    if (results != null) {
                        System.out.println("转账成功: " + results);
                    } else {
                        System.out.println("转账失败，数据已被修改");
                    }
                } else {
                    System.out.println("余额不足");
                }
            }
        } catch (Exception e) {
            System.err.println("事务执行异常: " + e.getMessage());
        }

        // 查看转账后的余额
        System.out.println("User1余额: " + jedisCluster.get(key1));
        System.out.println("User2余额: " + jedisCluster.get(key2));
    }

}
