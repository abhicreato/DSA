package Graph;

import java.util.*;

public class BellmanFordAlgo {
    
    int dist[];
    
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //Initilize dist array with infinity except src itself
        dist = new int[n];
        Arrays.fill(this.dist,9999);
        this.dist[0] = 0;

        // Relax graph for (num of vertex - 1) times , 
        // if relaxing results are repeting it means there is no negative, return the same 
        for(int i = 0; i < n - 1; i++){
            if(!relaxingGraphUpdatingCost(edges, n)) return 0;
        }

        // If relaxing again, still results are not equal it means it has negative cycle 
        if(relaxingGraphUpdatingCost(edges,n)) return 1;
        
        return 0;
        
    }
    
    public boolean relaxingGraphUpdatingCost(int[][] edges, int numOfVertex){
        
        boolean updated = false;
        
        for(int i = 0 ; i < edges.length ; i++){
            
            int nodeSrc = edges[i][0];
            int nodeDest = edges[i][1];
            int weight = edges[i][2];
            
            if( dist[nodeSrc] + weight < dist[nodeDest]){
                dist[nodeDest] = dist[nodeSrc] + weight;
                updated = true;
            }
          
        } 
        
        return updated;
    }
    
}
