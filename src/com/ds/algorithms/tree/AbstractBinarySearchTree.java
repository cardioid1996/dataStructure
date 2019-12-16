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


    protected TreeNode getParent(TreeNode node){
        if(root == null || node == root){
            return null;
        }
        TreeNode curr_root = root;
        TreeNode curr_parent = root;

        while (curr_root != null && curr_root.val != node.val){
            curr_parent = curr_root;
            if (curr_root.val < node.val)
                curr_root = curr_root.right;
            else
                curr_root = curr_root.left;
        }
        return curr_parent;
    }


    public boolean delete(int value){
        TreeNode node = search(value);
        if(node == null)
            return false;
        else
            return delete(node);
    }


    protected boolean delete(TreeNode node){

        if (node != null){
            TreeNode parent = getParent(node);

            if (node.left == null)
                transplant(parent, node.right, node);
            else if (node.right == null)
                transplant(parent, node.left, node);
            else{
                // right != null && left != null
                TreeNode next = getNext(node); // right != null, so next cannot be null
                if(next != node.right){
                    transplant(getParent(next), next.right, next);
                    next.right = node.right;
                }
                transplant(getParent(next), next.right, next);
                next.left = node.left;
            }
            size--;
            return true;
        }
        return false;
    }


    protected void transplant(TreeNode parent, TreeNode newNode, TreeNode oldNode){
        /** 改变父节点的指向 **/
        if(parent == null)
            this.root = newNode;
        else if(oldNode == parent.right)
            parent.right = newNode;
        else
            parent.left = newNode;
    }


    protected TreeNode getNext(TreeNode node){
        if (node==null || node.right == null)
            return null;
        node = node.right;
        while(node.left != null)
            node = node.left;
        return node;
    }



}
