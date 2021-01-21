package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 160. 相交链表
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/17 17:28
 */
public class Solution160 {

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     */
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

    /**
     * 方法一：双指针法
     * 使用 2 个指针，分别遍历 headA，headB，每次前进 1 步。当一个链表遍历完时，从另一个链表的起始位置再次开始遍历。
     * 如果两个链表相交，则两个指针一定会相遇，相遇点即相交点。如果两个指针都已遍历完两个链表，且仍未相遇，则说明链表不相交。
     * a+all+b = b+all+a
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode preA = headA;
        ListNode preB = headB;
        while(preB!=preA){
            if (preA == null){
                preA = headB;
            }else{
                preA = preA.next;
            }
            if (preB == null){
                preB = headA;
            }else{
                preB = preB.next;
            }
        }
        return preA;
    }
}
