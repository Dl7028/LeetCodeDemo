package com.yks.leetcode.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 剑指 Offer 07. 重建二叉树
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/22 20:18
 */
public class Offer07 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *
     */
      public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


    /**
     * 方法一：递归
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {


          if (preorder.length==0||preorder==null){
              return null;
          }
          Map<Integer, Integer> map = new HashMap<Integer, Integer>();
          for(int i = 0; i <inorder.length; i++){
              map.put(inorder[i],i);             //记录中序遍历的元素的下标
          }
          int length = preorder.length;
          TreeNode root  = buildTree(preorder,0,length-1,inorder,0,length-1,map);
          return root;
    }

    /**
     * 递归函数
     * @param preorder
     * @param preorderStart
     * @param preorderEnd
     * @param inorder
     * @param inorderStart
     * @param inorderEnd
     * @param map
     * @return
     */
    public TreeNode buildTree(int[] preorder,int preorderStart,int preorderEnd,int[] inorder,int inorderStart,int inorderEnd,Map<Integer,Integer> map){

        if (preorderStart>preorderEnd){ //若开始大于结束，则当前的二叉树中没有节点，
            return null;
        }

        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart==preorderEnd){ //若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
            return root;
        } else{
            int rootIndex = map.get(rootVal); //获取中心节点的坐标
            int leftNodes = rootIndex-inorderStart,rightNodes = inorderEnd-rootIndex;//左节点数量和右节点数量

            TreeNode leftTree = buildTree(preorder,preorderStart+1,preorderStart+leftNodes,inorder,inorderStart,rootIndex-1,map);
            TreeNode rightTree=buildTree(preorder,preorderEnd-rightNodes+1,preorderEnd,inorder,rootIndex+1,inorderEnd,map);

            root.left=leftTree;
            root.right=rightTree;
            return root;
        }
    }

}
