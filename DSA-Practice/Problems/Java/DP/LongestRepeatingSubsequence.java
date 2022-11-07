package DP;

public class LongestRepeatingSubsequence {
    

    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int l1 = str.length();
        int dp[][] = new int[l1+1][l1+1];
        
        for(int i=0;i<=l1;i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l1;j++){
                if(str.charAt(i-1)==str.charAt(j-1) && i!=j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return dp[l1][l1];
    }
}
