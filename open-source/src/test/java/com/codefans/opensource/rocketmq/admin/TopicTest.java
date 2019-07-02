package com.codefans.opensource.rocketmq.admin;

import com.codefans.opensource.rocketmq.RocketmqBase;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author: codefans
 * @date: 2019-07-02 17:28
 */
public class TopicTest extends RocketmqBase {

    private TopicTool topicTool;

    @Before
    public void before() {
        topicTool = new TopicTool();
    }


    @Test
    public void topicListTest() throws RemotingException, MQClientException, InterruptedException {

        String namesrvAddr = NAMESRV_ADDR;

        TopicList topicList = topicTool.queryAllTopics(namesrvAddr);
        if(topicList != null) {
            String brokerAddr = topicList.getBrokerAddr();
            System.out.println("brokerAddr=" + brokerAddr);
            Set<String> topicSet = topicList.getTopicList();
            System.out.println("topic.size()=" + topicSet.size());
            printSet(topicSet);

        }

    }

    @Test
    public void topicClusterListTest() {

//        repayment_settle_topic
//        repayment_data_roam_topic
//        %DLQ%repayment_settle_group
//                %RETRY%repayment_settle_group
//                %RETRY%repayment_data_roam_group
//                %DLQ%repayment_data_roam_group

        String topic = "";
        Set<String> clusterList = topicTool.topicClusterList(topic);
        printSet(clusterList);

    }




}
