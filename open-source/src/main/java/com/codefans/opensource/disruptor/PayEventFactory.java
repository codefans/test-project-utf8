package com.codefans.opensource.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author: codefans
 * @date: 2019-08-26 14:51
 */
public class PayEventFactory implements EventFactory<PayEvent>
{
    public PayEvent newInstance()
    {
        return new PayEvent();
    }
}
