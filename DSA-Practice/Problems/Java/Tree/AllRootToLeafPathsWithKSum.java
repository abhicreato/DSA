import java.util.*;

public class AllRootToLeafPathsWithKSum {
    List<List<Integer>> ans = new ArrayList();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<Integer> op = new ArrayList();

        solve(root,op,targetSum);
        
        return ans;
    }
    
    public void solve(TreeNode node, List<Integer> op, int targetSum){
 
        if(node == null) return;
             
        op.add(node.val);
        
        if(node.left == null  && node.right == null && node.val == targetSum){
            ans.add(op);
            return;
        }
        
        solve(node.left, new ArrayList(op), targetSum - node.val);
        solve(node.right, new ArrayList(op), targetSum - node.val);
        
        op.remove(op.size() - 1);
    }
}
