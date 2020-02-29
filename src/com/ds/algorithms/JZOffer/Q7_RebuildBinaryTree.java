package com.ds.algorithms.JZOffer;

import com.ds.algorithms.tree.TreeNode;
import java.security.InvalidParameterException;
import java.util.ArrayList;


public class Q7_RebuildBinaryTree {

    public static TreeNode reConstructBinaryTree(ArrayList<Integer> pre, ArrayList<Integer> in){

        if(pre==null || in==null || pre.size()==0 || in.size()==0)
            return null;
        return recurse(pre, 0, pre.size()-1, in, 0, in.size()-1);
    }


    public static TreeNode recurse(ArrayList<Integer> pre, int pre_l, int pre_r, ArrayList<Integer> in, int in_l, int in_r){
        if(pre_l > pre_r)
            return null;
        if(pre_l == pre_r || in_l == in_r){
            if (in_l==in_r && pre_l == pre_r && pre.get(pre_l).equals(in.get(in_l)))
                return new TreeNode(pre.get(pre_l));
            else
                throw new InvalidParameterException("invalid input");
        }
        TreeNode root = new TreeNode(pre.get(pre_l));
        int in_root_pos = in.indexOf(pre.get(pre_l));
        if (in_root_pos > in_l)
            root.left = recurse(pre, pre_l+1,in_root_pos-in_l+pre_l, in, in_l, in_root_pos-1);
        if (in_root_pos < in_r)
            root.right = recurse(pre, in_root_pos-in_l+pre_l+1, pre_r, in, in_root_pos+1, in_r);
        return root;
    }
}
