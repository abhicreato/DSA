package Recursion;

/*
**************** Problem Description ****************
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.
The output should be printed in sorted increasing order of strings
  
  
  Example 1 : 
  
  Input: S = "ABC"
  
  Output: (A B C)(A BC)(AB C)(ABC)
  
  Explanation:
  ABC
  AB C
  A BC
  A B C
  These are the possible combination of "ABC".
  
  
  Example 2 : 
  
  Input: S = "AB"
  
  Output: (A B)(AB)
  
*/

import java.util.*;

public class PermutationWthSpaces {


    
    ArrayList<String> ans = new ArrayList<>();
    
    ArrayList<String> permutation(String S){
        // Code Here
        
        String op = new String();
        
        solve(S,op);
        
        Collections.sort(ans);
        
        return ans;
    }

    public void solve(String ip, String op){
        
        if(ip.length() == 0){
            if(!this.ans.contains(op)) this.ans.add(op);
            return;
        }
        
        String op1 = op;
        String op2 = op;
        String ip1 = new String(ip);
        
        if(ip.length() == 1){
            op1 = op + ip.charAt(0);
            op2 = op1;
        }else{
            op1 = op1 + ip.charAt(0);
            op2 = op2 + ip.charAt(0) + " ";
        }
       
        ip1 = ip1.substring(1);
        
        solve(ip1,op1);
        solve(ip1,op2);
        
        return;
        
    }
    

    
}

/*
**************** Logic ****************
For each character in the string except the last character we can include it with a postfix space or without space.
*/
