package com.codefans.opensource.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: codefans
 * @date: 2019-08-26 14:55
 */
public class PayEventMain {

    private PayEventProducer producer;

    public static void main(String[] args) throws Exception {

        PayEventMain payEventMain = new PayEventMain();
        payEventMain.startup();

    }

    public void startup() throws ExecutionException, InterruptedException {

        this.init();
//        this.produce();
//        this.simpleDataSingleThread();
        this.complexDataMultiThread();

    }

    public void init() {
        // The factory for the event
        PayEventFactory factory = new PayEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<PayEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handler
        disruptor.handleEventsWith(new PayEventHandler());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<PayEvent> ringBuffer = disruptor.getRingBuffer();

        producer = new PayEventProducer(ringBuffer);

    }

    public void produce() throws ExecutionException, InterruptedException {

//        this.simpleDataSingleThread();
        this.complexDataMultiThread();

    }

    public void simpleDataSingleThread() {
        ByteBuffer bb = ByteBuffer.allocate(8);
        long total = 100;
        long begin = System.currentTimeMillis();
        for (long l = 0; l < total; l++) {
            bb.putLong(0, l);
            producer.onData(bb);
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end-begin)/1000 + "s");
    }

    public void complexDataMultiThread() throws ExecutionException, InterruptedException {

        int nThread = Runtime.getRuntime().availableProcessors();
        ThreadFactory namedThreadFactory = new ThreadFactory() {
            AtomicInteger index = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "complexDataMultiThread_" + index.getAndIncrement());
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(nThread, namedThreadFactory);

        int totalCount = 1000;
        List<Future> futureList = new ArrayList<Future>();
        Future future = null;

        long begin = System.currentTimeMillis();

        for (long l = 0; l < totalCount; l++) {

            final long index = l;
            Callable<String> task = new Callable() {
                @Override
                public String call() {
                    PayEvent payEvent = null;
                    payEvent = new PayEvent("user_" + index, index);
                    producer.onData(payEvent);
                    return "success";
                }
            };
            future = executorService.submit(task);
            futureList.add(future);

        }

        for (int i = 0; i < totalCount; i++) {
            futureList.get(i).get();
        }

        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - begin)/1000 + "s");

        executorService.shutdown();



    }

}
