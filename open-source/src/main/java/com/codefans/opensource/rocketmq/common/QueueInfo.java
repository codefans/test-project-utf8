package com.codefans.opensource.rocketmq.common;

/**
 * @author: codefans
 * @date: 2019-07-03 10:02
 */
public class QueueInfo {

    private String topic;
    private String brokerName;
    private int queueId;

    private long minOffset;
    private long maxOffset;
    private String lastUpdateTimestamp;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public long getMinOffset() {
        return minOffset;
    }

    public void setMinOffset(long minOffset) {
        this.minOffset = minOffset;
    }

    public long getMaxOffset() {
        return maxOffset;
    }

    public void setMaxOffset(long maxOffset) {
        this.maxOffset = maxOffset;
    }

    public String getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    @Override
    public String toString() {
        return "QueueInfo{" +
                "topic='" + topic + '\'' +
                ", brokerName='" + brokerName + '\'' +
                ", queueId=" + queueId +
                ", minOffset=" + minOffset +
                ", maxOffset=" + maxOffset +
                ", lastUpdateTimestamp='" + lastUpdateTimestamp + '\'' +
                '}';
    }
}
