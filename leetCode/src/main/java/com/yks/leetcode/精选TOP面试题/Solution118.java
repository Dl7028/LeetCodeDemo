package com.yks.leetcode.精选TOP面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 118. 杨辉三角
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 19:53
 */
public class Solution118 {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * 分析：
     * 1.杨辉三角第n行有n个数字
     * 2.每个数字都是它左上角的那个数字和右上角的那个数字相加得来，更具体一点这个数字是a(i,j),那么它是a(i-1,j-1)和a(i-1, j)相加得来的
     * 3.第1个数字是1.如果这个数字的左上角或右上角的那个数字不存在，那么就当做0
     */
    /**
     *
     * 思想：动态规划
     *
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(); //一个二维表，放杨辉三角的数据

        //1.行数为0，则 triangle表 是空的
        if (numRows==0){
            return triangle;
        }

        //triangle表 中的第一行数据 是1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        //核心思想，f(i,j) = f(i-1,j-1)+f(i-1,j)
        //从第二行开始循环
        for (int rowNum=1;rowNum<numRows;rowNum++){
            List<Integer> prev ; //triangle表 的上一行数据

            List<Integer> row = new ArrayList<Integer>(); //triangle表 第rowNum行数据

            //获取上一行数据
            prev = triangle.get(rowNum-1);
            //第一个数据是1
            row.add(1);
            //从这一行的第二个开始， 因为第几行就有几个数据，所以遍历到rowNum结束
            for (int i=1;i<rowNum;i++){
                row.add(prev.get(i)+prev.get(i-1));
            }
            //最后一个数字也是1
            row.add(1);
            //把这一行数据放入 triangle表 中
            triangle.add(row);
        }
        return triangle;
    }

}
