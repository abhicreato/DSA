package Graph;

import java.util.*;

public class TopologicalSort {

    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int ans[] = new int[V];
        boolean visited[] = new boolean [V];
        Stack<Integer> s = new Stack<>();
    
        for(int i=0;i<V;i++){
            if(!visited[i]){
                solve(i,adj,visited,s);
            }
        }

        for(int i=0;i<V;i++){
            ans[i] = s.pop();
        }

        return ans;
    }
    
    static void solve(int val, ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> s){
        
        if(visited[val]) return;
        
        visited[val] = true;
        
        for(Integer c : adj.get(val)){
            solve(c,adj,visited,s);
        }
        
        s.push(val);
    }

}
