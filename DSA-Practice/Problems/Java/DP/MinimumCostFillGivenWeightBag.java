package DP;

import java.util.Arrays;

public class MinimumCostFillGivenWeightBag {

    int dp[][];
	public int minimumCost(int cost[], int N, int W)
	{
		// Your code goes here
	   dp = new int [N+1][W+1];
	   for(int [] i : dp){
	       Arrays.fill(i, -1);
	   }
	   
	   int op = solve(cost, N, W);
	   
	   return  op < 0 ? -1 : op;
	}
	
	public int solve(int cost[], int N, int W){
	    
	    if(W == 0) return 0;
	    
	    if(N == 0) return 100000;
	    
	    if(dp[N][W] != -1) return dp[N][W];
	    
	    if(N <= W && cost[N - 1] != -1){
	        int take = cost[N - 1] + solve(cost, N , W - N);
	        int notTake = solve(cost, N - 1, W);
	        return dp[N][W] = Math.min(take, notTake);
	    }else{
	        return dp[N][W] = solve(cost, N - 1, W);
	    }
	    
	}
    
}
