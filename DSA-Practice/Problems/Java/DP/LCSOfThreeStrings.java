package DP;

public class LCSOfThreeStrings {
    
    int dp[][][];
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        dp = new int[n1+1][n2+1][n3+1];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                for(int z=0;z<=n3;z++){
                    dp[i][j][z] = -1;
                }
            }
        }
        return solve(A, B, C, n1, n2, n3);
        
    }
    
    int solve(String A, String B, String C, int n1, int n2, int n3){
        
        if(n1 == 0 || n2 == 0 || n3 == 0) return 0;
        
        if(dp[n1][n2][n3] != -1) return dp[n1][n2][n3];
        
        if(A.charAt(n1- 1) == B.charAt(n2-1) && B.charAt(n2-1) == C.charAt(n3-1)){
            return 1 + solve(A, B, C, n1 - 1, n2 - 1, n3 - 1);
        }else{
            
            int x = solve(A, B, C, n1 - 1, n2, n3);
            int y = solve(A, B, C, n1, n2 - 1, n3);
             int z = solve(A, B, C, n1, n2 , n3 - 1);
            
            return dp[n1][n2][n3] = Math.max(x, Math.max(y,z));
        }
    }

}
