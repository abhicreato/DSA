public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if( root1 == null && root2 == null) return true;
        if( root1 == null && root2 != null) return false;
        if( root1 != null && root2 == null) return false;
        
        if(root1.val != root2.val) return false;
        
        // if left and right of both tree is flip equal then return true;
        boolean case1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        
        // if swap of left right of both tree is flip equal then return true;
        boolean case2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        // if any of the case is true return true;
        return case1 || case2;

    }
}


// https://www.youtube.com/watch?v=izRDc1il9Pk
