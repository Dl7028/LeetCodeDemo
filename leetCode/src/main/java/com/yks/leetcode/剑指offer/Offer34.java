package com.yks.leetcode.剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/6 15:34
 */
public class Offer34 {
    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     *
     *  
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path  = new LinkedList<>();

    /**
     * 思路：回溯法，用先序遍历遍历二叉树，记录每次到达节点时的路径和，使用LinkedList数据结构存放结果
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return result;
    }
    public void recur(TreeNode root,int sum) {
        if (root==null) return;
        int tar = sum ;
        path.addLast(root.val); //1.路径更新： 将当前节点值 root.val 加入路径 path ；

        tar = tar - root.val; //2.目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 00 ）；
        if (tar==0&&root.left==null&&root.right==null) { //路径到达叶节点，且路径和 == sum
            result.addLast(new LinkedList<>(path)); //3.路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。


        }

        recur(root.left,tar);//4.先序遍历： 递归左 / 右子节点。

        recur(root.right,tar);
        path.removeLast(); //5.路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。


    }
}
