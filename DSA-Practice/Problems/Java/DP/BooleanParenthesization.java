package DP;

/*
**************** Problem Description ****************
Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
    Example : 1
    Input:
    N = 7
    S = T|T&F^T
    Output: 4
    Explaination:
    The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
    Example : 2
    Input:
    N = 5
    S = T^F|F
    Output: 2
    Explaination: ((T^F)|F) and (T^(F|F)) are the only ways.
*/


import java.util.*;

public class BooleanParenthesization {

    static int countWays(int N, String S){
        // code here
        Map<String,Integer> map = new HashMap<>();
        int [][][] dp = new int[N+1][N+1][2];
        
        for(int [][]rows: dp)
        {
            for(int []col:rows)
            {
                Arrays.fill(col,-1);
            }
        }
        
        return solve(S, 0, N - 1, true, map, dp);
    }
    
    static int solve(String s, int i, int j, boolean isTrue, Map<String,Integer> map, int[][][] dp){
        
        if(i>j) return 0;
        
        if(i == j){
            if(isTrue){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        // using 3D Array 
        int expnum=(isTrue) ? 1 : 0;
        if(dp[i][j][expnum] != -1) return dp[i][j][expnum];
        
        // using Map
        // String key = i + " " +  j + " " + (isTrue ? "T" : "F");
        // if(map.containsKey(key)) return map.get(key);
        
        int ans = 0;
        
        for(int k = i + 1; k < j; k+=2){
            
            int lTrue = solve(s, i, k - 1, true, map, dp);
            int lFalse = solve(s, i, k - 1, false, map, dp);
            int rTrue = solve(s, k + 1, j, true, map, dp);
            int rFalse = solve(s, k + 1, j, false, map, dp);
            
            if(s.charAt(k) == '&'){
                
                if(isTrue){
                    ans = ans + (lTrue * rTrue);
                }else{
                    ans = ans + (lTrue * rFalse) + (lFalse * rTrue) + (lFalse * rFalse);
                } 
                
                
            }else if(s.charAt(k) == '|'){
                
                if(isTrue){
                     ans = ans + (lFalse * rTrue) + (lTrue * rFalse) + (lTrue * rTrue) ;
                }else{
                     ans = ans + (lFalse * rFalse);
                }
                
                
            }else if(s.charAt(k) == '^'){
                
                if(isTrue){
                    ans = ans + (lFalse * rTrue) + (lTrue * rFalse);
                }else{
                    ans = ans + (lFalse * rFalse) + (lTrue * rTrue);
                }
                
            }
            
        }
        
        // using 3D array
        dp[i][j][expnum]=(int) (ans %1003);
        return dp[i][j][expnum];
        
        // Question asked for modulo 1003
        //map.put(key, ans%1003);
        //return ans%1003;
        
    }

}

/*
**************** Logic ****************
For each segment find out how many ways are there to get T as result.
*/
