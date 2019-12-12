package algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseNoRecursion {

    public static void traverse_layer(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode node = que.poll();
            System.out.println(node.val);
            if(node.left != null)
                que.offer(node.left);
            if(node.right != null)
                que.offer(node.right);
        }
    }


    public static void traverse_preorder(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
    }


    public static void traverse_inorder(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root!=null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }


    public static void traverse_postorder(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            help.push(node.val);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
        while (!help.isEmpty())
            System.out.println(help.pop());
    }
}
