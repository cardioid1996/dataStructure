package com.ds.algorithms;


import com.sun.deploy.panel.TreeRenderers;

import java.util.Stack;

public class PaperFolding {
    public void printPaper(int n){
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = constructTree(st, n);
        // down:-1, up:1
        InorderTraverseNoRecurse.traverse(root);
    }

    public TreeNode constructTree(Stack<TreeNode> st, int n){
        if (n == 0)
            return null;
        else{
            if (st.isEmpty())
                st.push(new TreeNode(-1));
            else{
                while (true){}
            }

        }
        return null;

    }
}
