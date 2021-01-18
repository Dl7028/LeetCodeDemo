package com.yks.leetcode;

/**
 * @Description: 38. 外观数列
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/17 20:38
 *
 */
public class Solution38 {
    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * 前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     *
     */
    /**
     * 双指针法
     * 从左往右遍历 pre，当元素相同时，移动 end 指针，直至元素不相同时，那么此时 end-start 就是相同元素的个数，而 start 指针指向的元素就是重复的元素，进行拼接，cur += str(end-start)+pre[start]。
     * 此时要让 start 指向 end 所在的位置，开始记录下个元素出现的次数；
     * 重复上面的步骤，直至 end 指针到达序列项尾部，便可得到当前项。
     *
     * @param n
     *
     * @return
     */
    public String countAndSay2(int n) {
        StringBuffer pre = new StringBuffer("1");
        StringBuffer curr = new StringBuffer("1");

        for (int i=1;i<n;i++){
            pre = curr;
            curr = new StringBuffer();
            int start = 0,end = 0; //双指针，start指向第一个位置，end指向与start值不同的位置， Integer.valueOf(end-start) pre.charAt(start)
            while(end<pre.length()){
                while(end<pre.length()&&pre.charAt(start)==pre.charAt(end)){
                    end++;
                }
               curr = curr.append(Integer.valueOf(end-start)).append(pre.charAt(start));
                start = end;
            }
        }
        return String.valueOf(curr);
    }

    /**
     * 方法二：递归
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        //第一行就直接输出
        if (n == 1) {
            return "1";
        }
        //得到上一行的字符串
        String last = countAndSay2(n - 1);
        //输出当前行的字符串
        return getNextString(last);

    }

    private String getNextString(String last) {
        //长度为 0 就返回空字符串
        if (last.length() == 0) {
            return "";
        }
        //得到第 1 个字符重复的次数
        int num = getRepeatNum(last);
        // 次数 + 当前字符 + 其余的字符串的情况
        return num + "" + last.charAt(0) + getNextString(last.substring(num));
    }

    //得到字符 string[0] 的重复个数，例如 "111221" 返回 3
    private int getRepeatNum(String string) {
        int count = 1;
        char same = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (same == string.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

}
