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
        return solve(S, 0, N - 1, true, map);
    }
    
    static int solve(String s, int i, int j, boolean isTrue, Map<String,Integer> map){
        
        if(i>j) return 0;
        
        if(i == j){
            if(isTrue){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        String key = i + " " +  j + " " + (isTrue ? "T" : "F");
        
        if(map.containsKey(key)) return map.get(key);
        
        int ans = 0;
        
        for(int k = i + 1; k < j; k+=2){
            
            int lTrue = solve(s, i, k - 1, true, map);
            int lFalse = solve(s, i, k - 1, false, map);
            int rTrue = solve(s, k + 1, j, true, map);
            int rFalse = solve(s, k + 1, j, false, map);
            
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
        
        map.put(key, ans%1003);
        
        return ans%1003;
        
    }

}

/*
**************** Logic ****************
For each segment find out how many ways are there to get T as result.
*/
