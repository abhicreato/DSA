public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        
        return solve(root) != -1;
           
     }
     
     public int solve(TreeNode node){
         
         if(node == null) return 0;
 
         int lh = solve(node.left);
         if(lh == - 1) return - 1;
         int rh = solve(node.right);
         if(rh == - 1) return - 1;
         
         if(Math.abs(lh - rh) > 1) return - 1;
         
         return Math.max(lh, rh) + 1;
         
     }
    
}

/*
**************** Logic ****************
For each node find the difference between the max height of left and right subtree.
If the difference is greater than 1 then the tree is not balanced. 
*/
