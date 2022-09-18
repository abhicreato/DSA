package Recursion;

import java.util.*;

public class Combinations {

    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
        
        ArrayList<Integer> intnA = new ArrayList<>();
        
        solve(1,n,k,intnA);
        
        return ans;
        
    }
    
    public void solve(int rs, int range , int combiLen, ArrayList<Integer> op){
        
        if(op.size() == combiLen){
            this.ans.add(new ArrayList(op));
            return;
        }

        for(int i = rs ; i <= range ; i++){
            if(op.contains(i)) continue;
            op.add(i);
            rs++;  
            solve(rs, range, combiLen,op);
            op.remove(op.size() - 1);    
        }
        
        return;
        
    }
    
}
