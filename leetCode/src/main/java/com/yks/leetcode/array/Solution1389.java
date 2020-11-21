package com.yks.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1389. 按既定顺序创建目标数组
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/21 22:55
 */
public class Solution1389 {
    /**
     * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
     *
     * 目标数组 target 最初为空。
     * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
     * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
     * 请你返回目标数组。
     *
     * 题目保证数字插入位置总是存在。
     * 示例：
     * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
     * 输出：[0,4,1,3,2]
     * 解释：
     * nums       index     target
     * 0            0        [0]
     * 1            1        [0,1]
     * 2            2        [0,1,2]
     * 3            2        [0,1,3,2]
     * 4            1        [0,4,1,3,2]
     *
     */

    /**
     *  利用顺序表
     *  1.在当前的下标为从0开始长度为n的顺序表的i位置插入元素
     *  2.把原来表中区间[i,n]中的元素全部向后移动一位
     *  3.在i位置插入带插入的元素
     *  add()是添加，区别于一般的add(E e)，这个就是有个位置的概念，特殊位置之后的数据，依次往后移动
     * @param nums
     * @param index
     * @return
     */
    public int[] createTargetArrayAnswer(int[] nums, int[] index) {

        List<Integer> list = new ArrayList<Integer>();
        //遍历nums,index数组
        //nums= [0,1,2,3,4] index = [0,1,2,2,1]
        /**
         * list :
         * (0,0)
         * (1,4)
         * (2,1)
         * (3,3)
         * (4,2)
         *
         */
        for (int i = 0; i < nums.length; i++){
            list.add(index[i],nums[i]); // add（int i，E e）按顺序添加数据，若位置冲突，位置后面的数据往后移动
        }

        int[] target = new int[nums.length];
        /**
         * target[]
         */
        for(int i = 0; i < nums.length; i++){
            target[i] = list.get(i);
        }
        return target;
    }
}
