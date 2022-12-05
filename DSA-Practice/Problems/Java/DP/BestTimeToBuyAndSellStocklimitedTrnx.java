package DP;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocklimitedTrnx {

    int dp[][][];
    public int maxProfit(int[] prices) {
     
        dp = new int[prices.length + 1][3][3];
        for(int i[][]:dp){
            for(int j[]:i){
                 Arrays.fill(j, -1);
            }
        }
        
        return solve(prices, 0, 1 , 2);
    }
    
    public int solve(int[]prices, int currIndex, int canBuy , int transactionLeft){
        
        if(currIndex == prices.length) return 0;
        
        if(transactionLeft == 0) return 0;
        
        if(dp[currIndex][canBuy][transactionLeft] != -1) return dp[currIndex][canBuy][transactionLeft];
        
        if(canBuy == 1){
            
            int buy = -prices[currIndex] + solve(prices, currIndex + 1, 0, transactionLeft);
            int notBuy = solve(prices, currIndex + 1, 1, transactionLeft);
            
            return dp[currIndex][canBuy][transactionLeft] = Math.max(buy,notBuy);
            
        }else{
            
            int sell = prices[currIndex] + solve(prices, currIndex + 1, 1 , transactionLeft - 1);
            int notSell = solve(prices, currIndex + 1, 0, transactionLeft);
            
            return dp[currIndex][canBuy][transactionLeft] = Math.max(sell, notSell);
            
        }     
        
    }
    
}
