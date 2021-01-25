package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 15. 二进制中1的个数
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/25 22:18
 */
public class Offer15 {
    /**
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     *
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * 示例 3：
     *
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 方法一：n右移
     * 有符号时会陷入死循环
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while(n>0){
            if ((n&1)==1) count++;
            n=n>>1;
        }
        return count;
    }

    /**
     * 方法二：flag 左移
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if ((n&flag)!=0) count++;
            flag=flag<<1;
        }
        return count;
    }

    /**
     * 方法三：n&(n-1)
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int count = 0;
        while(n!=0){
            n = (n-1)&n;
            count++;
        }
        return count;
    }
}
