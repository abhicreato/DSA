package DP;

public class CoinChangeWays {
    long dp[][];
    
    public long count(int coins[], int N, int sum) {
        // code here.
        
        dp = new long[N + 1][sum + 1];
        
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = -1;
            }
        }

        solve(N - 1 , sum, coins);
        
        return dp[N - 1][sum];

    }
    
    public long solve(int index, int sum, int[] coins){
        
        if(index < 0 || sum < 0) return 0;
        
        if(sum == 0) return 1;
        
        if(dp[index][sum] != -1) return dp[index][sum];
        
        if(sum >= coins[index]){
            return dp[index][sum] = solve(index, sum - coins[index], coins) + solve(index - 1, sum, coins);
        }else{
            return dp[index][sum] = solve(index - 1, sum, coins);
        }
        
    }
    
}
