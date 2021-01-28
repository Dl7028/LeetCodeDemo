package com.yks.leetcode.精选TOP面试题;

/**
 * @Description: 108. 将有序数组转换为二叉搜索树
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/23 23:19
 */
public class Solution108 {

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 示例：
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     */

    /**
     * 1.把数组分为2块，根节点左侧是0-n/2的数组，右侧是n/2-n的数组
     * 2.递归
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums,0,nums.length-1);

    }

    /**
     *  递归左右子树
     * @param nums 数组
     * @param start 开始的下标
     * @param end 结束的下标
     * @return
     */
    private TreeNode helper(int[] nums, int start, int end) {
        if (start>end) return null;
        int mid = (start+end+1)/2;
        TreeNode root = new TreeNode(nums[mid]); //中间的下标作为根节点
        root.left = helper(nums,start,mid-1);  //递归左子树
        root.right = helper(nums,mid+1,end); //递归右子树
        return root;
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }
}
