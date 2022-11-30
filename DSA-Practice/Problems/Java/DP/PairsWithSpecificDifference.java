package DP;

/*
**************** Problem Description ****************
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
    Example : 1
            
    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example : 2
    
    Input: nums = [2,3,0,1,4]
    Output: 2
*/

import java.util.Arrays;

public class PairsWithSpecificDifference {

    static int[][] dp;
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        // Your code goes here 
        dp = new int[N][N];
        Arrays.sort(arr);
        return solve(arr, 1, 0, N, K);
    }
    
    public static int solve(int [] arr, int currIndex, int preValIndex, int N, int K){
        
        if(currIndex >= N) return 0;
        
        if(dp[currIndex][preValIndex] != 0) return dp[currIndex][preValIndex];
        
        if(arr[currIndex] - arr[preValIndex] < K){
            
            int take = arr[currIndex] + arr[preValIndex] + solve(arr, currIndex + 2, preValIndex + 2, N, K);
            int notTake = solve(arr, currIndex + 1, preValIndex + 1, N, K);
            
            return dp[currIndex][preValIndex] = Math.max(take,notTake);
            
        }else{
            return dp[currIndex][preValIndex] = solve(arr, currIndex + 1, preValIndex + 1, N, K);
        }
     
    }
    

    
}

/*
**************** Logic ****************
DP : For each index try all possible jumps. Memoize the overlapping jumps.
Greedy :
This is an implicit bfs solution. i == curEnd means you visited all the items on the current level.
Incrementing jumps++ is like incrementing the level you are on.
And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
*/
