package com.yks.leetcode.剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 剑指 Offer 03. 数组中重复的数字
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/21 23:41
 */
public class Offer03 {



  public int findRepeatNumber(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++){
      if (!set.add(nums[i])){
        return nums[i];
      }
    }
    return -1;
  }
}
