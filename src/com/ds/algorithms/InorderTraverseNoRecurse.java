package com.ds.algorithms;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}

public class InorderTraverseNoRecurse {
    public static void traverse(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> st = new Stack<>();

        while(!(root==null && st.isEmpty())){
            if(root == null){
                root = st.pop();
                System.out.println(root.val);
                root = root.right;

            }
            else{
                st.push(root);
                root = root.left;
            }
        }

    }


}


