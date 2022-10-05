public class LowestCommonAncestorofBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if( root == null || root == p || root == q ) return root;
        
        TreeNode LCAL = lowestCommonAncestor(root.left,p,q);
        TreeNode LCAR = lowestCommonAncestor(root.right,p,q);
        
        if(LCAL == null){
            return LCAR;
        }else if(LCAR == null){
            return LCAL;
        }else{
            return root;
        }
        
    }
}
