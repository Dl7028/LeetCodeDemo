package com.yks.leetcode.linked_list;

/**
 * @Description: 237. 删除链表中的节点
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/23 16:43
 */
public class Solution237 {


    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点
     * 示例：
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     */


    /**
     *  只传入要删除的结点，调用这个方法，会删除掉传进去的结点
     *  假设A是要删除的结点，B是A后面的结点
     *  1.B的值复制给A
     *  2.删除掉A
     * @param node
     */
    public void deleteNodeAnswer(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
