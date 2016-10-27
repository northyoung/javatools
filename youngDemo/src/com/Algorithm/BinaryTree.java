package com.Algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunsy3 on 2015/2/13.
 * 二叉树
 */
public class BinaryTree {
    static Logger log =  LoggerFactory.getLogger(BinaryTree.class);

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    private TreeNode root;
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private static class TreeNode{

        public TreeNode(String data ,TreeNode t1 ,TreeNode t2){
            this.data = data ;
            this.leftNode = t1;
            this.rightNode = t2;
        }
        private String data = null;
        private TreeNode leftNode ;
        private TreeNode rightNode ;


        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }

    //递归寻找节点
    public TreeNode getParent(TreeNode element){
        return (root == null || root == element)? null : parent(root, element);
    }

    public TreeNode parent(TreeNode treeNode,TreeNode element){
        if(element == null || treeNode == null ){
            return null;
        }
        if(treeNode.getLeftNode() == element || treeNode.getRightNode() == element){
            return treeNode;
        }
        TreeNode p;
        if( (p = parent(treeNode.getLeftNode() ,element)) != null){
            return p;
        } else {
            return parent(treeNode.getRightNode(), element);
        }
    }

    //节点个数
    public int getSize(){
        return getNum(root);
    }

    public int getNum(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        } else {
            int i = getNum(treeNode.getLeftNode());
            int j = getNum(treeNode.getRightNode());
            return i+j+1;
        }
    }

    //树的高度
    public int getHeight(){
        return getHeight(root);
    }

    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        } else {
            int i = getHeight(node.getLeftNode());
            int j = getHeight(node.getRightNode());
            return (i>j)?i+1:j+1;
        }
    }

    //前序遍历
    public void preOrder(TreeNode node){
        if(node != null){
            System.out.println(node.getData());
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

    //中序遍历
    public void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.getLeftNode());
            System.out.println(node.getData());
            inOrder(node.getRightNode());
        }
    }

    //后序遍历
    public void postOrder(TreeNode node){
        if(node != null){
            postOrder(node.getLeftNode());
            postOrder(node.getRightNode());
            System.out.println(node.getData());
        }
    }

    public static void main(String[] args){
        TreeNode l12 = new TreeNode("left12",null,null);
        TreeNode r12 = new TreeNode("left12",null,null);
        TreeNode l22 = new TreeNode("left12",null,null);
        TreeNode r22 = new TreeNode("left12",null,null);

        TreeNode l1 = new TreeNode("left1", l12, r12);// 根节点左子树
        TreeNode r1 = new TreeNode("right1", l22, r22);// 根节点右子树
        TreeNode root = new TreeNode("root", l1, r1);// 创建根节点

        BinaryTree binTree = new BinaryTree(root);
        log.debug("=======先序遍历======");
        binTree.preOrder(root);
        log.debug("=======中序遍历======");
        binTree.inOrder(root);
        log.debug("=======后序遍历======");
        binTree.postOrder(root);
        //树的高度
        log.debug(String.valueOf(binTree.getHeight()));
        //树的大小
        log.debug(String.valueOf(binTree.getSize()));
    }
}


