package DP;

/*
**************** Problem Description ****************
Given a fence with n posts and k colors, find out the number of ways of painting the fence so that not more than two consecutive fences have the same colors.
Since the answer can be large return it modulo 10^9 + 7.
    Example : 1
        
    Input: N=3,  K=2 
    Output: 6
    Example : 2
    
    Input: N=2,  K=4
    Output: 16
*/

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
        dp[1] = k; // same 
        dp[2] = k + (k * (k - 1)); // same + diffrent
        
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
        
        if(dp[n] != -1) return dp[n];
        
        double twoSameColor = 0;
        double twoDiffColor = 0;
        
        if(n == 2){
            twoSameColor = k;
            twoDiffColor = k * (k - 1); // Permutation 3 * 2 - 1, i
            return twoSameColor + twoDiffColor;
        } 

        twoSameColor = solve(n - 2, k) * (k - 1); // same = no of ways when color of last two posts is same
        twoDiffColor = solve(n - 1, k) * (k - 1); //no of ways when color of last two posts is different
        
        return dp[n] = (twoSameColor + twoDiffColor) % mod;
        
    }

    
}

/*
**************** Logic ****************
 same = no of ways when color of last two posts is same
 diff = no of ways when color of last two posts is different
 total ways = diff + sum
for n = 1
    same(1) = 0, diff(1) = k
    total(1) = k
for n = 2
    same(2) = k // k choices for common color of two posts
    diff(2) = k * (k-1) // k choices for first post, k-1 for next
    total(2) = k +  k * (k-1)
for n = 3
    same(3) = diff(2)
    diff(3) = total(2) * (k-1) // (k-1) choices for 3rd post to not have color of 2nd post.
Hence we deduce that, for i > 2 :
same[i] = diff[i-1]
diff[i] = total[i-1] * (k-1)
total[i] = same[i] + diff[i]
*/
