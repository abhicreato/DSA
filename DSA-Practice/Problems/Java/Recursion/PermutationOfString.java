package Recursion;

import java.util.*;

public class PermutationOfString {

    ArrayList<String> ans = new ArrayList<>();
    
    public List<String> find_permutation(String S) {
        // Code here
        
        String op = new String();

        solve(S,op);
        
        Collections.sort(this.ans);
        
        return this.ans;
    }
    
    public void solve(String ip, String op){
        
        int n = ip.length();
        
        if(n == 0){
            if(!this.ans.contains(op)) this.ans.add(op);
            return;
        }
        
        for(int i = 0; i < n; i++){
            
            // put current char in op
            String op1 = op + ip.charAt(i);
            // update input
            String ip1 = ip.substring(0, i) + ip.substring(i + 1, n);

            solve(ip1, op1);
            
        }
    }

    
}
