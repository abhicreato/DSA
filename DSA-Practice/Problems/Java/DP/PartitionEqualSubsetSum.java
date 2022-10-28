package DP;

/*
**************** Problem Description ****************
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
    Example : 1
    
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].
    Example : 2
    
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum subsets.
*/


public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        
        if(sum % 2 != 0) return false;
        
        int target = sum / 2;
        
        boolean dp[][] = new boolean[n + 1][target + 1];
        
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < target + 1; j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }
        
        for(int i = 1 ; i < n + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][target];
          
    }
}

/*
**************** Logic ****************
If the sum is odd then we cannot divide in equal sum subset.
If sum is even, we can check if we can pick some elements to make a total of s = sum/2 .
The solution depends upon the required sum (s = sum/2) and the items included.
So our DP solution contains 2 states: s = sum/2 and N(items).
*/
