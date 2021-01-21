package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 70. 爬楼梯
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/19 22:11
 */
public class Solution70 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     */

    /**
     * 方法一：动态规划 f(x) = f(x-1)+f(x-2)
     * 空间复杂性度O（n）
     * 时间复杂度O（n）
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1]=1;  //爬一阶楼梯，有一种方法
        dp[2]=2; //爬二阶楼梯， 有 两种方法
        for (int i =3;i<=n;i++){   //动态规划，f(x) = f(x-1)+f(x-2)
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    /**
     * 方法二：动态规划，用滚动数组记录n-1和n-2两个状态
     * 空间复杂度O（1）
     * 时间复杂度O（n）
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int first =1;
        int second =2;
        int third = first +second;
        for (int i=3;i<=n;i++){
            third = first+second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 方法三：递归(超出时间限制)
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
       if (n==1){
           return 1;
       }
       if (n==2){
           return 2;
       }
       return climbStairs3(n-1)+climbStairs3(n-2);
    }

    /**
     * 方法四：记忆化递归
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
       int[] remember = new int[n+1];  //用一个数组存放求过的值
       return climbStairs4Memory(n,remember);
    }

    public int climbStairs4Memory(int n,int memeo[]){
        if (memeo[n]>0){  //若数组中有，则直接返回
            return memeo[n];
        }
        if (n==1){
            return 1;
        }else if(n==2){
            memeo[n]=2;
        }else{
            memeo[n] = climbStairs4Memory(n-1,memeo)+climbStairs4Memory(n-2,memeo); //递归
        }
        return memeo[n];
    }


}
