package com.codefans.interview.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-22 17:57
 *
 * Runtime: 49 ms, faster than 18.36% of Java online submissions for Min Stack.
 * Memory Usage: 39.7 MB, less than 38.41% of Java online submissions for Min Stack.
 *
 * 没考虑到的单元测试：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * ["MinStack","push","push","push","getMin","top","pop","getMin"]
 * [[],[-2],[0],[-1],[],[],[],[]]
 *
 *
 * 不能用map，因为如果push多次相同的数，这些相同的数字对应的最小值可能不一样，但是map的话取出的最小值确实一样的。
 * ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
 * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
 *
 * 用stack也不合适，比如前面5个的最小值是-20，如果这个-20被pop出去了，那么之前的5个最小值-20都得pop。所以存数据的stack和存最小值的stack不能是一对一的关系。
 * ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
 * [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
 *
 */

public class No155MinStack {

    private int min;
    private Stack<Integer> stack;
    private Map<String, Integer> minMap;

    /** initialize your data structure here. */
    public No155MinStack() {
        stack = new Stack<Integer>();
        minMap = new HashMap<String, Integer>();
    }

    public void push(int x) {
        stack.push(x);
        this.setMin(x);
    }

    public void pop() {
        int top = this.top();
        stack.pop();
        int lastMin = minMap.get(top+"_"+(stack.size()+1));
        this.forceSetMin(lastMin);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    private void setMin(int curVal) {
        if(stack.size() == 1) {
            min = curVal;
            //minStack.push(curVal);
            minMap.put(curVal+"_1", curVal);
            //System.out.println("curVal:" + curVal);
        } else {
            minMap.put(curVal+"_" + stack.size(), min);
            if(curVal < min) {
                min = curVal;
            }
            //minStack.push(min);
            //System.out.println("min:" + min);

        }


    }

    private void forceSetMin(int curVal) {
        min = curVal;
    }

}
