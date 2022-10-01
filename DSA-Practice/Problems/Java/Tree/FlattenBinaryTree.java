import java.util.*;

public class FlattenBinaryTree {
    
    // Recursive solution
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        
     if(root == null) return;
        
     flatten(root.right);
        
     flatten(root.left);
         
     root.right = prev;
        
     root.left = null;
        
     // Save the subtree for which we have flatten
     prev = root;
            
    }
    
}


