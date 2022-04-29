package com.codefans.basicjava.java.util;


import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * PriorityQueue优先队列测试类
 *
 * @author: codefans
 * @Date: 2021/12/03 13:59
 * @since: 1.0.0
 */
public class PriorityQueueTest {

    @Test
    public void offerTest() {

        /**
         * 默认是小顶堆, 最小值在第一个位置
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(6);
        queue.add(12);
        queue.add(6);
        queue.add(24);
        queue.add(8);
        queue.add(7);
        queue.add(10);
        /**
         * 实际在队列中的顺序是：6、7、10、12、8、24
         */

//        queue.add(1);
//        queue.add(3);
//        queue.add(2);

        System.out.println("size=" + queue.size());

        /**
         * 如果连续调用6次poll()方法，输出的值依次为：
         *     6、7、8、10、12、24
         */
        this.print(queue);

    }

    @Test
    public void iteratorTest() {

        PriorityQueue<Integer> queue = new PriorityQueue<>(8);
        queue.add(12);
        queue.add(6);
        queue.add(24);
        queue.add(8);
        queue.add(7);
        queue.add(10);

        System.out.println("iterator:");
        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + ",");
        }
        System.out.println();

        System.out.println("poll:");
        int size = queue.size();
        for(int i = 0; i < size; i ++) {
            System.out.print(queue.poll() + ",");
        }

        System.out.println();
        System.out.println(Math.abs(3));
        System.out.println(Math.abs(-2));

    }

    /**
     * 大顶堆
     */
    @Test
    public void bigHeapTest() {
        IntegerComparetor comparetor = new IntegerComparetor();
        PriorityQueue<Integer> queue = new PriorityQueue<>(2, comparetor);
        queue.add(12);
        queue.add(6);
        queue.add(24);
        queue.add(8);
        queue.add(7);
        queue.add(10);
        /**
         * 实际在队列中的顺序是：6、7、10、12、8、24
         */

//        queue.add(1);
//        queue.add(3);
//        queue.add(2);

        System.out.println("size=" + queue.size());
        this.print(queue);

    }

    @Test
    public void smallHeapTest() {
        int heapSize = 6;
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize, new IntegerComparetor());
        int dataCount = 100;
        Random random = new Random();
        for(int i = 0; i < dataCount; i ++) {
            if(queue.size() < heapSize) {
                queue.add(i);
            } else {
                if(i < queue.peek()) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }

        this.print(queue);

    }

    class IntegerComparetor implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            /**
             * 小顶堆，默认就是这种
             */
//            return o1 - o2;
            /**
             * 大顶堆
             */
            return o2 - o1;
        }
    }
    private void print(PriorityQueue<Integer> queue) {
        int size = queue.size();
        for(int i = 0; i < size; i ++) {
            System.out.println(queue.poll());
        }
    }

}