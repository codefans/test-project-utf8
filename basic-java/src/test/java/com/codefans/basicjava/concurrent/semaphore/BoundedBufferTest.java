package com.codefans.basicjava.concurrent.semaphore;

import junit.framework.TestCase;

/**
 * @author: codefans
 * @date: 2019-09-25 11:34
 */
public class BoundedBufferTest extends TestCase {

    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }

    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for(int i = 0; i < 10; i ++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    /**
     * 测试阻塞与响应中断
     */
    public void testTakeBlocksWhenEmpty() {

        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread() {
            public void run() {
                try {
                    int unUsed = bb.take();
                    fail();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            taker.start();
            Thread.sleep(10 * 1000);
            taker.start();
            taker.interrupt();
            taker.join(10 * 1000);
        } catch (InterruptedException e) {
            fail();
        }

    }


























}
