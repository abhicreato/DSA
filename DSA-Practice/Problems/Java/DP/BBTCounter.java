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

/*
**************** Logic ****************
Since the difference between the heights of left and right subtree is not more than one, possible heights of left and right part can be one of the following:
(h-1), (h-2)
(h-2), (h-1)
(h-1), (h-1)
count(h) = count(h-1) * count(h-2) + 
           count(h-2) * count(h-1) + 
           count(h-1) * count(h-1)
           
        = 2 * count(h-1) * count(h-2) + count(h-1) * count(h-1)
        = count(h-1) * (2*count(h - 2) + count(h - 1))
*/
