import java.util.*;

public class BTFromPreorderInorderTraversal {
   
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        TreeNode root = constructTree(preorder, 0, preorder.length - 1,
                                     inorder ,0 ,inorder.length - 1, map);
        
        return root;
        
    }
    
    public TreeNode constructTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,Map<Integer,Integer> map){
        
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preOrder[preStart]);
        
        int inRoot = map.get(preOrder[preStart]);
        int numLeft = inRoot - inStart;
        
        root.left = constructTree(preOrder, preStart + 1, preEnd + numLeft,
                                inOrder, inStart, inRoot - 1, map);
        root.right = constructTree(preOrder, preStart + 1 + numLeft, preEnd,
                                  inOrder, inRoot + 1, inEnd, map);
        
        return root;
        
    }
     
}

/*
**************** Logic ****************
Postorder traversing implies that PRE[size - 1] is the root node.
Then we can find this PRE[size - 1] in POST, say it's POST[5].
Now we know that POST[5] is root, so we know that POST[0] - POST[4] is on the left side, POST[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it.
*/
