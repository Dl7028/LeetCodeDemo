package com.yks.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/4 16:49
 */
public class Offer32_II {
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     *  
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }


    /**
     * 思路：使用 Queue 保存打印的节点，用变量 toBePrint 表示当前层中还没打印的节点数，当toBePrint为0时，表示当前层中的节点全都打印结束
     * 用变量 nextLevel 表示下一层中节点的个数。
     * @param root 根节点
     * @return 返回值
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return new ArrayList<>(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int toBePrint = 1,nextLevel =0;
        List<Integer> list = new ArrayList<>();
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            list.add(node.val);

            toBePrint--;
            if (node.left!=null){
                nextLevel++;
                queue.offer(node.left);
            }
            if (node.right!=null){
                nextLevel++;
                queue.offer(node.right);
            }
            if (toBePrint==0){
                toBePrint = nextLevel;
                nextLevel = 0;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }


    /**
     * 方法二：
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        while(queue.size()!=0){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            temp.add(list);
        }
        return temp;
    }
}
