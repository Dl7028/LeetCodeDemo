package com.yks.leetcode.精选TOP面试题.array;

import com.yks.leetcode.精选TOP面试题.utils.ArrayUtils;

/**
 * @Description: 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *              请返回 nums 的动态和。
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/13 10:48
 */
public class Solution1480 {




    public static void main(String[] args) {
        int[] inputs = ArrayUtils.gennerateArray(4, 10);

        for (int i = 0; i < inputs.length; i++){
            System.out.print(inputs[i]+",");
        }
        System.out.print("\n==========\n");

        int[] result = runningSum(inputs);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+",");
        }
    }


    /**
     * 用 nums 来保存累计加的数据，pre保存第i-1个累加的数据
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {
        int pre = 0;
        int[] sum = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            pre =pre+nums[i]; //0+1=1
            sum[i] = sum[i]+pre;//0+1 = 1
        }
        return sum;
    }
}
