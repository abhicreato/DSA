package DP;

public class BooleanParenthesization {


    static int countWays(int N, String S){
        // code here
        return solve(S, 0, S.length() - 1, true);
    }
    
    static int solve(String s,int i, int j, boolean isTrue){
        
        if(i>j) return 0;
        
        if(i == j){
            if(isTrue){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        int ans = 0;
        
        for(int k = i + 1; k <= j-1; k=+2){
            
            int lTrue = solve(s, i, k-1, true);
            int rTrue = solve(s, k+1, j, true);
            int lFalse = solve(s, i, k-1, false);
            int rFalse = solve(s, k+1, j, false);
            
            if(s.charAt(k) == '&'){
                
                ans = ans + lTrue * rTrue;
                
            }else if(s.charAt(k) == '|'){
                
                ans = ans + lTrue * rFalse + rFalse * lTrue + lTrue * rTrue ;
                
            }else if(s.charAt(k) == '^'){
                
                ans = ans + lTrue * rFalse + rFalse * rTrue;
            }
            
        }
        
        return ans;
        
    }

    
}
