package com.yks.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Description: 387. 字符串中的第一个唯一字符
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/20 14:38
 */
public class Solution387 {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     *  
     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     *
     */

    /**
     * 方法一：哈希表法
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i),0)+1;
            map.put(s.charAt(i),count);
        }
        Character result = 'A';
        for(Character i:map.keySet()){
            if (map.get(i).equals(1)){
                result = i;
                break;
            }
        }
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)==result){
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二：使用哈希表存储频数
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }
}
