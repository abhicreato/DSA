package DP;

public class PalindromicPartitioning {
    static int dp[][];
    
    static int palindromicPartition(String str)
    {
        // code here
        int sl = str.length();
        
        dp = new int [sl+1][sl+1];
        
        return solve(str, 0, sl - 1);
    }
    
    static int solve(String s, int i, int j){
        
        if(i >= j || isPali(s, i, j)) return 0;
        
        // Memoaization 
        if(dp[i][j] !=0) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k<=j-1; k++){
            
             // Memoaization more optimised 
            int left = (dp[i][k] != 0) ? dp[i][k] : solve(s, i, k);
            int right = (dp[k + 1][j] != 0) ? dp[k + 1][j] : solve(s, k + 1, j);

            int temp = 1 + left + right;
            
            min = Math.min(min, temp);
        }
        
        return dp[i][j] = min;
        
    }
    
    static boolean isPali(String s, int i, int j){

        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }


}
