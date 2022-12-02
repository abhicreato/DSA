package DP;

import java.util.*;

public class BBTCounter {
    
    static long dp[];
    
    static long countBT(int h){
      
      dp = new long[h + 1];
      
      Arrays.fill(dp,-1);
      
      return solve(h);
        
    }
    
    static long solve(int h){
         // code here
        if( h == 0 || h == 1 ) return 1;
        
        if(dp[h] != -1) return dp[h];
        
        long ans = (solve(h-1) * solve(h-2) + 
                    solve(h-2) * solve(h-1) +
                    solve(h-1) * solve(h-1));
                    
        //long ans = solve(h-1, dp) * (2 * solve(h-2, dp) + solve(h-1, dp));
        
        return dp[h] = ans % (long) (1e9 + 7);
    }

    
}
