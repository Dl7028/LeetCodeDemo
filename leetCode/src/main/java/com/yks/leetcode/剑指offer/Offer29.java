package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 29. 顺时针打印矩阵
 * @Author: Yu ki-r
 * @CreateDate: 2021/2/28 21:27
 */
public class Offer29 {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new int[0]; //
        }

        int rows = matrix.length, columns = matrix[0].length;
        int left = 0,top = 0,right = matrix[0].length-1,bottom = matrix.length-1;
        int[] res = new int[rows*columns];
        int count = 0;
        while(left<=right&&top<=bottom){
            //上面一行，从左到右打印
            for (int column =left;column<=right;column++){
                res[count++] = matrix[top][column];
            }
            //右边一行，从上到下打印
            for(int row = top+1;row<=bottom;row++){
                res[count++] = matrix[row][right];
            }
            //判断最后是否是剩一行或者一列
            if (left<right&&top<bottom){
                //下面一行，从右到左打印
                for (int column =right-1;column>=left;column--){
                    res[count++] = matrix[bottom][column];
                }
                for (int row = bottom-1;row>top;row--){
                    res[count++] = matrix[row][left];
                }


            }
            right--;
            left++;
            top++;
            bottom--;
        }
        return res;
    }

}
