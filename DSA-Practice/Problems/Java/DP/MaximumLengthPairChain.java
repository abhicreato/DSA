package DP;

import java.util.*;

public class MaximumLengthPairChain {

    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));

        int len = pairs.length;

        // Dp Array init
        dp = new int[len+1][len+1];

        // Adding base case to 0th Index ans shift
        int inputArr[][] = new int[len + 1][2];
        inputArr[0] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE + 1};

        for(int i=1;i<=len;i++){
            inputArr[i] = pairs[i-1];
        }

      return solve(inputArr, 1, 0);
        
    }

    public int solve(int[][] pairs, int currIndex, int preRightIndex){

        if(currIndex == pairs.length) return 0;

        if(dp[currIndex][preRightIndex] != -1) return dp[currIndex][preRightIndex];

        if(pairs[preRightIndex][1] < pairs[currIndex][0]){
            int take = 1 + solve(pairs, currIndex + 1, currIndex);
            int notTake = solve(pairs, currIndex + 1, preRightIndex);
            return dp[currIndex][preRightIndex] = Math.max(take, notTake);
        }else{
            return dp[currIndex][preRightIndex] = solve(pairs, currIndex + 1, preRightIndex);
        }
    }
    
}
