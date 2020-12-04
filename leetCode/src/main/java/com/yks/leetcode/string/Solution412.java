package com.yks.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 412. Fizz Buzz
 * @Author: Yu ki-r
 * @CreateDate: 2020/12/3 23:42
 */
public class Solution412 {
    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 示例：n = 15,
     *
     * 返回:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     *
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n+1; i++){

            if (i%15==0){
                list.add("FizzBuzz");
            } else if (i%3==0){
                list.add("Fizz");
            }else if (i%5==0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    /**
     * 字符串拼接
     * 我们放弃使用之前的联合判断，取而代之依次判断是否能被给定的数整数。
     * 这道题中，就是依次判断能不能被 3 整除，能不能被 5 整除。
     * 如果能被 3 整除，就把对应的 Fizz 连接到答案字符串，
     * 如果能被 5 整除，就把 Buzz 连接到答案字符串。
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzzAnswer1(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            String numAnsStr = "";

            if (divisibleBy3) {
                // Divides by 3, add Fizz
                numAnsStr += "Fizz";
            }

            if (divisibleBy5) {
                // Divides by 5, add Buzz
                numAnsStr += "Buzz";
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }



}
