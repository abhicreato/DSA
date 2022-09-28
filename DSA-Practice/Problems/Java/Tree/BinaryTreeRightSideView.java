
import java.util.*;

public class BinaryTreeRightSideView {

    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
       
        solve(root,0);
        
        return this.ans;
    }
    
    public void solve(TreeNode node,int level){
        
        if(node == null){
            return;
        }
        
        if(level == ans.size())ans.add(node.val);
        
        solve(node.right, level + 1);
        solve(node.left, level + 1);
        
    }
    
}

// logic link https://www.youtube.com/watch?v=KV4mRzTjlAk
