package DP;

public class CoinChangeMinCoins {
    int[][] dp;
        
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        
        dp = new int[n + 1][amount + 1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i == 0) dp[i][j] = Integer.MAX_VALUE - 1;
                if(j == 0) dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=amount; j++){
                
                if(j >= coins[i-1]){
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j]; 
                }
                
            }
        }
 

        /*for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        
        int min = solve(n - 1, amount, coins);*/
        
        int min = dp[n][amount];
        
        
        if(min < Integer.MAX_VALUE - 1) return min;
        
        return - 1;
        
    }
    
    public int solve(int index, int amount, int[]coins){
        
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount/coins[index];
            }else{
                 return Integer.MAX_VALUE - 1;
            }    
        } 
        
        if(dp[index][amount] != -1) return dp[index][amount];

        if(coins[index] <= amount){
            return dp[index][amount] = Math.min(1 + solve(index, amount - coins[index], coins), solve(index - 1, amount, coins));
        }else{
            return dp[index][amount] = solve(index - 1, amount, coins);
        }     
        
    }
}
