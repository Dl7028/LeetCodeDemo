package com.yks.leetcode.剑指offer;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 30. 包含min函数的栈
 * @Author: Yu ki-r
 * @CreateDate: 2021/2/5 23:14
 */
public class Offer30 {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     *
     *  
     *
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 方法一：用辅助栈
     */
    class MinStack {

        Stack<Integer> s;
        Stack<Integer> y ;

        /** initialize your data structure here. */
        public MinStack() {
            this.s = new Stack<>();
            this.y = new Stack<>();
        }

        public void push(int x) {
            s.push(x);
            if (y.isEmpty()||x<=y.peek()){
                y.push(x);
            }
        }

        public void pop() {
            int x = s.pop();
            if (x == y.peek()){
                y.pop();
            }


        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return y.peek();

        }
    }







}
