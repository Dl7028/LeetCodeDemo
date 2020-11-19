package com.yks.leetcode.array;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description: 1431. 拥有最多糖果的孩子
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/18 22:14
 */
public class Solution1431 {

    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     *
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     *
     * 示例：
     * 输入：candies = [2,3,5,1,3], extraCandies = 3
     * 输出：[true,true,true,false,true]
     * 解释：
     * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
     * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
     * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
     * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     *
     */

    /**
     * 我的解法，暴力解法，
     * 把元素加上整数的结果与每一个元素比较，若比所有元素大，则list集合增加一个true，反之增加一个false
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<Boolean>();
        int count = 0;
        for (int i = 0; i < candies.length;i++){
            for (int j = 0; j < candies.length;j++){
                if(candies[i]+extraCandies>candies[j]||candies[i]+extraCandies==candies[j]){
                    count++;
                }
            }
            if (count==candies.length){
                list.add(true);
                count = 0;
            }else{
                list.add(false);
                count = 0;
            }
        }
        return list;
    }

    /**
     * 官方答案，
     * 1.遍历数组，找出小朋友中糖果最多的那一个
     * 2.遍历数组，每一个元素加上整数与最多的糖果比较
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandiesAnswer1(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]); //最多的糖果
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies); //小于最多的糖果为false，大于则是true
        }
        return ret;
    }


}
