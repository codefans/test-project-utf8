package com.codefans.opensource.rocketmq.client;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author: codefans
 * @date: 2019-07-03 14:47
 */
public class PullConsumerClient {

    private DefaultMQPullConsumer pullConsumer;

    public PullConsumerClient(String consumerGroupName, String namesrvAddr) throws MQClientException {
        pullConsumer = new DefaultMQPullConsumer(consumerGroupName);
        pullConsumer.setNamesrvAddr(namesrvAddr);
        pullConsumer.start();
    }

    /**
     *
     * @param topic
     * @param brokerName
     * @param queueId
     * @param subExpression
     * @param offset
     * @param maxNums 最大记录数,不管这个设置多少,broker最多返回32条
     * @throws MQClientException
     * @throws RemotingException
     * @throws InterruptedException
     * @throws MQBrokerException
     * @throws UnsupportedEncodingException
     */
    public void consumeByPull(String topic, String brokerName, int queueId, String subExpression, int offset, int maxNums) throws MQClientException, RemotingException, InterruptedException, MQBrokerException, UnsupportedEncodingException {

        MessageQueue messageQueue = new MessageQueue(topic, brokerName, queueId);
        PullResult pullResult = pullConsumer.pull(messageQueue, subExpression, offset, maxNums);

        System.out.println(pullResult);

        List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
        for(MessageExt message : msgFoundList) {
            String msgId = message.getMsgId();
            String msgBody = new String(message.getBody(), "UTF-8");
            System.out.println("msgId=" + msgId + ", msgBody=" + msgBody);
            System.out.println("topic=" + message.getTopic() + ", queueId=" + message.getQueueId() + ", queueOffset=" + message.getQueueOffset());

            Map<String, String> properties = message.getProperties();

            System.out.println(properties);
        }

    }


}
