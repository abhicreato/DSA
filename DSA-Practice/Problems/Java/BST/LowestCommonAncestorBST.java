package BST;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 
        // if both p and q are small then current root, then go left 
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // if both p and q are greater then current root, then go right
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        // all other case would be eaithr p and q are equal to root or both node are
        // in seperate branch which means it is the ancestor we all are looking for
        else{
            return root;
        }
        
    }
    
}
