package com.yks.leetcode;

/**
 * @Description: Nim 游戏
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/16 19:58
 */
public class Solution292 {
    /**
     * 你和你的朋友，两个人一起玩 Nim 游戏：
     *
     * 桌子上有一堆石头。
     * 你们轮流进行自己的回合，你作为先手。
     * 每一回合，轮到的人拿掉 1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。
     * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
     *
     *
     * 示例 1：
     *
     * 输入：n = 4
     * 输出：false
     * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
     *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：true
     * 示例 3：
     *
     * 输入：n = 2
     * 输出：true
     */


    /**
     *  1 true
     *  2 true
     *  3 true
     *  4 false
     *  5 true
     *  6 true
     *  7 true
     *  8 false
     *  9 true
     *  10 true
     *  11 true
     *  12 true
     *  13 true
     *  14 true
     *  15 true
     *  16 false
     *
     *  不管你从一堆石头中挑出一块、两块还是三块，你的对手都可以选择三块、两块或一块，以确保在再一次轮到你的时候，你会面对四块石头。
     *
     *  当n是4的倍数时，对手可以控制石头的数量，让它最后保持是4个，则最后的石子会被对手拿走
     * 返回false 的条件 不管怎么选，最后总会剩下1-3
     * 返回true  的条件， 最后剩下0
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        if(n%4!=0){
            return true;
        }else{
            return false;
        }
    }
}
