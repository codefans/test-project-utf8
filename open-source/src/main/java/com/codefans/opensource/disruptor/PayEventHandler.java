package com.codefans.opensource.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author: codefans
 * @date: 2019-08-26 14:52
 */
public class PayEventHandler implements EventHandler<PayEvent>
{
    public void onEvent(PayEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event);
    }
}