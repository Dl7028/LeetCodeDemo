package com.yks.leetcode.linked_list;

/**
 * @Description: 21. 合并两个有序链表
 * @Author: Yu ki-r
 * @CreateDate: 2020/12/5 20:15
 */
public class Solution21 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     *   1->2->4    1->3->4
     *   2->4       1->1->3->4
     *   4          1->1->2->3->4
     *              1->1->2->3->4->4
     */


    /**
     * 迭代，暴力解法，比较l1,l2节点的值，控制prev的位置
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preprev = new ListNode(-1);
        ListNode prev = preprev;

        while (l1!=null&&l2!=null){
          if (l1.val<l2.val){
              prev.next = l1;
              l1 = l1.next;
          }else{
              prev.next = l2;
              l2 = l2.next;
          }
          prev = prev.next;
       }
        prev.next = l2==null? l1:l2;
        return preprev.next;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        else if (l2==null){
            return l1;
        }
        else if(l1.val<l2.val){
            l1.next  = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }

    }


}
