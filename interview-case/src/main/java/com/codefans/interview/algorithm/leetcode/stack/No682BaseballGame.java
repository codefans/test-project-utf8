package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-14 17:47
 */

public class No682BaseballGame {

    /**
     * 如果当前字符为C时,不通栈Stack,记录最后两个字符的方式没有跑通。
     * 不好实现的地方：如果连续存在多个C,即要连续作废多个前面的元素,不好定位最后两个字符.
     */

    /**
     * Runtime: 3 ms, faster than 52.79% of Java online submissions for Baseball Game.
     * Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Baseball Game.
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int index = 0;
        int result = 0;
        Stack<String> stack = new Stack<String>();
        String opt = "";
        String lastOpt = "";
        for(int i = 0; i < ops.length; i ++) {
            opt = ops[i];
            if(stack.isEmpty()) {
                stack.push(opt);
                result += parseInt(opt);
            } else {
                if("C".equals(opt)) {
                    lastOpt = stack.pop();
                    result -= parseInt(lastOpt);
                } else if("D".equals(opt)) {
                    lastOpt = stack.pop();
                    int data = parseInt(lastOpt) * 2;
                    stack.push(lastOpt);
                    stack.push(data+"");
                    result += data;
                } else if("+".equals(opt)) {
                    int add = 0;
                    int n = parseInt(stack.pop());
                    add += n;
                    boolean hasSecond = false;
                    int m = -1;
                    if(!stack.isEmpty()) {
                        m = parseInt(stack.pop());
                        add += m;
                        hasSecond = true;
                    }

                    if(hasSecond) {
                        stack.push(m+"");
                    }
                    stack.push(n+"");

                    //System.out.println(add);
                    stack.push(add+"");
                    result += add;
                } else {
                    stack.push(opt);
                    result += parseInt(opt);
                }


            }
        }
        return result;
    }
    public int parseInt(String data) {
        return Integer.parseInt(data);
    }

}
