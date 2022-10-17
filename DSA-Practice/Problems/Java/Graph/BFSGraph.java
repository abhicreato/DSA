package Graph;

import java.util.*;

public class BFSGraph {

    ArrayList<Integer> ans = new ArrayList<>();
    
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
    
        boolean [] visited = new boolean[V];
        
        LinkedList<Integer> q = new LinkedList<>();
        
        q.add(0);
  
        while(!q.isEmpty()){
            
            int curr = q.remove();
            
            if(visited[curr]){
               continue; 
            } 
            
            visited[curr] = true;
            
            ans.add(curr);
            
            ArrayList<Integer> adji = adj.get(curr);
            
            for(int i= 0; i < adji.size(); i++){
                q.add(adji.get(i));
            }
            
        }
        
        return ans;
    }
    
}
