package com.yks.leetcode.array;

/**
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/12 21:22
 */
public class maxSubArray {
    public static void main(String[] args) {


    }

    /**
     * 方法一：动态规划
     * 动态转移方程：{f(i)=max{f(i−1)+ai,ai} 若是f(i-1)是负的，则最大值是ai，若f(i-1)是真的，则最大值为f(i-1)+ai;
     * f(i) 表示0~i项相加的值，用一个数组保存f(i)元素，比较f(i)大小就可以得出最大和的连续数组;
     * f(i)的值只与f(i-1)有关，可以用一个变量维护当前f(i)的f(i-1)的值;
     */
    public static int dynamicPlaneSolution(int[] nums){
        int pre = 0,maxAns = nums[0];

        //遍历nums数组
        for (int x:nums){
            pre = Math.max(pre+x,x); //动态转移方程，求出f(i),变量pre维护当前f(i)的f(i-1)的值
            maxAns =Math.max(maxAns,pre); //比较两个f(i),求出最大值
        }
        return maxAns;
    }




}
