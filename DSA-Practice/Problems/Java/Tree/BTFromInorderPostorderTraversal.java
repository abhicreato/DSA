import java.util.*;

public class BTFromInorderPostorderTraversal {
    
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i< inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        
        TreeNode root = constructTree(inOrder,0,inOrder.length - 1,
                                     postOrder,0,postOrder.length - 1, map);
        
        return root;
        
    }
    
    public TreeNode constructTree(int[] inOrder, int inStart, int inEnd, 
                                 int[] postOrder, int postStart, int postEnd,Map<Integer,Integer> map){
        
        if(postStart > postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postOrder[postEnd]);
        
        int inRoot = map.get(postOrder[postEnd]);
        int numsLeft = inRoot - inStart;
        
        root.left = constructTree(inOrder, inStart, inRoot - 1,
                                 postOrder, postStart, postStart + numsLeft - 1, map);
        
        root.right = constructTree(inOrder, inRoot + 1, inEnd,
                                  postOrder, postStart + numsLeft , postEnd - 1, map);
        
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
