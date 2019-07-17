package com.codefans.opensource.redis.cluster;

import com.codefans.reusablecode.util.IOUtils;
import redis.clients.util.JedisClusterCRC16;
import redis.clients.util.SafeEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;

/**
 * @author: codefans
 * @date: 2019-07-11 11:37
 */
public class JedisClusterNodeRoute {

    /**
     * redis集群共用16384个哈希槽, 哈希槽下标范围:0~16383
     */
    private static int total_slot = 16384;

    public static int getSlot(String key) {
        byte[] keyBytes = SafeEncoder.encode(key);
        return JedisClusterCRC16.getSlot(keyBytes);
    }

    /**
     * 获取key所在的节点
     *
     * @param key
     * @param nodeNums
     * @return
     *
     * 如果3个节点
     *      节点 A 包含 0 到 5500号哈希槽.
     *      节点 B 包含5501 到 11000 号哈希槽.
     *      节点 C 包含11001 到 16384号哈希槽.
     * 如果6个节点
     * 16384
     * 	0~2730
     *
     * 	2731~5461
     *
     * 	5462~8192
     *
     * 	8193~10923
     *
     * 	10924~13654
     *
     * 	13655~16384
     *
     */
    public static int getNode(String key, int nodeNums) {
        int nodeIndex = -1;

        return nodeIndex;
    }

    /**
     * 其实不用这么麻烦，通过redis-cli客户端工具，就能直接获取每个主节点的哈希槽范围，命令如下：
     * (1)登录redis
     *     redis-cli -h 127.0.0.1 -p 3793 -a redisPass123
     * (2)查询redis集群节点
     * 127.0.0.1:3793> cluster nodes
     * 902eca889dc42efc69ab30bbf29726acdf464e78 127.0.0.1:3797@13797 slave 82cb771f2b4fe76e6acf0629228fb34ba63af59b 0 1562895514819 5 connected
     * 05df23c4a4e2e2f6f81f9ea6eba99909723a7316 127.0.0.1:3793@13793 myself,master - 0 1562895513000 1 connected 0-5460
     * 613d2819cd2a57ee1347b6eab8961dd6c7e46217 127.0.0.1:3796@13796 slave 724bba8a89f7f0dc899432a94a150365d998e085 0 1562895513000 4 connected
     * f0c917e48881a7a7326f5e9f16b6adb53552e455 127.0.0.1:3798@13798 slave 05df23c4a4e2e2f6f81f9ea6eba99909723a7316 0 1562895511000 6 connected
     * 82cb771f2b4fe76e6acf0629228fb34ba63af59b 127.0.0.1:3795@13795 master - 0 1562895512000 3 connected 10923-16383
     * 724bba8a89f7f0dc899432a94a150365d998e085 127.0.0.1:3794@13794 master - 0 1562895513813 2 connected 5461-10922
     */
    public void parseNodeSlotsMap() {

        try {
            String fileName = "cluster_slots.txt";
            InputStream is = JedisClusterNodeRoute.class.getResourceAsStream(fileName);
            String content = IOUtils.getStr(is);
            Scanner sc = new Scanner(new StringReader(content));
            boolean newPart = true;

            String slotAndPort = "(integer) ";
            String ip = ".";
            List<String> arr = new ArrayList<String>();


            String ipLine = "   4) 1) 127.0.0.1";
            System.out.println(".Index=" + ipLine.indexOf("."));

            String line = "";
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                if(line.indexOf(slotAndPort) >= 0) {
                    arr.add(line.substring(line.indexOf(slotAndPort) + slotAndPort.length()).trim());
                } else if(line.indexOf(".") >= 0) {
                    arr.add(line.substring(line.indexOf("\"") + ip.length(), line.lastIndexOf("\"")));
                }
                System.out.println(line);
            }

            int firstSlot = 0;
            int secondSlot = 0;
            String firstIpPort = "";
            String secondIpPort = "";
            TreeMap<Integer, String> slotAddrMap = new TreeMap<Integer, String>();
            List<Integer> slotList = new ArrayList<Integer>();

            int index = 0;
            for(int i = 0; i < arr.size(); i = i + 6) {
                index = i;
                firstSlot = Integer.parseInt(arr.get(index++));
                secondSlot = Integer.parseInt(arr.get(index++));
                firstIpPort = arr.get(index++) + ":" + arr.get(index++);
                secondIpPort = arr.get(index++) + ":" + arr.get(index);
//                System.out.println("[" + arr.get(i) + "], index%5=" + (i%6));
//                System.out.println(firstIpPort + " " + firstSlot + "~" + (secondSlot - 1));
//                System.out.println(secondIpPort + " " + secondSlot + "~" + (secondSlot - 1));
                slotAddrMap.put(firstSlot, firstIpPort);
                slotAddrMap.put(secondSlot, secondIpPort);
                if(firstSlot != 0) {
                    slotList.add(firstSlot);
                }
                slotList.add(secondSlot);
            }

            slotList.add(total_slot);
            Collections.sort(slotList);

            Iterator<Integer> iter = slotAddrMap.keySet().iterator();
            Integer key = null;
            String value = "";
            index = 0;
            while(iter.hasNext()) {
                key = iter.next();
                value = slotAddrMap.get(key);
//                System.out.println(key + " " + value);
                System.out.println(value + " " + key + "~" + (slotList.get(index++) - 1));

            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
