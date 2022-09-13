package Recursion;

import java.util.*;
/*
**************** Problem Description ****************
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
  Example 1 : 
  Input: nums = [1,2,3]
  Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  Example 2 : 
  Input: nums = [0]
  Output: [[],[0]]
*/

public class Subsets {

    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        ArrayList<Integer> ip = new ArrayList();
        ArrayList<Integer> op = new ArrayList();
        
        for(int i = 0 ; i<nums.length ; i++){
            ip.add(nums[i]);
        }
        
        subsets(ip,op);
        
        return this.ans;
        
    }
    
    public void subsets(ArrayList<Integer> ip, ArrayList<Integer> op){
            
        if(ip.size() == 0){
            this.ans.add(op);
            return;
        }
        
        ArrayList<Integer> op1 = new ArrayList<>(op);
        ArrayList<Integer> op2 = new ArrayList<>(op);
        ArrayList<Integer> ip2 = new ArrayList<>(ip);
        
        op2.add(ip.get(0));
        
        ip2.remove(0);
  
        subsets(ip2,op1);
        
        subsets(ip2,op2);

        return;
        
    }
    
}
