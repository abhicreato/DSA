package Graph;

import java.util.*;

public class DetectCycleDirectedGraph {

    boolean vis[];
    boolean dfsvis[];
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        vis = new boolean[V];
        dfsvis = new boolean[V];
        
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(solve(i,adj)) return true;
            }
        }
        
        return false;
        
    }
    
    public boolean solve(int node, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = true;
        dfsvis[node] = true;
        
        for(Integer curr: adj.get(node)){
            if(!vis[curr]){
                if(solve(curr,adj)) return true;
            }else if(vis[curr] && dfsvis[curr]){
                return true;
            }
        }
        
        dfsvis[node] = false;
        return false;
        
    }
    
}
