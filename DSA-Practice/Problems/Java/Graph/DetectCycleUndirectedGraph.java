package Graph;

import java.util.*;

public class DetectCycleUndirectedGraph {
    boolean visited[];
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        visited = new boolean[V];
        
        for(int i = 0;i < V; i++){
            if(!visited[i]){
                if(solve(i,-1,adj)) return true ;
            }
        }
    
        return false;

    }
    
    public boolean solve(int node, int parent, ArrayList<ArrayList<Integer>> adj){
        
        visited[node] = true;
        
        for(Integer it : adj.get(node)){
            if(!visited[it]){
                if(solve(it,node,adj)) return true;
            }else if(it != parent){
                return true;
            }
        }
        
        return false;

    }
}
