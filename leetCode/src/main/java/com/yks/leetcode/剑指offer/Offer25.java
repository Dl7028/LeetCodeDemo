package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 25. 合并两个排序的链表
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/28 22:15
 */
public class Offer25 {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

      public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

    /**
     * 方法一 ：迭代法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode prev = node;
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
        return node.next;
    }

    /**
     * 方法二：递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val<l2.val){
            l1.next =  mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
           l2.next =   mergeTwoLists2(l1,l2.next);
            return l2;
        }

    }

}
