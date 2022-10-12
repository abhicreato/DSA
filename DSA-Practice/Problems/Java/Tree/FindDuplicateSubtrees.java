import java.util.*;;

public class FindDuplicateSubtrees {
    
    List<TreeNode> ans = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        Map<String,Integer> map = new HashMap<>();
        
        solve(root,map);
        
        return ans;
        
    }
    
    public String solve(TreeNode node, Map<String,Integer> map){
        
        if(node == null) return "";
        
        String encode = node.val + "," + solve(node.left,map) + "," + solve(node.right,map);
            
        if(map.containsKey(encode)){
            int val = map.get(encode);
            map.put(encode,val + 1);
        }else{
            map.put(encode,1);
        }
        
        int count = map.get(encode);
        
        if(count==2) ans.add(node);
        
        return encode;
        
    }
}
