package com.codefans.opensource.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author: codefans
 * @date: 2019-08-26 14:54
 */
public class PayEventProducer {

    private final RingBuffer<PayEvent> ringBuffer;

    public PayEventProducer(RingBuffer<PayEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb)
    {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            PayEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            event.setValue(bb.getLong(0));  // Fill with data

        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }

    public void onData(PayEvent payEvent)
    {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            PayEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            event.setUserName(payEvent.getUserName());
            // for the sequence
            event.setValue(payEvent.getValue());  // Fill with data

        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }

}
