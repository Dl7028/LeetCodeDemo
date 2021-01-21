package com.yks.leetcode.精选TOP面试题;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 141. 环形链表
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/20 16:26
 */
public class Solution141 {

    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     */

    class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

    /**
     * 方法一：哈希表法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while(head!=null){
            if (!seen.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        while(fast!=null&&slow!=null&&fast.next!=null){
            if (slow==fast){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
