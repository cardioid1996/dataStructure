package algorithms.tree;

import com.ds.algorithms.tree.TreeNode;

public class TraverseRecursion {

    public static void traverse_preorder(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        if(root.left != null)
            traverse_preorder(root.left);
        if(root.right != null)
            traverse_preorder(root.right);
    }


    public static void traverse_inorder(TreeNode root){
        if(root == null)
            return;
        if(root.left != null)
            traverse_inorder(root.left);
        System.out.println(root.val);
        if(root.right != null)
            traverse_inorder(root.right);
    }


    public static void traverse_postorder(TreeNode root){
        if(root == null)
            return;
        if(root.left != null)
            traverse_postorder(root.left);
        if(root.right != null)
            traverse_postorder(root.right);
        System.out.println(root.val);
    }
}
