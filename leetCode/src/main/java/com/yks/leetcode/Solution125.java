package com.yks.leetcode;

import static java.lang.Character.isLetterOrDigit;

/**
 * @Description: 125. 验证回文串
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/20 17:29
 */
public class Solution125 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     */

    /**
     * 双指针法
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s==null&&s.length()==1){
            return true;
        }
        int start = 0;  //第一个指针指向字符串的第一个字符
        int end = s.length() - 1; //第二个指针指向字符串的最后一个字符
        while(start<end){
            while(!Character.isLetterOrDigit(s.charAt(start))&&start<end){
                start++;
            }
            while(!Character.isLetterOrDigit(s.charAt(end))&&start<end){
                end--;
            }
            if (start<end){
                if (Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                    return false;
                }
            }

            start++;
            end--;
        }
        return true;
    }

}
