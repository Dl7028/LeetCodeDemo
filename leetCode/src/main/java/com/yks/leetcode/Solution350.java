package com.yks.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 350. 两个数组的交集 II
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/19 17:36
 */
public class Solution350 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     *
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     */

    /**
     * 方法一：哈希表法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //如果nums2的长度比nums1的长度小，交换nums1个nums2的位置
        if (nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }

        //遍历nums1
        for (int i = 0; i < nums1.length; i++){
            int count = map.getOrDefault(nums1[i],0)+1; //count 是 nums[]元素中的数量，每次放入map中前都要判断map中这个元素的数量，若map中有这个元素，则+1再放入，若没有，则放入1
            map.put(nums1[i],count);
        }
        //此时map中存放着nums1中 的元素和各个元素的数量
        //求出nums2中与map中相同的元素和个数，并放入新的数组中
        int[] res = new int[nums1.length];
        int index = 0;
        //找出nums2中与map相同的元素
        for(int num : nums2){
          int count = map.getOrDefault(num,0);
          if (count>0){
              res[index++] = num;
              count--;
              if(count>0){
                  map.put(num,count);
              }else{
                  map.remove(num);
              }
          }

        }
        return Arrays.copyOfRange(res,0,index);
    }

    /**
     * 方法二，先排序，后用双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       int[] res = new int[Math.min(nums1.length,nums2.length)];
       int index1 = 0,index2 = 0,index = 0;
       while(index1<nums1.length&&index2<nums2.length){
           if (nums1[index1]<nums2[index2]){
               index1++;
           }else if (nums1[index1]>nums2[index2]){
               index2++;
           }else {
               res[index] = nums1[index1];
               index++;
               index2++;
               index1++;
           }
       }

       return Arrays.copyOfRange(res,0,index);
    }
}
