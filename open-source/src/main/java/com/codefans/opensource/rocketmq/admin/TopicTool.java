package com.codefans.opensource.rocketmq.admin;

import com.codefans.opensource.rocketmq.common.QueueInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.admin.TopicOffset;
import org.apache.rocketmq.common.admin.TopicStatsTable;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;

import java.util.*;

/**
 * @author: codefans
 * @date: 2019-07-02 17:28
 */
public class TopicTool {

    private DefaultMQAdminExt defaultMQAdminExt;

//    public TopicTool(){}

    public TopicTool(String namesrvAddr) throws MQClientException {
        defaultMQAdminExt = new DefaultMQAdminExt();
        defaultMQAdminExt.setInstanceName(Long.toString(System.currentTimeMillis()));
        defaultMQAdminExt.setNamesrvAddr(namesrvAddr);
        defaultMQAdminExt.start();
    }

    public TopicList queryAllTopics() throws MQClientException, RemotingException, InterruptedException {
        TopicList topicList = defaultMQAdminExt.fetchAllTopicList();
        return topicList;
    }

    public Set<String> topicClusterList(String topic) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Set<String> clusters = defaultMQAdminExt.getTopicClusterList(topic);
        return clusters;

    }

    public Map<String/*topic*/, Set<String>/*clusterList*/> topicClusterList(List<String> topicList) {
        Map<String, Set<String>> resultData = new HashMap<String, Set<String>>();
        Set<String> clusterList = null;
        if(CollectionUtils.isNotEmpty(topicList)) {
            String topic = "";
            for(int i = 0; i < topicList.size(); i ++) {
                topic = topicList.get(i);
                try {
                    clusterList = defaultMQAdminExt.getTopicClusterList(topic);
                    if(CollectionUtils.isNotEmpty(clusterList)) {
                        resultData.put(topic, clusterList);
                    } else {
                        resultData.put(topic, new HashSet<String>());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultData;
    }

    public void topicStatus(String topic) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        TopicStatsTable topicStatsTable = defaultMQAdminExt.examineTopicStats(topic);

        List<MessageQueue> mqList = new LinkedList<MessageQueue>();
        mqList.addAll(topicStatsTable.getOffsetTable().keySet());
        Collections.sort(mqList);

        System.out.printf("%-32s  %-4s  %-20s  %-20s    %s%n",
                "#Broker Name",
                "#QID",
                "#Min Offset",
                "#Max Offset",
                "#Last Updated"
        );

        for (MessageQueue mq : mqList) {
            TopicOffset topicOffset = topicStatsTable.getOffsetTable().get(mq);

            String humanTimestamp = "";
            if (topicOffset.getLastUpdateTimestamp() > 0) {
                humanTimestamp = UtilAll.timeMillisToHumanString2(topicOffset.getLastUpdateTimestamp());
            }

            System.out.printf("%-32s  %-4d  %-20d  %-20d    %s%n",
                    UtilAll.frontStringAtLeast(mq.getBrokerName(), 32),
                    mq.getQueueId(),
                    topicOffset.getMinOffset(),
                    topicOffset.getMaxOffset(),
                    humanTimestamp
            );
        }

    }

    public void topicStatus(String[] topicArr) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        if(topicArr == null) {
            throw new NullPointerException("topicArr is null");
        }
        String topic = "";
        for(int i = 0; i < topicArr.length; i ++) {
            topic = topicArr[i];
            System.out.println("topic[" + topic + "] status:");
            this.topicStatus(topic);
        }
    }

    public List<QueueInfo> queryMessageQueueList(String topic) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        TopicStatsTable topicStatsTable = defaultMQAdminExt.examineTopicStats(topic);

        List<MessageQueue> mqList = new LinkedList<MessageQueue>();
        mqList.addAll(topicStatsTable.getOffsetTable().keySet());
        Collections.sort(mqList);

        System.out.printf("%-32s  %-4s  %-20s  %-20s    %s%n",
                "#Broker Name",
                "#QID",
                "#Min Offset",
                "#Max Offset",
                "#Last Updated"
        );

        List<QueueInfo> queueInfoList = new ArrayList<QueueInfo>(mqList.size());
        QueueInfo queueInfo = null;

        for (MessageQueue mq : mqList) {

            queueInfo = new QueueInfo();
            queueInfo.setTopic(topic);
            queueInfo.setBrokerName(mq.getBrokerName());
            queueInfo.setQueueId(mq.getQueueId());

            TopicOffset topicOffset = topicStatsTable.getOffsetTable().get(mq);

            String humanTimestamp = "";
            if (topicOffset.getLastUpdateTimestamp() > 0) {
                humanTimestamp = UtilAll.timeMillisToHumanString2(topicOffset.getLastUpdateTimestamp());
            }

            queueInfo.setMinOffset(topicOffset.getMinOffset());
            queueInfo.setMaxOffset(topicOffset.getMaxOffset());
            queueInfo.setLastUpdateTimestamp(humanTimestamp);

            System.out.printf("%-32s  %-4d  %-20d  %-20d    %s%n",
                    UtilAll.frontStringAtLeast(mq.getBrokerName(), 32),
                    mq.getQueueId(),
                    topicOffset.getMinOffset(),
                    topicOffset.getMaxOffset(),
                    humanTimestamp
            );

            queueInfoList.add(queueInfo);
        }

        return queueInfoList;

    }

    public Map<String,List<QueueInfo>> queryMessageQueueList(List<String> topicList) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        Map<String,List<QueueInfo>> result = new HashMap<String,List<QueueInfo>>();

        if(CollectionUtils.isNotEmpty(topicList)) {
            String topic = "";
            List<QueueInfo> queueInfoList = null;
            for(int i = 0; i < topicList.size(); i ++) {
                topic = topicList.get(i);
                queueInfoList = this.queryMessageQueueList(topic);
                result.put(topic, queueInfoList);
            }
        }

        return result;

    }

    public Map<String,List<QueueInfo>> queryMessageQueueList(String[] topicArr) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.queryMessageQueueList(Arrays.asList(topicArr));

    }


}
