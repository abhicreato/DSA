package DP;

public class EditDistance {

    int dp[][];

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        dp = new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, l1-1, l2 - 1);
    }

    public int solve(String x, String y, int i, int j){

        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        if(x.charAt(i) == y.charAt(j)){
            return solve(x, y, i - 1, j - 1);
        }else{
           min = Math.min(min,  1 + solve(x, y, i, j - 1)); // Insert , Assume you added j`th char to right of i`th char
           min = Math.min(min,  1 + solve(x, y, i - 1, j)); // Delete , remove i`th char 
           min = Math.min(min,  1 + solve(x, y, i - 1, j - 1)); // Replace, Assume you added jth char
        }

        return dp[i][j] = min;

    }
    
}
