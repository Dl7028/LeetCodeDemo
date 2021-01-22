package com.yks.leetcode.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/23 1:38
 */
public class Offer10_II {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     *
     */
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * 两种可能 f（x-1） 或 f（x-2）
     * f(x) = f(x-1)+f(x-2)
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n==0){
            return 1;
        }
        if (n==1){
            return 1;
        }
        int first = 1,second = 1,count = 0;
        for (int i=2;i<=n;i++){
            count = first+second;
            first = second;
            second = count;
            count = count%1000000007;

        }
        return count;

    }

}
