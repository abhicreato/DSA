import java.util.*;;

public class CheckCompletenessoOfBinaryTree {
    

    public boolean isCompleteTree(TreeNode root) {
    
        boolean isNullSeen = false;
        LinkedList<TreeNode> Q = new LinkedList<>();
        Q.add(root);
            
        while(!Q.isEmpty()){
            
            TreeNode curr = Q.remove();
            
            if(curr == null){
                isNullSeen = true;
            }else{
            // This means we have receied not null node after a null
                if(isNullSeen) return false;
                Q.add(curr.left);
                Q.add(curr.right);
            }
     
        }
           
        // if no null seen then return true
        return true;
        
        }

}


/*
**************** Logic ****************
Use BFS to do a level order traversal, add childrens to the bfs queue, until we met the first empty node.
For a complete binary tree, there should not be any node after we met null.
*/
