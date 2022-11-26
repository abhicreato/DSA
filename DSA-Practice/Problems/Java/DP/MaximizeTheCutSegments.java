package DP;

public class MaximizeTheCutSegments {
    
    int dp[];
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       dp = new int[n+1];
       
       for(int i=0;i<=n;i++){
           dp[i] = -1;
       } 
       
       int ans = solve(n,x,y,z);
       
       return ans < 0 ? 0 : ans;
    }
    
    public int solve(int n, int x, int y, int z){
        
        if(n == 0) return 0;
        
        if(n < 0) return Integer.MIN_VALUE;
        
        if(dp[n] != -1) return dp[n];

        int cutX = 1 + solve(n - x, x, y, z);
        int cutY = 1 + solve(n - y, x, y, z);
        int cutZ = 1 + solve(n - z, x, y, z);
       
        return dp[n] = Math.max(cutX,Math.max(cutY,cutZ));
        
    }

}
