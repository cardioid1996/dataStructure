package algorithms.tree;

public class AbstractBinarySearchTree {

    public TreeNode root;

    protected int size;

    public TreeNode search(int target){
        TreeNode res = root;
        while (res != null){
            if (res.val == target)
                return res;
            else if(res.val < target)
                res = res.right;
            else
                res = res.left;
        }
        return null;
    }


    public TreeNode insert(int value){

        TreeNode node = new TreeNode(value);
        if(root == null){
            root = node;
            return root;
        }

        TreeNode curr_root = root;
        TreeNode curr_parent = root;

        while (curr_root != null){
            curr_parent = curr_root;
            if (curr_root.val == value)
                return root;
            else if (curr_root.val < value)
                curr_root = curr_root.right;
            else
                curr_root = curr_root.left;
        }

        if (curr_parent.val < value)
            curr_parent.right = node;
        else
            curr_parent.left = node;

        size++;
        return root;
    }


    public TreeNode delete(int value){
        TreeNode node = search(value);
        if(node == null)
            return null;
        else
            return delete(node);
    }


    protected TreeNode delete(TreeNode node){
        if (node == null)
            return null;


    }

}
