public class AllKSumPathsInABinaryTree {
   
    
    int ans = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null ) return 0;
        
        solve(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right, targetSum);
        
        return ans;

    }
    
    public void solve(TreeNode node, long sum){
    
        if (node == null) return;
        
        if(node.val == sum) ans++;
        
        sum = sum - node.val;
        
        solve(node.left, sum);
        solve(node.right, sum);

        
    }


}
