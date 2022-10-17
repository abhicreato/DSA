package Graph;

import java.util.*;

public class DFSOfGraph {

    ArrayList<Integer> ans = new ArrayList<>();
    boolean visited[];
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visited = new boolean[V];
        
        solve(0,adj);
        
        return ans;
        
    }
    
    public void solve(int curr, ArrayList<ArrayList<Integer>> adj){
        if(visited[curr]){
            return;
        }
        ans.add(curr);
        visited[curr] = true;
        
        ArrayList<Integer> list = adj.get(curr);
        
        for(Integer c:list){
            solve(c,adj);
        }
        
    }

}
