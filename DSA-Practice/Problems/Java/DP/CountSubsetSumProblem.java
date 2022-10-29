package DP;
public class CountSubsetSumProblem {
    
    
    static int count = 0;
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int dp[][] = new int[n+1][tar + 1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(j == tar) count++;
                
                 if(num[i - 1] <= tar){
                    dp[i][j] = dp[i-1][j - num[i -1]] + dp[i - 1][j];
                 }else{
                    dp[i][j] = dp[i - 1][j];
                 }
            }
        }

        return dp[n][tar];
    }
    
    public static int solve(int index, int [] num, int tar){
        
        if(index < 0) return 0;

        if(tar == 0){
            return 1;
        } 
        
        if(num[index - 1] <= tar){
            return solve(index - 1, num, tar - num[index - 1]) + solve(index - 1, num, tar);;
            
        }else{
            return solve(index - 1, num, tar);
        }
        
    }
}
