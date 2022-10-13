
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DeleteNodeFromBST {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return root;
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if( root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            
            //When node to be deleted have 2 children, find max val on left and replace to node val
            if(root.left != null && root.right != null){
                int maxR = findMax(root.left);
                root.val = maxR;
                root.left = deleteNode( root.left , maxR);
            }
            // When node to be deleted has only left child
            else if(root.left != null){
                return root.left;
            }
            // When node has only right child
            else if(root.right != null){
                return root.right;
            }
            // When node is Leaf
            else{
                return null;
            }
            
        }
        
        return root;

    }

    public int findMax(TreeNode node){
        
        while(node.right != null){
            node = node.right;
        }
        
        return node.val;
        
    }

}
