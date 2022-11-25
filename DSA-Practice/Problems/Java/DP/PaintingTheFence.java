package DP;

public class PaintingTheFence {

    double mod = 1e9 + 7;
    double dp[];
    long countWays(int n,int k)
    {
        //code here.

        if(n == 0) return 0;
        
        if(n == 1) return k;
        
        dp = new double[n+1];
        
        // tabulation
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + (k * (k - 1));
        
        double twoSameColor = 0;
        double twoDiffColor = 0;
        
        for(int i=3;i<=n;i++){
            twoSameColor = dp[i - 2] * (k - 1);
            twoDiffColor = dp[i - 1] * (k - 1);
            dp[i] = (twoSameColor + twoDiffColor) % mod;
        }
        
        return (long) dp[n];
        
        // Memoazation with recursion
        // for(int i=0;i<=n;i++) dp[i] = -1;
        // return (long) solve(n,k);
        
    }
    
    double solve(int n, int k){
        
        if(n == 0) return 0;
        
        if(n == 1) return k;
        
        if(dp[n] !=-1) return dp[n];
        
        double twoSameColor = 0;
        double twoDiffColor = 0;
        
        if(n == 2){
            twoSameColor = k;
            twoDiffColor = k * (k - 1); // Permutation 3 * 2 - 1, i
            return twoSameColor + twoDiffColor;
        } 

        twoSameColor = solve(n - 2, k) * (k - 1);
        twoDiffColor = solve(n - 1, k) * (k - 1);
        
        return dp[n] = (twoSameColor + twoDiffColor) % mod;
        
    }

    
}
