package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 04. 二维数组中的查找
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/22 16:59
 */
public class Offer04 {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *  
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     *  
     *
     */
    /**
     * 方法一：暴力法，直接遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0;i<matrix.length;i++){
            for (int j = 0; j < matrix[i].length;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：线性查找
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row = 0;
        int columns  = matrix[0].length-1;
        while(row<matrix.length&&columns>=0){
            int res = matrix[row][columns];
            if (res==target){
                return true;
            }else if (res<target){
                row++;
            }else if(res>target){
                columns--;
            }
        }
        return false;
    }
}
