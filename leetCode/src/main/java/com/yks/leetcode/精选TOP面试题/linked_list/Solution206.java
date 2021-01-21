package com.yks.leetcode.精选TOP面试题.linked_list;

/**
 * @Description: 206. 反转链表
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/26 20:45
 */
public class Solution206 {

    /**
     *
     *  反转一个单链表。
     *  示例
     *  输入: 1->2->3->4->5->NULL
     *  head = 1
     *  head->next = 2
     *  head->next->next = 3
     *
     *  输出: 5->4->3->2->1->NULL
     *
     */

    /**
     * 迭代
     *  思想：将当前节点的next指针改为指向前一个元素，
     *  1.需要事先存储前一个元素，因为当前节点没有引用其上一个节点
     *  2.在更改引用之前，需要另一个指针来存储下一个节点。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//第一个节点，前一个节点为null
        ListNode curr = head; // 设置当前节点为第一个节点
        while(curr != null){ //当当前的节点不为空时
            ListNode nextTemp = curr.next; //中间变量存储当前节点的下一个节点
            curr.next = prev; // 当前节点的下一个节点为前一个节点，实现反转
            prev  = curr; //对下一个节点来说，前一个节点就是当前的节点
            curr =nextTemp; //遍历下一个节点
        }
        return prev;
    }

    /**
     * 递归
     * 关键在于反向工作
     * 从后面反转到前面
     * 1.先执行reverseListAnswer(4)  p=5,5.next=4,4.next->null ----> 5->4->null
     * 2.执行reverseListAnswer(3) p = 5->4->null ,4.next=3,3->next=null ---> 5->4->3->null
     * 3.reverseListAnswer(2) p= 5->4->3->null ,3.next=2,2.next = null
     * 4.reverseListAnswer(1) p=5->4->3->2->null,2.next = 1 ,1.next = null
     * 得出 p = 5->4->3->2->1-> null
     *
     * @param head
     * @return
     */
    public ListNode reverseListAnswer(ListNode head) {
       if (head == null || head.next == null){ //如果指针移到了最后一个节点，返回head
           return head;
       }
        ListNode p = reverseListAnswer(head.next); //递归，直到head.next==null 或者 head == null
        head.next.next = head;
        head.next = null;
        return p;
    }
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
}
