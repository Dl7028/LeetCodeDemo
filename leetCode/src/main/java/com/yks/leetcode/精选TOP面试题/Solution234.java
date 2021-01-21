package com.yks.leetcode.精选TOP面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 234. 回文链表
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/20 18:26
 */
public class Solution234 {
    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     */
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            if (list.get(left).val==list.get(right).val){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

}
