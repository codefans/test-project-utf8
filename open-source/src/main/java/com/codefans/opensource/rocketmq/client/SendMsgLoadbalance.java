package com.codefans.opensource.rocketmq.client;

import com.codefans.opensource.rocketmq.common.ThreadLocalIndex;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: codefans
 * @date: 2019-07-04 10:56
 */
public class SendMsgLoadbalance {

    private ThreadLocalIndex sendWhichQueue = new ThreadLocalIndex();
    private List<String> messageQueueList = new ArrayList<String>();

    public SendMsgLoadbalance() {
        init();
    }

    public void init() {
        messageQueueList.add("aaa");
        messageQueueList.add("bbb");
        messageQueueList.add("ccc");
        messageQueueList.add("ddd");
        messageQueueList.add("eee");
    }

    public String selectOneMessageQueue(final String lastBrokerName) {
        if (lastBrokerName == null) {
            return selectOneMessageQueue();
        } else {
            int index = this.sendWhichQueue.getAndIncrement();
            for (int i = 0; i < this.messageQueueList.size(); i++) {
                int pos = Math.abs(index++) % this.messageQueueList.size();
                if (pos < 0)
                    pos = 0;
                String brokerName = this.messageQueueList.get(pos);
                if (!brokerName.equals(lastBrokerName)) {
                    return brokerName;
                }
            }
            return selectOneMessageQueue();
        }
    }

    public String selectOneMessageQueue() {
        int index = this.sendWhichQueue.getAndIncrement();
        int pos = Math.abs(index) % this.messageQueueList.size();
        if (pos < 0)
            pos = 0;
        return this.messageQueueList.get(pos);
    }

}
