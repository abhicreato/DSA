
import java.util.*;

public class BinaryTreeRightSideView {

    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
       
        solve(root,0);
        
        return this.ans;
    }
    
    public void solve(TreeNode node,int currentDepth){
        
        if(node == null){
            return;
        }
        
        if(currentDepth == ans.size())ans.add(node.val);
        
        solve(node.right, currentDepth + 1);
        solve(node.left, currentDepth + 1);
        
    }
    
}

// logic link https://www.youtube.com/watch?v=KV4mRzTjlAk
