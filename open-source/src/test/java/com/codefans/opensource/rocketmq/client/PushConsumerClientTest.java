package com.codefans.opensource.rocketmq.client;

import com.codefans.opensource.rocketmq.RocketmqBase;
import org.apache.rocketmq.client.exception.MQClientException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-07-03 16:38
 */
public class PushConsumerClientTest extends RocketmqBase {

    private PushConsumerClient pushConsumerClient;

    @Before
    public void before() {
        String consumerGroupName = "pushConsumerClientGroup";
        pushConsumerClient = new PushConsumerClient(consumerGroupName, NAMESRV_ADDR);
    }

    @Test
    public void consumeByPushTest() throws MQClientException {

        String topic = "myTopicTest";
        pushConsumerClient.consumeByPush(topic, DEFAULT_SUBEXPRESSION);

    }

    @Test
    public void consumeOrderlyByPushTest() throws MQClientException {
        String topic = "myTopicTest";
        pushConsumerClient.consumeOrderlyByPush(topic, DEFAULT_SUBEXPRESSION);
    }


}
