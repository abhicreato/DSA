public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        
        if(root == null){
            return root;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
        
    }
    
}

/*
**************** Logic ****************
Recursively travel left and right nodes, swap left and right nodes and return current node.
*/
