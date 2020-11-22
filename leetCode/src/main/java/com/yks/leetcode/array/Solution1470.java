package com.yks.leetcode.array;

import com.yks.leetcode.utils.ArrayUtils;

/**
 * @Description: 重新排列数组
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/14 21:14
 */
public class Solution1470 {
    /**
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     */


    public static void main(String[] args) {
        ArrayUtils.printResult(new getArray());

    }



    public static int[] shuffle(int[] nums, int n) {
        /**
         * n=3 下标 n
         * 0  1    2   3   4   5   6   7   8
         * 0  n    1  n+1  2  n+2  3  n+3  4
         */
        int j = 0;
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length-1; i++){
            if (i%2==1){
                result[i] = nums[n+j];
                j++;
            }else{
                result[i] = nums[i/2];
            }

        }
        return result;
    }



    private static class getArray implements ArrayUtils.GetArray {
        @Override
        public void getArray(int[] a) {
            int[] b = shuffle(a,4);
            for (int i = 0; i < b.length; i++){
                System.out.print(b[i]+"   ");
            }
        }
    }


}
