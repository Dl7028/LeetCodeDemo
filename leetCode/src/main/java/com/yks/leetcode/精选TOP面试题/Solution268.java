package com.yks.leetcode.精选TOP面试题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 268. 丢失的数字
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/17 17:07
 */
public class Solution268 {

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     * 示例 1：
     *
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：2
     * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 3：
     *
     * 输入：nums = [9,6,4,2,3,5,7,0,1]
     * 输出：8
     * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 4：
     *
     * 输入：nums = [0]
     * 输出：1
     * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
     *
     */

    /**
     * 方法一：哈希表
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Set<Integer> hash = new HashSet<Integer>();
        //把数组中的每一个元素放入哈希表中
        for (int num : nums) {
            hash.add(num);
        }

        for (int i = 0; i < nums.length+1; i++){ //哈希表中的元素依次与0...n 比较，找出哈希表中没有的元素
            if (!hash.contains(i)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二：排序
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length-1]!=nums.length){
            return nums.length;
        }
        else if (nums[0]!=0){
            return 0;
        }
        for (int i =1 ;i<nums.length; i++){
            if (i!=nums[i]){
                return i ;
            }
        }
        return -1;
    }



}
