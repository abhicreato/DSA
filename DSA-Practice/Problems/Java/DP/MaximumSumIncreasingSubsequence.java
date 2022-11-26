package DP;

public class MaximumSumIncreasingSubsequence {

	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[] = new int[n];
	    int maxSum = 0;
	    
	    for(int i=0; i<n; i++){
	    
	        int max = 0;
	        
	        for(int j=0;j<i;j++){
	            if(arr[j] < arr[i]){
	                max = Math.max(max, dp[j]);
	            }
	        }
	        
	        dp[i] = max + arr[i];
	        
	        maxSum = Math.max(maxSum, dp[i]);
	    }
	    
	    return maxSum;
	}  
    
}
