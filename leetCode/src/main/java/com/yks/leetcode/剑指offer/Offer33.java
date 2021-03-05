package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/5 22:41
 */
public class Offer33 {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     *
     *  
     *
     * 参考以下这颗二叉搜索树：
     *
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     * 示例 1：
     *
     * 输入: [1,6,3,2,5]
     * 输出: false
     * 示例 2：
     *
     * 输入: [1,3,2,6,5]
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 方法一：递归分治
     *  1.划分左右子树
     *  2.是否是二叉搜索树
     *  3.向下递归
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    public boolean recur(int[] postorder,int i ,int j ){
        if (i>=j) return true;
        int p = i;
        while(postorder[p]<postorder[j]) p++;      //第一步，划分左右子树
        int m = p;
        while(postorder[p]>postorder[j]) p++; //判断是否是二叉搜索树
        return  p == j&& recur(postorder,i,m-1)&&recur(postorder,m,j-1);
    }
}
