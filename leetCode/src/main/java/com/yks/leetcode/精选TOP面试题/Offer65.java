package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 剑指 Offer 65. 不用加减乘除做加法
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/20 19:54
 */
public class Offer65 {

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * 示例：输入: a = 1, b = 1
     * 输出: 2
     *
     */

    /**
     * 第一步：不考虑进位对每一位相加，0+0,1+1 结果都是0,0+1，1+0 结果都是1 ，相当于异或运算 ^
     * 第二步：进位，两个数先做位与运算&，再向左移动一位<<，0+0,0+1,1+0 时都不会产生进位，只有1+1 时会产生进位
     * 第三部：把第一，二步的结果相加 ,因为相加不能用+，所以需要重复12步骤，知道第二步骤的结果为0
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int c,d;
        if (b==0) {
            return a;
        }
        c = a^b;
        d = (a&b)<<1;
        return add(c,d);
    }
}
