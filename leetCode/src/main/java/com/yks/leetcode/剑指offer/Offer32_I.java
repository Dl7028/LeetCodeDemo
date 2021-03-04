package com.yks.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @Description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/4 11:07
 */
public class Offer32_I {
    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
     * 返回：
     *
     * [3,9,20,15,7]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */



     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    /**
     * 广度优先遍历，使用队列，先进先出
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return new int[0];
        queue.offer(root);
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }
        int[] res = new int[list.size()];
        for (int i =0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
