package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 16. 数值的整数次方
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/25 23:02
 */
public class Offer16 {
    /**
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 快速幂法：
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (x==1) return 1;
        long b = n;
        if (b<0){
            x = 1/x;
            b = -b;
        }
        double res = 1;
        while(b>0){
            if ((b&1)==1) res = res*x;
            x = x*x;
            b = b>>1;
        }
        return res;
    }

}
