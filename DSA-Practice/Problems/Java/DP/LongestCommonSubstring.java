package DP;

public class LongestCommonSubstring {
    int ans = 0;
    int [][] dp;
    
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        dp = new int [n+1][m+1];

        // Memoazation
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=m;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // solve(S1,S2,n,m);
        // return ans;
    
        // Tabuation
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return max;
        
    }
    
    int solve(String s1,String s2,int n, int m){
        
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        solve(s1,s2,n-1,m);
        solve(s1,s2,n,m-1);
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            dp[n][m] =  1+ solve(s1, s2, n-1, m-1);
            ans = Math.max(ans, dp[n][m]);
            return dp[n][m];
        }else{
            return dp[n][m] = 0;
        }
    }

    
}
