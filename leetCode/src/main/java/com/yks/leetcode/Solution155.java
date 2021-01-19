package com.yks.leetcode;

import java.util.Stack;

/**
 * @Description: 155. 最小栈
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/18 22:39
 */
public class Solution155 {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *  
     *
     * 示例:
     *
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     *
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *
     */

    /**
     * 方法一：辅助栈，借助用另一个栈来存放栈内的最小值，取最小值时直接返回栈顶元素
     */
    /** initialize your data structure here. */
    class MinStack1 {

        /**
         * push 插入
         * pop  移除栈顶元素
         * peek 返回栈顶的元素但不移除它。
         */
        Stack<Integer> xStack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack1() {
            xStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            xStack.push(x);
            if (minStack.isEmpty()||x<=minStack.peek()){ //若x小于minStack栈顶元素
                minStack.push(x); //把x放入辅助栈minStack中
            }
        }

        public void pop() {
            int x = xStack.pop();
            if (x == minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


    /**
     *  方法二：使用Stack<Node>,用Node存放当前最小值
     */
    /** initialize your data structure here. */
    class MinStack2 {

        Stack<Node> xStack ;
        /** initialize your data structure here. */
        public MinStack2() {
            xStack = new Stack<Node>();
        }

        public void push(int x) {
            Node n;
            if (xStack.isEmpty()){
                n = new Node(x,x);
            }

            else if (x>xStack.peek().min){
                 n = new Node(x,xStack.peek().min);
            }else{
                n = new Node(x,x);
            }
            xStack.push(n);
        }

        public void pop() {
            xStack.pop();
        }

        public int top() {
            return xStack.peek().val;
        }

        public int getMin() {
            return xStack.peek().min;
        }
    }

    class Node {
        int val;
        int min;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }



}
