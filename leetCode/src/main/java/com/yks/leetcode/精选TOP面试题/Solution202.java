package com.yks.leetcode.精选TOP面试题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 202. 快乐数
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/17 13:36
 */
public class Solution202 {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     *  然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *
     * 示例：
     *
     * 输入：19
     * 输出：true
     * 解释：
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     */


    /**
     * 方法一：用 HashSet 检测循环
     * 用集合存放每一个相加的和，若出现与集合内相同的值，则说明存在循环，返回false，结束循环的条件是n=1
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();

        while (n!=1&&!hashSet.contains(n)){
            hashSet.add(n); //向集合中加入n
            n = getNext(n);
        }
        return n==1;
    }

    /**
     * 返回n分解后的下一个n
     * @return
     */
    public int getNext(int n) {
        int m = 0;
        while(n>0){
            m += (n%10)*(n%10);
            n = n/10;
        }
        return m;
    }


    /**
     * 方法二：快慢指针法
     * 在算法的每一步中，慢速在链表中前进 1 个节点，快跑者前进 2 个节点（对 getNext(n) 函数的嵌套调用）。
     * 如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1。
     *
     * 如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int fastRunner = getNext(n); //快指针，指向n的下一个数
        int slowRunner = n; //慢指针，指向n
        while(fastRunner!=1&&fastRunner!=slowRunner){//循环条件，快指针不等于1，快指针不与慢指针相等
            slowRunner = getNext(slowRunner); //慢指针指向下一个数
            fastRunner = getNext(getNext(fastRunner));//快指针指向下下下一个数
        }
        return fastRunner == 1;
    }

    /**
     * 方法三：数学
     * @param n
     * @return
     */
    public boolean isHappy3(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }
    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));




}
