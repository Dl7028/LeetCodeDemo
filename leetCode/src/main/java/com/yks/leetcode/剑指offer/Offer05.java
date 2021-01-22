package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 05. 替换空格
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/22 18:54
 */
public class Offer05 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     */

    /**
     * 方法一：借助StringBuilder
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                result.append("%20");
            }else{
                result.append(s.charAt(i));
            }
        }
        return String.valueOf(result);
    }

    /**
     *
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                count++;
            }
        }
        int newLength = s.length()+2*count;
        int p=s.length()-1,q = newLength-1;
        char arrays[] = new char[newLength];
        while(p>=0){
            if (s.charAt(p)==' '){
                arrays[q]='0';
                arrays[q-1]='2';
                arrays[q-2] = '%';
                p--;
                q = q-3;
            }else{
                arrays[q] = s.charAt(p);
                p--;
                q--;
            }
        }
        return new String(arrays,0,newLength);
    }
}
