package com.yks.leetcode.精选TOP面试题;

import com.yks.leetcode.精选TOP面试题.utils.ArrayUtils;

/**
 * @Description: 283. 移动零
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/19 20:58
 */
public class Solution283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */

    public static void main(String[] args) {

        int[] inputs = ArrayUtils.gennerateArray(10, 5);

        for (int i = 0; i < inputs.length; i++){
            System.out.print(inputs[i]+",");
        }
        System.out.print("\n==========\n");

        int[] result = moveMyZeroes(inputs);

        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+",");

        }

    }


    /**
     *  有额外数组的解法
     * @param nums
     * @return
     */
    public static int[] moveMyZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int j=0;
        for (int i = 0; i < nums.length; i++){
           if (nums[i]!=0){
               result[j++] = nums[i];
           }
        }
        return result;
    }

    /**
     *  不使用额外数组，原数组操作
     *  双层for循环
     *  [0,1,0,3,12]
     *  i=0,j=1 1 0 0 3 12
     *  i=0,j=2 1 0 0 3 12
     *  i=0,j=3 1 0 3 0 12
     *  i=0,j=4 1 0 3 12 0
     *  i=1,j=2 1 3 0 12 0
     *
     * 时间复杂度O（n^2）
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length;j++){
                if (nums[i]==0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    /**
     * 官方答案：双指针
     * 左指针指向处理好的序列尾部，右指针指向待处理序列的头部
     * 每次又指针指向非零数，左右指针对应的数交换，同时左指针右移
     *
     * 1.左指针左边均为非零数；
     * 2.右指针左边直到左指针处均为零。
     * [0,1,0,3,12]
     * 左指针 指向0，右指针指向0，右指针向右移，指向1，交换 [1,0,0,3,12]
     * 左指针右移，指向0，右指针指向0，右移，右指针指向3，交换，[1,3,0,0,12]
     * 左指针右移，指向0，右指针指向12， 交换 [1,3,12,0,0]
     *
     * 时间复杂度O（n）
     * @param nums
     */
    public void moveZeroesAnswer(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
