package algorithms.tree;

import apple.laf.JRSUIUtils;

public class MorisTraverse {

    public static void moris(TreeNode head){
        if (head == null)
            return;
        TreeNode curr = head;
        while (curr != null){

            if (curr.left != null){
                TreeNode right_most = curr.left;
                while (right_most.right != null && right_most.right!=curr)
                    right_most = right_most.right;
                if(right_most.right == null){
                    // 第一次来到这个结点
                    right_most.right = curr;
                    curr = curr.left;
                } else{
                    // 左边已经遍历完了，第二次来到这个结点
                    right_most.right = null;
                    curr = curr.right;
                }
            }else{
                curr = curr.right;
            }
        }
    }

    public static void moris_preorder(TreeNode head){
        if (head == null)
            return;
        TreeNode curr = head;
        while (curr != null){

            if (curr.left != null){
                TreeNode right_most = curr.left;
                while (right_most.right != null && right_most.right!=curr)
                    right_most = right_most.right;
                if(right_most.right == null){
                    // 第一次来到这个结点
                    System.out.println(curr.val);
                    right_most.right = curr;
                    curr = curr.left;
                } else{
                    // 左边已经遍历完了，第二次来到这个结点
                    right_most.right = null;
                    curr = curr.right;
                }
            }else{
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
    }


    public static void moris_inorder(TreeNode head){
        if (head == null)
            return;
        TreeNode curr = head;
        while (curr != null){

            if (curr.left != null){
                TreeNode right_most = curr.left;
                while (right_most.right != null && right_most.right!=curr)
                    right_most = right_most.right;
                if(right_most.right == null){
                    // 第一次来到这个结点
                    right_most.right = curr;
                    curr = curr.left;
                } else{
                    // 左边已经遍历完了，第二次来到这个结点
                    right_most.right = null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }else{
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
    }


    public static void moris_post_order(TreeNode head){

        if (head == null)
            return;

        TreeNode curr = head;
        while (curr != null){

            if (curr.left != null){
                TreeNode right_most = curr.left;

                while (right_most.right != null && right_most.right!=curr)
                    right_most = right_most.right;

                if(right_most.right == null){
                    // 第一次来到这个结点
                    right_most.right = curr;
                    curr = curr.left;
                } else{
                    // 左边已经遍历完了，第二次来到这个结点
                    // 第二次来到某结点时，逆序打印这个结点的左子树的右边界
                    right_most.right = null;
                    printEdge(curr.left);
                    curr = curr.right;
                }

            }else{
                curr = curr.right;
            }
        }
        printEdge(head);
    }


    public static void printEdge(TreeNode head){

        if(head == null)
            return;

        if (head.right == null){
            System.out.println(head.val);
            return;
        }

        TreeNode p = reverse(head);
        TreeNode tail = p;

        while (p != null){
            System.out.println(p.val);
            p = p.right;
        }
        // reverse back
        reverse(tail);
    }


    public static TreeNode reverse(TreeNode head){
        TreeNode p = head;
        TreeNode q = head.right;
        head.right = null;
        TreeNode m = q.right;
        while (q!=null){
            q.right = p;
            p = q;
            q = m;
            if (m != null)
                m = m.right;
        }
        // 返回最后一个
        return p;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        head.left = t2;
        head.right = t3;
        t2.left = t4;
        t2.right = t5;

        MorisTraverse.moris_post_order(head);

    }
}
