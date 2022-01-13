package com.example.algorithm.datastructure.tree;


/**
 * 树遍历
 *
 * @author liugang
 * @create 2022/1/8
 */
public class TreeOrderExample {

    /**
     * 先序遍历
     *
     * @param treeNode
     */
    public void preOrder(TreeNode treeNode) {
        System.out.println(treeNode.data);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public void inOrder(TreeNode treeNode) {
        inOrder(treeNode.left);
        System.out.println(treeNode.data);
        inOrder(treeNode.right);
    }

    public void postOrder(TreeNode treeNode) {
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.data);
    }

    public static class TreeNode {
        private Object data;
        private TreeNode right;
        private TreeNode left;
    }

}
