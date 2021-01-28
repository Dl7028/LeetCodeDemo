package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/28 15:10
 */
public class Offer22 {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     *  
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


     public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    /**
     * 方法1：遍历两次
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 0;
        ListNode node = head;

        while (node!=null){
            length++;
            node = node.next;
        }
        int count = 0;

        while(head!=null){
            if (length-count == k){
                return head;
            }
            head = head.next;
            count++;
        }
        return null;
    }

    /**
     * 方法二：双指针法（遍历一次）
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        if (head==null){
            return null;
        }
        for (int i=1; i<k;i++){
            slow = slow.next;
        }
        while(head!=null&&slow.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
