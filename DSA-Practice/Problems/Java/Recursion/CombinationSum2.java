package Recursion;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */

import java.util.*;

public class CombinationSum2 {

    List<List<Integer>> ans = new ArrayList();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ArrayList<Integer> op = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        solve(candidates,op,target,0);
        
        return this.ans;
        
    }
    
    public void solve(int[] ip, ArrayList<Integer> op, int target, int startIndex){

        if(target<=0){
            if(target == 0){
                this.ans.add(new ArrayList(op));
            } 
            return;
        }
        
        for(int i = startIndex; i<ip.length; i++){
            
            if(i > startIndex && ip[i] == ip[i-1] ) continue;
            op.add(ip[i]);
            solve(ip, op, target - ip[i], i + 1);
            op.remove(op.size() - 1);
            
        }
        
    }
    
}
