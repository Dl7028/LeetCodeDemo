package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 171. Excel表列序号
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/29 20:49
 */
public class Solution171 {
    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * 示例
     *    A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     *     ABC
     *   = 1*26^2+2*26^1+3*26^0
     *
     *  result = 3*26^0+2*26^2+
     *
     */
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            result+=(int) ((s.charAt(s.length()-1-i)-64)*Math.pow(26,i));
        }
        return result;
    }
}
