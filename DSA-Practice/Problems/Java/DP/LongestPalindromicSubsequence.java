package DP;

public class LongestPalindromicSubsequence {
    
    public int longestPalindromeSubseq(String s) {

        int n1 = s.length();
        int n2 = n1;
        String s2 = new StringBuffer(s).reverse().toString();

        int dp[][] =  new int [n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];

    }
}
