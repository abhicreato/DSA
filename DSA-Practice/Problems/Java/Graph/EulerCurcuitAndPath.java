package Graph;

import java.util.*;

public class EulerCurcuitAndPath {
    

    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int ans = 0;
        boolean[] visited = new boolean[V];
        int nodeWithEdge = 0;
        boolean allZeroDegree = true;
        
        // Find node with edge
        for(int i=0; i<V; i++){
            if(adj.get(i).size() > 0){
                nodeWithEdge = i;
                break;
            }
        }
        
        // Travese with that node 
        dfs(nodeWithEdge,adj,visited);
            
        // If any node is notvisited and it has edge then not a Euler
        for(int i=0;i<V;i++){
            if(visited[i] == false && adj.get(i).size() > 0){
                    return 0;
            }
        }
            
        // check for semi euler
        int oddDegree = 0;
            
        for(int i=0;i<V;i++){
            if(adj.get(i).size() % 2 != 0)
            oddDegree++;
        }
            
        if(oddDegree == 0){
            return 2;
        }else if(oddDegree == 2){
            return 1;
        }else if(oddDegree > 2){
            return 0;
        }
            
        return 0;

    }
    
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
            if(!visited[nbr])
            dfs(nbr,adj,visited);
        }
    }


}
