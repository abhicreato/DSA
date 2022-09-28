import java.util.*;

public class BtZigzagLevelOrderTraversal {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null){
            return ans;
        }
        
        LinkedList<TreeNode> q = new LinkedList();
        q.add(root);
        
        int depth = 0;

        while(!q.isEmpty()){
            
            int size = q.size();
            List<Integer> level = new ArrayList();
            
            depth++;
            
            for(int i=0;i<size;i++){
                
                TreeNode curr = q.remove();
                level.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
            }
            
            if(depth % 2 == 0) Collections.reverse(level);

            ans.add(level);   
        }
        
        return ans;
        
    }

}
