package com.codefans.opensource.rocketmq.admin;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.apache.rocketmq.tools.command.SubCommandException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: codefans
 * @date: 2019-07-02 17:28
 */
public class TopicTool {

    private DefaultMQAdminExt defaultMQAdminExt;

    public TopicTool(){}

    public TopicTool(String namesrvAddr) throws MQClientException {
        defaultMQAdminExt = new DefaultMQAdminExt();
        defaultMQAdminExt.setInstanceName(Long.toString(System.currentTimeMillis()));
        defaultMQAdminExt.setNamesrvAddr(namesrvAddr);
        defaultMQAdminExt.start();
    }

    public TopicList queryAllTopics(String namesrvAddr) throws MQClientException, RemotingException, InterruptedException {
        TopicList topicList = defaultMQAdminExt.fetchAllTopicList();
        return topicList;
    }

    public Set<String> topicClusterList(String topic) {

        Set<String> clusters = null;
        DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt();
        defaultMQAdminExt.setInstanceName(Long.toString(System.currentTimeMillis()));
        try {
            defaultMQAdminExt.start();
            clusters = defaultMQAdminExt.getTopicClusterList(topic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultMQAdminExt.shutdown();
        }
        return clusters;

    }

    public Map<String/*topic*/, Set<String>/*clusterList*/> topicClusterList(List<String> topicList) {
        Map<String, Set<String>> resultData = new HashMap<String, Set<String>>();

        return resultData;
    }


}
