package com.yks.leetcode.精选TOP面试题;

import java.math.BigInteger;

/**
 * @Description: 172. 阶乘后的零
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/20 20:39
 */
public class Solution172 {
    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * 示例 1:
     *
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * 示例 2:
     *
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     */
    /**
     * 方法一：计算阶乘
     * 1.计算阶乘
     * 2.计算末尾0的数量
     * 在 Java 中，我们需要使用 BigInteger，防止在计算阶乘的过程中溢出。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
       BigInteger nFactorial = BigInteger.ONE;
       //计算阶乘
       for (int i = 2; i <= n; i++){
           nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
       }
       //计算末尾0的数量
       int zeroCount = 0;
       while(nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
           nFactorial = nFactorial.divide(BigInteger.TEN);
           zeroCount++;
       }
       return zeroCount;
    }

    /**
     * 方法二：计算因子 5
     *  因为n阶乘中，结果末尾的0来自因子2,5，因为2的数量永远比5多，所以只需要计算5的数量，注意：25中有两个因子5
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        int count = 0;
        for (int i = 5; i <=n;i+=5){
            int s = i;
            while(s%5==0){
                count++;
                s/=5;
            }
        }
        return count;
    }


    /**
     * 方法三：高效的计算因子 5
     * @param n
     * @return
     */
    public int trailingZeroes3(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);  //计算因子5的个数
            currentMultiple *= 5; //考虑到25，有两个因子5，这里乘以5，再用n去除，则会得到25中两个因子5的另一个
        }
        return zeroCount;

    }


}
