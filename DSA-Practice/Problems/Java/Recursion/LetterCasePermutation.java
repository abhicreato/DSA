package Recursion;

/*
**************** Problem Description ****************
Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. You can return the output in any order.
  
  
  Example 1 : 
  
  Input: s = "a1b2"
  Output: ["a1b2","a1B2","A1b2","A1B2"]
  
  
  Example 2 : 
  
  Input: s = "3z4"
  Output: ["3z4","3Z4"]
  
  
  Example 3 : 
  
  Input: s = "12345"
  Output: ["12345"]
  
  
  Example 4 : 
  
  Input: s = "0"
  Output: ["0"]
  
*/

import java.util.*;

public class LetterCasePermutation {

    
    
    ArrayList<String> ans = new ArrayList();
    
    public List<String> letterCasePermutation(String s) {

        String op = new String();
        
        solve(s.toLowerCase(),op,0);
        
        return this.ans;
        
    }
    
    public void solve(String ip, String op, int index){
        
        if(index >= ip.length()){
            if(!this.ans.contains(op)) this.ans.add(op);
            return;
        }
        
        char temp = ip.charAt(index);
        String op1 = op;
        String op2 = op;
        
        if(Character.isAlphabetic(temp)){
            op1 = op + Character.toUpperCase(temp);
            op2 = op + temp;
        }else{
            op1 = op + temp;
            op2 = op1;
        }

        solve(ip,op1,index+1);
        solve(ip,op2,index+1);
        
        return;
        
    }
    
}

/*
**************** Logic ****************
For each character in the string except for numbers we can include it with a uppercase or lowecase.
*/
