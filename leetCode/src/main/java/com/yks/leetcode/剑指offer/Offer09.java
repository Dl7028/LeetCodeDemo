package com.yks.leetcode.剑指offer;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/23 0:38
 */
public class Offer09 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     */


    class CQueue {

        Stack<Integer> xStack;
        Stack<Integer> yStack;

        public CQueue() {
            this.xStack = new Stack<Integer>();
            this.yStack = new Stack<Integer>();
        }

        public void appendTail(int value) {
            xStack.push(value);
        }

        public int deleteHead() {

            if (yStack.isEmpty()){
                while(!xStack.isEmpty()){
                    yStack.push(xStack.pop());
                }
            }

            if (yStack.isEmpty()){
                return -1;
            }else{
                return yStack.pop();
            }


        }
    }
}
