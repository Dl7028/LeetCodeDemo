package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 位运算：191. 位1的个数
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/27 20:44
 */
public class Solution191 {

    public static void main(String[] args) {
//        decToBin(10);
        String str = String.valueOf(decToBin(521));
        System.out.print(str);
    }


    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * 示例
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     *
     */

    /**
     * 思想：逐一检测n的每一位是否为1
     * 实现：用一个计数变量bits 和 一个检验变量 mask
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;//00000000000000000000000000000001
        for (int i = 0; i < 32; i++){
            if ((n & mask)!=0){ //判断这个位置的数是否为1
                bits++;
            }
            mask <<= 1; //位数左移 00000000000000000000000000000010
        }
        return bits;
    }

    /**
     * 方法 2：位操作的小技巧
     * 思想：不再检查数字的每一个位，而是不断把数字最后一个1反转，并把答案加一。
     * 关键想法：将n与n-1做与运算，会把最后一个1的位变成0.
     * @param n
     * @return
     */
    public int hammingWeightAnswer(int n) {
        int sum = 0;
        while(n!=0){ //当n = 0时，即此刻已经没有1了，返回结果
            sum++;
            n = n&(n-1); //把n的最后一个1变成0
        }
        return sum;
    }

    /**
     * 十进制转二进制
     *  输入10
     *  decToBin(10)  ->    0
     *  -> decToBin(10/2)-> 1
     *  -> decToBin(5/2) -> 0
     *  -> decToBin(2/2) -> 1
     *
     * @param n 十进制整数
     */
    private static String decToBin(int n) {
        StringBuilder sb = new StringBuilder();
        if (n==0||n==1){
//            System.out.print(n);
            sb.append(n);
        }else{
            decToBin(n/2); //递归，每次都除以2，从后面往前面打印
//            System.out.print(n%2); //求余2
            sb.append(n%2);
        }
        return String.valueOf(sb);

    }
}
