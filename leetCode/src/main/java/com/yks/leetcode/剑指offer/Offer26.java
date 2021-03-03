package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 26. 树的子结构
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/3 19:58
 */
public class Offer26 {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    /**
     * 第一步，找出树A中与树B根节点一样的节点R（递归）
     * 第二步，比较R节点与B节点左右节点是否相等（递归）
     * @param A
     * @param B
     * @return
     */
    public boolean compareTreeVal(TreeNode A, TreeNode B) { //第二步，比较相等的根节点下的子树是否相等
        if (B==null)
            return true;
        if (A==null) {
            return false;
        }
        if (A.val!=B.val)
            return false;
        return compareTreeVal(A.left,B.left)&&compareTreeVal(A.right,B.right);
    }



    public boolean isSubStructure(TreeNode A, TreeNode B) { //第1步,比较根节点是否相等
        boolean result = false;
        if (A!=null&&B!=null) {

            if (A.val == B.val) {
                result = compareTreeVal(A, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
        }
        return  result;
    }
}
