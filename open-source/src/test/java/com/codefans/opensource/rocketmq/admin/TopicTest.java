package com.codefans.opensource.rocketmq.admin;

import com.codefans.opensource.rocketmq.RocketmqBase;
import com.codefans.opensource.rocketmq.common.QueueInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author: codefans
 * @date: 2019-07-02 17:28
 */
public class TopicTest extends RocketmqBase {

    private TopicTool topicTool;

    @Before
    public void before() {
        try {
            topicTool = new TopicTool(NAMESRV_ADDR);
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void topicListTest() throws RemotingException, MQClientException, InterruptedException {

        TopicList topicList = topicTool.queryAllTopics();
        if(topicList != null) {
            String brokerAddr = topicList.getBrokerAddr();
            System.out.println("brokerAddr=" + brokerAddr);
            Set<String> topicSet = topicList.getTopicList();
            System.out.println("topic.size()=" + topicSet.size());
            printSet(topicSet);

        }

    }

    @Test
    public void topicClusterListTest() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        String topic = "repayment_settle_topic";
        Set<String> clusterList = topicTool.topicClusterList(topic);
        printSet(clusterList);

        String[] topicArr = new String[]{
            "repayment_data_roam_topic",
            "%RETRY%repayment_data_roam_group",
            "%DLQ%repayment_data_roam_group",
            "repayment_settle_topic",
            "%RETRY%repayment_settle_group",
            "%DLQ%repayment_settle_group",
        };
        Map<String, Set<String>> resultMap = topicTool.topicClusterList(Arrays.asList(topicArr));
        printMap(resultMap);

    }

    @Test
    public void topicStatusTest() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        String[] topicArr = new String[]{
                "repayment_data_roam_topic",
                "%RETRY%repayment_data_roam_group",
                "%DLQ%repayment_data_roam_group",
                "repayment_settle_topic",
                "%RETRY%repayment_settle_group",
                "%DLQ%repayment_settle_group",
        };
        topicTool.topicStatus(topicArr);

    }

    @Test
    public void queryMessageQueueListTest() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

//        String topic = "%DLQ%repayment_data_roam_group";
//        List<QueueInfo> queueInfoList = topicTool.queryMessageQueueList(topic);
//        if(CollectionUtils.isNotEmpty(queueInfoList)) {
//            QueueInfo queueInfo = null;
//            for(int i = 0; i < queueInfoList.size(); i ++) {
//                queueInfo = queueInfoList.get(i);
//                System.out.println(queueInfo);
//            }
//        }

        String[] topicArr = new String[]{
                "repayment_data_roam_topic",
                "%RETRY%repayment_data_roam_group",
                "%DLQ%repayment_data_roam_group",
                "repayment_settle_topic",
                "%RETRY%repayment_settle_group",
                "%DLQ%repayment_settle_group",
        };
        Map<String,List<QueueInfo>> result = topicTool.queryMessageQueueList(topicArr);
        if(result != null) {
            Iterator<String> iter = result.keySet().iterator();
            String key = "";
            List<QueueInfo> queueList = null;
            while(iter.hasNext()) {
                key = iter.next();
                queueList = result.get(key);
                System.out.println("topic[" + key + "] 队列信息如下：");
                if(CollectionUtils.isNotEmpty(queueList)) {
                    QueueInfo queueInfo = null;
                    for(int i = 0; i < queueList.size(); i ++) {
                        queueInfo = queueList.get(i);
                        System.out.println(queueInfo);
                    }
                }
            }
        }
    }




}
