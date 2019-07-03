package com.codefans.opensource.rocketmq.client;

import com.codefans.opensource.rocketmq.RocketmqBase;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author: codefans
 * @date: 2019-07-03 15:01
 */
public class PullConsumerClientTest extends RocketmqBase {

    private PullConsumerClient consumerClient;

    @Before
    public void before() throws MQClientException {
        String consumerGroupName = "ConsumerClientGroupName";
        consumerClient = new PullConsumerClient(consumerGroupName, NAMESRV_ADDR);
    }

    @Test
    public void consumeByPullTest() throws InterruptedException, RemotingException, UnsupportedEncodingException, MQClientException, MQBrokerException {

        String brokerName = "broker-a";
        String topic = "%RETRY%repayment_data_roam_group";
//        String topic = "%DLQ%repayment_data_roam_group";
        int queueId = 0;
        String subExpression = "*";
        int offset = 0;
        int maxNums = 31;
        consumerClient.consumeByPull(topic, brokerName, queueId, subExpression, offset, maxNums);

    }

}
