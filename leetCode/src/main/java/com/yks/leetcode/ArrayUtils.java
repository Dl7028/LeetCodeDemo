package com.yks.leetcode;

/**
 * @Description:    数组的工具类
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/13 11:04
 */
public class ArrayUtils {

    /**
     * 生成随机数组
     *
     * @param len 长度
     * @param max 最大值
     * @return
     */
    public static int[] gennerateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }


}