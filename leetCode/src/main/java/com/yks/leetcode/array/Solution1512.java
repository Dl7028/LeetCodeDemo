package com.yks.leetcode.array;

import com.yks.leetcode.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1512. 好数对的数目
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/16 23:16
 */
public class Solution1512 {

    /**
     * 给你一个整数数组 nums 。
     *
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     *
     * 返回好数对的数目。
     */

    public static void main(String[] args) {

        int[] inputs = ArrayUtils.gennerateArray(4, 10);

        for (int i = 0; i < inputs.length; i++){
            System.out.print(inputs[i]+",");
        }
        System.out.print("\n==========\n");

        int result = numIdenticalPairs(inputs);
            System.out.print(result+",");

    }

    /**
     * 输入：nums = [1,2,3,1,1,3]
     * 输出：4
     * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        int count = 0; //计算好数对的数量
        for (int i = 0; i < nums.length;i++){
            for (int j = 0; j < nums.length;j++){
                //元素相同，输出下标
                if (i!=j){
                    if (nums[i]==nums[j]){
                        count++;
                    }
                }

            }
        }
        return count/2;
    }

    /**
     *  官方答案1：暴力统计
     *  对于每个ai，枚举所有的aj（j>i），检查是否满足ai=aj，如果是就计入答案
     * @param nums
     * @return
     */
    public int numIdenticalPairsAnswer1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    /**
     * 官方答案2： 组合计数
     * 用哈希表统计每个数在序列中出现的次数，假设数字 k 在序列中出现的次数为 v，那么满足题目中所说的
     * num[i] = num[j] = k(i<j)的（i,j）的数量就是v*（v-1）/2，即 kk 这个数值对答案的贡献是v*（v-1）/2，
     * 我们只需要把所有数值的贡献相加，即可得到答案
     * @param nums
     * @return
     */
    public int numIdenticalPairsAnswer2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }

        return ans;
    }



}
