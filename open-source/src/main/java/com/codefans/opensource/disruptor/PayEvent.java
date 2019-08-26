package com.codefans.opensource.disruptor;

/**
 * @author: codefans
 * @date: 2019-08-26 14:49
 */

public class PayEvent {

    private String userName;

    private long value;

    public PayEvent() {
    }

    public PayEvent(String userName, long value) {
        this.userName = userName;
        this.value = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PayEvent{" +
                "userName='" + userName + '\'' +
                ", value=" + value +
                '}';
    }
}
