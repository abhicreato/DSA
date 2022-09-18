package Recursion;

import java.util.*;

public class Subsets2 {

    
    Set<List<Integer>> ans = new HashSet<>();
    ArrayList<List<Integer>> ansl = new ArrayList();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        ArrayList<Integer> ip = new ArrayList();
        ArrayList<Integer> op = new ArrayList();
        
        Arrays.sort(nums);
        
        for(int i =0;i<nums.length;i++){
            ip.add(nums[i]);
        }
        
        subsets(ip,op);
        
        this.ansl.addAll(ans);
        
        return ansl;
  
    }
    
    public void subsets(ArrayList<Integer> ip , ArrayList<Integer> op){
        
        if(ip.size()==0){
            this.ans.add(op);
            return;
        }
        
        ArrayList<Integer> op1 = new ArrayList(op);
        ArrayList<Integer> op2 = new ArrayList(op);
        ArrayList<Integer> ip2 = new ArrayList(ip);
        
        op2.add(ip2.get(0));
        
        ip2.remove(0);
        
        subsets(ip2,op1);
        subsets(ip2,op2);
        
        return;
    }
    
}
