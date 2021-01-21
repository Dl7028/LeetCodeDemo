package com.yks.leetcode.精选TOP面试题.offer;

/**
 * @Description: 剑指 Offer 58 - II. 左旋转字符串
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 20:37
 */
public class Offer58 {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 输入: s = "ab cdefg", k = 2
     * 输出: "cdefg ab"
     *
     */

    public static void main(String[] args) {

    }


    /**
     *  abcdefg
     *  cdefg ba
     *
     *  cdefg ab
     *
     * 1.把ab cdefg 分成两个部分
     * 2.先翻转ab部分得 ba
     * 3.后翻转cdefg部分得 gfedc
     * 4.拼接在一起 bagfedc
     * 5.翻转整个字符串 cdefgab
     **/


    /** 方法一：切片 用substring()
     * @param s 需要翻转的字符串
     * @param n 翻转前n个字符串
     * @return 翻转后的字符串
     */
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }

    /**
     *  方法二： 列表遍历拼接 ，用StringBuilder
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for (int i = 0; i <n;i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    /**
     *  方法三：字符串遍历拼接，用String
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords3(String s, int n) {
       String res = "";
       for (int i = n; i <s.length(); i++)
           res += s.charAt(i);
       for (int i = 0; i < n; i++)
           res += s.charAt(i);
       return res;

       // 求余简化代码
      /* for (int i = n; i < n+s.length(); i++)
           res += s.charAt(i%s.length());
       return res;*/
    }
}

