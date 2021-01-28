package com.yks.leetcode.精选TOP面试题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description: 169. 多数元素
 * @Author: Yu ki-r
 * @CreateDate: 2020/12/4 22:44
 */
public class Solution169 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例：
     * 输入: [3,2,3]
     * 输出: 3
     *
     */

    /**
     * 方法1:哈希表
     * 算法思路：
     * 1.把nums数组遍历保存在hash表中，记录每个元素在数组中的数量
     * 2.求出hash表中，元素最多的那个值
     *
     * @param nums
     * @return
     */
    public int majorityElementAnswer(int[] nums) {
        HashMap<Integer, Integer> hash = countNum(nums);  // 把第一步的结果放进hash 中
//        int max = 0;
        Map.Entry<Integer, Integer> MAX = null;
        //第二步，遍历hash表
        for (Map.Entry<Integer, Integer> entry:hash.entrySet()){
            if (MAX == null || entry.getValue() > MAX.getValue()){
                MAX = entry;
            }
        }
        return MAX.getKey();
    }

    /**
     * 方法1 的 第一步
     * @param nums
     * @return
     */
    private HashMap<Integer, Integer> countNum(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i:nums) {
            if (!hash.containsKey(i)){
                hash.put(i,1); //若哈希表中没有这个元素，数量设为1
            }else{
                hash.put(i,hash.get(i)+1);//若哈希表中有这个元素，数量加一
            }
        }
        return hash;
    }

    /**
     * 方法2 排序
     * 先排序，找到n/2位置的值，返回
     * @param nums
     * @return
     */
    public int majorityElementAnswer2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    /**
     * 挑取随机数
     * @param rand
     * @param min
     * @param max
     * @return
     */
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    /**
     * 验证
     * @param nums
     * @param num
     * @return
     */
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 方法3：随机化
     * 思想：
     * 因为超过 n/2的数组下标被众数占据了，这样我们随机挑选一个下标对应的元素并验证，有很大的概率能找到众数。

     * 由于一个给定的下标对应的数字很有可能是众数，我们随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选。
     *
     * @param nums
     * @return
     */
    public int majorityElementAnswer3(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            } 
        }
    }


}
