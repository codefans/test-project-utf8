package com.codefans.opensource.rocketmq.client;

import com.codefans.opensource.rocketmq.RocketmqBase;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: codefans
 * @date: 2019-07-03 15:07
 */
public class PushConsumerClient extends RocketmqBase {

    private DefaultMQPushConsumer pushConsumer;

    public PushConsumerClient(String consumerGroupName, String namesrvAddr) {
        pushConsumer = new DefaultMQPushConsumer(consumerGroupName);
        pushConsumer.setNamesrvAddr(namesrvAddr);
    }
    @Test
    public void consumeByPush(String topic, String subExpression) throws MQClientException {

//        String consumerGroup = "myConsumerGroupName";
//        String namesrvAddr = "10.58.196.127:9876";
//        String topic = "myTopicTest";

//        pushConsumer.setPullInterval(60 * 1000);

        final CountDownLatch countDownLatch = new CountDownLatch(10000);

        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {

                try {
                    for(MessageExt msg:msgs) {
                        String msgId = msg.getMsgId();
                        String msgBody = new String(msg.getBody(), "UTF-8");
                        System.out.println("msgId=" + msgId + ", msgBody=" + msgBody);
                    }
                    countDownLatch.countDown();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.subscribe(topic, subExpression);
        pushConsumer.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void consumeOrderlyByPush(String topic, String subExpression) throws MQClientException {

//        String consumerGroup = "producerGroupName";
//        String namesrvAddr = "10.58.84.55:9876";
//        String topic = "myTopicTest";

//        pushConsumer.setPullInterval(60 * 1000);

        final CountDownLatch countDownLatch = new CountDownLatch(1000);

        pushConsumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                try {

                    MessageQueue messageQueue = context.getMessageQueue();
                    if(messageQueue != null) {
                        System.out.printf("brokerName=%s, topic=%s, queueId=%s", messageQueue.getBrokerName(), messageQueue.getTopic(), messageQueue.getQueueId());
                    }
                    System.out.println();

                    for(MessageExt msg:msgs) {
                        String msgId = msg.getMsgId();
                        String msgBody = new String(msg.getBody(), "UTF-8");
                        System.out.println("msgId=" + msgId + ", msgBody=" + msgBody);
                    }
                    countDownLatch.countDown();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                return ConsumeOrderlyStatus.SUCCESS;
            }

        });

        pushConsumer.subscribe(topic, subExpression);
        pushConsumer.start();


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
