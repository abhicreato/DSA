package Graph;

import java.util.*;

public class NumberOFOperationsToMakeNetworkConnected {
    
    int edge;
    int vertices;
    Map<Integer,ArrayList<Integer>> adjMap;
    int numOfComp;
    
    public int makeConnected(int n, int[][] connections) {
        
        edge = connections.length;
        vertices = n;
        adjMap = generateAdjL(connections);
        
        // DFS to find # of components
        boolean visited[] = new boolean[vertices];
        for(int i = 0; i<vertices; i++){
            if(!visited[i]){
                dfs(i,visited,adjMap);
                numOfComp++;
            }
        }
        
        // Min edge required to connect components 
        int redundentEdge = edge - ((vertices - 1) - (numOfComp - 1));
        
        if(redundentEdge >= (numOfComp - 1)) return numOfComp - 1;
        
        return -1;
 
    }
    
    public void dfs(int val, boolean[] visited, Map<Integer,ArrayList<Integer>> adjMap){
        
        if(visited[val]) return;
        
        visited[val] = true;
        
        for(Integer key: adjMap.getOrDefault(val, new ArrayList<Integer>())){
            dfs(key,visited,adjMap);
        }      
    }
    
    public Map<Integer,ArrayList<Integer>> generateAdjL( int[][] connections){
        
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
        for(int r = 0 ; r < connections.length; r++){
            
            ArrayList<Integer> list1 = adj.getOrDefault(connections[r][0], new ArrayList<Integer>());
            list1.add(connections[r][1]);
            adj.put(connections[r][0],list1);

            ArrayList<Integer> list2 = adj.getOrDefault(connections[r][1], new ArrayList<Integer>());
            list2.add(connections[r][0]);
            adj.put(connections[r][1],list2);
            
        }
        
        return adj;
        
    }

}

