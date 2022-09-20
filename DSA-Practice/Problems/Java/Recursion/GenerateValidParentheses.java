package Recursion;

/*
**************** Problem Description ****************
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  
  
  Example 1 : 
  
  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]
  
  
  Example 2 : 
  
  Input: n = 1
  Output: ["()"]
  
*/

import java.util.*;

public class GenerateValidParentheses {
    
    ArrayList<String> ans = new ArrayList();
    
    public List<String> generateParenthesis(int n) {
        
        String op = new String();
        int open = n;
        int close = n;
        
        solve(op,open,close);
        
        return this.ans;
           
    }
    
    public void solve(String op, int open, int close){
        
        if(open == 0 && close == 0){
            this.ans.add(op);
            return;
        }
        
        String op1 = new String(op);
        String op2 = new String(op);
        
        if(open != 0){
            solve(op1 + "(", open - 1, close);
        }

        if(close > open){
            solve(op2 + ")", open, close - 1);
        }
        
        return;
    }

}

/*
**************** Logic ****************
Size of each result will be 2 * n. For each position we can choose '(' or ')'.
For a valid result, at any instance closed parentheses count should not be greater than open parentheses count.
Also count of open or closed parentheses cannot be greater than n.
*/
