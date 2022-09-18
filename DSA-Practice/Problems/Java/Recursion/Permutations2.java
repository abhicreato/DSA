package Recursion;

import java.util.*;

public class Permutations2 {

    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        ArrayList<Integer> intr = new ArrayList();
        
        Arrays.sort(nums);
        
        solve(nums,intr,new boolean[nums.length]);
        
        return this.ans;
        
    }
    
    public void solve(int[] ip , ArrayList<Integer> op , boolean [] used){
        
        if(ip.length == op.size()){
            this.ans.add(new ArrayList(op));
        }
        
        for(int i=0;i<ip.length;i++){
            
            // as input is sorted if a value is already used ignore for the calculation
            
            if(used[i] || i > 0 && ip[i] == ip[i-1] && !used[i-1]) continue;
            
            op.add(ip[i]);
            used[i] = true;
            solve(ip,op,used);
            op.remove(op.size()-1);
            used[i] = false;
        }
        
        return ;
        
    }
    
}
