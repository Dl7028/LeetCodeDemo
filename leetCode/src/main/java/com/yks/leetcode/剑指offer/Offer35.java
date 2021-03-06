package com.yks.leetcode.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 剑指 Offer 35. 复杂链表的复制
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/6 16:16
 */
public class Offer35 {
    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 浅拷贝: 只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存。
     * 深拷贝:会另外创造一个一模一样的对象，新对象跟原对象不共享内存，修改新对象不会改到原对象。
     *
     */

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /**
     * 方法一： 使用哈希表，复制链表中的值到哈希表中，再通过哈希表对节点进行引用赋值
     * 两次遍历，借助哈希表辅助空间实现链表复制
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head==null) return null;  //如果头结点为空，返回空
        Node cur  = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            // 4. 构建新链表的 next 和 random 指向
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
