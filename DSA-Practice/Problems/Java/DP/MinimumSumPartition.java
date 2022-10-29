package DP;

public class MinimumSumPartition {

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int sumOfArray = 0;
	    
	    for(int i = 0; i < n; i++){
	        sumOfArray += arr[i];
	    }
	    
	    //System.out.println("Total sum : " + sumOfArray);
	    
	    int tar = sumOfArray / 2;
	    
	    //System.out.println("Total sum half: " + tar);
	    
	    boolean dp[][] = new boolean[n+1][tar+1];
	    
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<tar+1;j++){
	            if(i==0) dp[i][j]=false;
	            if(j==0) dp[i][j]=true;
	        }
	    }
	    
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<tar+1;j++){
	            
	            if(j >= arr[i - 1]){
	                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
	            }else{
	                dp[i][j] = dp[i - 1][j];
	            }
	            
	        }
	    }
	    
	    int fSubsetSum = -1;
	    
	    for(int i = tar ; i >= 0 ; i--){
	        if(dp[n][i]){
	            fSubsetSum = i;
	            break;
	        } 
	    }
	    
	    //System.out.println("1st subset sum : " + fSubsetSum);

	    int sSubsetSum = sumOfArray - fSubsetSum;
	    
	    //System.out.println("2nd subset sum : " + sSubsetSum);
	    
	    int diff = Math.abs(fSubsetSum - sSubsetSum);
	    
	    // System.out.println("Min Diffrence : " + diff);
	    return diff;
  
	} 
	
}
