package com.yks.leetcode;

import java.util.Arrays;

/**
 * @Description: 204. 计数质数
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/21 22:52
 */
public class Solution204 {
    /**
     *统计所有小于非负整数 n 的质数的数量。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 示例 2：
     *
     * 输入：n = 0
     * 输出：0
     * 示例 3：
     *
     * 输入：n = 1
     * 输出：0
     *
     */
    /**
     * 方法一：暴力法
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        int count = 0;
        for(int i=2;i<n;i++){
            count +=isPrime(i)?1:0;
        }
        return count;
    }
    public boolean isPrime(int x){
        for(int i=2;i*i<=x;i++){
            if (x%i==0){
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：埃氏筛
     * 我们设 isPrime[i] 表示数 ii 是不是质数，如果是质数则为 11，否则为 00。从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），
     * 即 00，这样在运行结束的时候我们即能知道质数的个数。
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        int count = 0;
        for (int i=2;i<n;i++){
            if (isPrime[i]==1){
                count++;
            }
            if ((long)i*i<n){
                for (int j=i*i;j<n;j+=i){
                    isPrime[j] =0;
                }
            }
        }
        return count;
    }
}
