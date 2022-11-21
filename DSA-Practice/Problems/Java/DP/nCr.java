public class nCr {
    
    static int nCr(int n, int r)
    {
        // code here
        if (r > n) return 0;
        
        if (n == r || r == 0) return 1;
        
        if (r == 1) return n;
        
        double mod = 1e9 + 7;
        
        double dp[][] = new double [n+1][r+1];
        
        for (int i = 0; i < n + 1; i++) dp[i][0] = 1;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<r+1;j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<r+1;j++){
                System.out.println(dp[i][j]);
            }
        }
        
        return (int) dp[n][r];
    }

}
