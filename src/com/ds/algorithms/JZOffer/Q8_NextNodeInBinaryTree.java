package com.ds.algorithms.JZOffer;

import algorithms.tree.TreeNode;

public class Q8_NextNodeInBinaryTree {
    /** 找到二叉树中序遍历下，某个结点的后继结点 **/

    public static TreeNode findNext(TreeNode node){

        if(node == null)
            return null;

        TreeNode help = new TreeNode(0);
        if(node.right != null){
            // has right children, return the most left node of right child
            help = node.right;
            while (help.left != null)
                help = help.left;
            return help;
        }
        else{
            // no right children
            help = node.parent;
            while (help != null){
                if(node == help.left){
                    return help;
                }
                node = help;
                help = help.parent;
            }
            return null;
        }
    }
}
