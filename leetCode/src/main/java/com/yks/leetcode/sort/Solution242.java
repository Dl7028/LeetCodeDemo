package com.yks.leetcode.sort;

import java.util.Arrays;

/**
 * @Description: 242. 有效的字母异位词
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/22 20:17
 */
public class Solution242 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    /**
     *1. 用两个数组存放两个字符串的字符
     * 2.比较两个数组存放的字符数量是否相等
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //长度不相等，直接返回false
        if (s.length()!=t.length()){
            return false;
        }
        Boolean match = true;
        int[] countS=new int[26];
        int[] countT=new int[26];
        //把s中的每一个字符放进countS中，并且计算数量
        for (int i = 0; i < s.length(); i++) {
                countS[s.charAt(i)-'a'] +=1;
        }
        //把t中的每一个字符放进countT中，并且计算数量
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i)-'a'] +=1;
        }
        //比较两个数组的元素数量是否相等
        for(int i = 0; i < 26; i++){
            if (countS[i]!=countT[i]){
                match= false;
            }
        }
        return Arrays.equals(countS,countT);
    }


    /**
     *  官方答案
     *  先排序后比较
     *  sort()函数
     *  Arrays.equals(str1, str2)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramAnswer1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     *  官方答案
     *  哈希表
     *  跟自己的解法类似，不同的有
     *  我的解法用的是两个数组计算每一个元素的数量，再比较两个数组
     *  这里用的一个数组，先放元素的数量，遍历t字符串，若数组中有这个元素， 则减去一个，若出现元素的数量小于0的情况，返回false
     *  否则，返回true
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramAnswer2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }




}
