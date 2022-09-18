package Recursion;

import java.util.*;

public class Permutations {

    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        ArrayList<Integer> inrnAr = new ArrayList<>();
        
        solve(nums,inrnAr);
        
        return ans;
        
    }
    
    public void solve(int[]nums, ArrayList<Integer> op){
        if(op.size() == nums.length){
            this.ans.add(new ArrayList(op));
            return;
        }
        
        for(int i = 0;i<nums.length;i++){
            if(op.contains(nums[i])) continue;
            op.add(nums[i]);
            solve(nums,op);
            op.remove(op.size() - 1);
        }
        
        return;
        
    }
    
}
