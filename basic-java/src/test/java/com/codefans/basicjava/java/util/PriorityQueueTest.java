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
        int heapSize = 6;
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize);
        queue.add(12);
        queue.add(6);
        queue.add(24);
        queue.add(8);
        queue.add(7);
        queue.add(10);
        queue.add(11);
        queue.add(15);
        /**
         * 实际在队列中的顺序是：6、7、10、12、8、24
         */

//        queue.add(1);
//        queue.add(3);
//        queue.add(2);

        System.out.println("offerTest()-->size=" + queue.size());

        /**
         * 如果连续调用6次poll()方法，输出的值依次为：
         *     6、7、8、10、12、24
         */
        this.print(queue, heapSize);

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

        /**
         * 按数组中的存放顺序输出
         * 注意：非插入顺序
         */
        System.out.println("iterator:");
        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + ",");
        }
        System.out.println();

        /**
         * 按从小到大升序输出
         */
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
    public void maxHeapTest() {
        int heapSize = 6;
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize, Comparator.comparingInt(o->o));
        int[] dataArr = new int[]{12, 6, 24, 8, 7, 10, 11, 15};
        for(int i = 0; i < dataArr.length; i ++) {
            if(queue.size() < heapSize) {
                queue.add(dataArr[i]);
            } else {
                if(dataArr[i] > queue.peek()) {
                    queue.poll();
                    queue.add(dataArr[i]);
                }
            }
        }
        System.out.println("maxHeapTest()-->size=" + queue.size());
        this.print(queue, heapSize); //输出8, 10, 11, 12, 15, 24

    }

    @Test
    public void minHeapTest() {
        int heapSize = 6;
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize, Comparator.reverseOrder());
        int[] dataArr = new int[]{12, 6, 24, 8, 7, 10, 11, 15};
        for(int i = 0; i < dataArr.length; i ++) {
            if(queue.size() < heapSize) {
                queue.add(dataArr[i]);
            } else {
                if(dataArr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(dataArr[i]);
                }
            }
        }
        System.out.println("minHeapTest()-->size=" + queue.size());
        this.print(queue, heapSize); //输出12, 11, 10, 8, 7, 6

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
            System.out.print(queue.poll());
            if(i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private void print(PriorityQueue<Integer> queue, int size) {
        for(int i = 0; i < size; i ++) {
            if(i != 0) {
                System.out.print(", ");
            }
            System.out.print(queue.poll());
        }
        System.out.println();
    }

}