package com.yks.leetcode.剑指offer;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 06. 从尾到头打印链表
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/22 19:56
 */
public class Offer06 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while(head!=null){
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i=0; i<result.length; i++){
            result[i] = stack.pop();
        }
        return result;
    }
}
