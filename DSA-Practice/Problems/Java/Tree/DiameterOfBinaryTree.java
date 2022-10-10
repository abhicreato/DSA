// Tree object 
public class TreeNode {
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

public class DiameterOfBinaryTree {
    
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        solve(root);
        
        return max;
        
    }
    
    public int solve(TreeNode curr){
    
        if(curr == null){
            return 0;
        }
        
        int left = solve(curr.left);
        int right = solve(curr.right);
        
        // this will combine longest path of left and right for answer
        max = Math.max(max, left + right);

        //this will return longest path of one side  
        return 1 + Math.max(left,right);
        
    }

}

/*
**************** Logic ****************
Recursively travel left and right nodes and return the max sum for each node.
*/
