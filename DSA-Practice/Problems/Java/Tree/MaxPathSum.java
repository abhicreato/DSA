public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        maxPathAhead(root);
        
        return max;
    }
        
    public int maxPathAhead(TreeNode root){
        
        if(root == null) return 0;
        
        int maxSumLeft = Math.max(0, maxPathAhead(root.left));
        int maxSumRight = Math.max(0, maxPathAhead(root.right));
        
        // calculate sum of all value of smallest subtree 
        max = Math.max(max, root.val + maxSumLeft + maxSumRight ); 
        
        
        return root.val + Math.max(maxSumLeft,maxSumRight) ;
        
    }
}
