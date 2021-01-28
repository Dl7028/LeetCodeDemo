package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 24. 反转链表
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/28 16:49
 */
public class Offer24 {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     *  
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 方法一：迭代反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode beg = null;
        ListNode mid ;
        ListNode end ;
        if (head == null){
            return null;
        }else {
            mid = head;
            end = head.next;
        }
        while(mid!=null){
            mid.next = beg;
            if (end==null){
                return  mid;
            }
            beg = mid;
            mid = end;
            end = end.next;
        }
        return mid;
    }

    /**
     * 方法二：递归 nk.next.next = nk
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null||head.next==null){
            return head;
        }
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
