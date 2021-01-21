package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 69. x 的平方根
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/20 22:27
 */
public class Solution69 {
    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     */

    /**
     * 方法一：袖珍计算器算法
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x==0){
            return 0;
        }
        int ans = (int)Math.exp(0.5*Math.log(x));
        return (ans+1)*(ans+1)<=x? ans+1:ans;
    }

    /**
     *  方法二：二分查找
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        int l=0,r=x,ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if ((long)mid*mid<=x){
                ans = mid;
                l  = mid+1;
            }else{
                r = mid - 1;
            }
        }
        return ans;

    }
}
