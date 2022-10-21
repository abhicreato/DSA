package Graph;

/*
**************** Problem Description ****************
A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly once. Given an undirected graph  the task is to check if a Hamiltonian path is present in it or not.
    Example : 1
    
    Input:
    N = 4, M = 4
    Edges[][]= { {1,2}, {2,3}, {3,4}, {2,4} }
    Output: 1 
    Explanation: There is a hamiltonian path: 1 -> 2 -> 3 -> 4 
    
    
    Example : 2
    
    Input:
    N = 4, M = 3 
    Edges[][] = { {1,2}, {2,3}, {2,4} } 
    Output: 0 
    Explanation: It can be proved that there is no hamiltonian path in the given graph.
*/

import java.util.*;

public class HamiltonianPath {

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        Set<Integer> visited = new HashSet<>();
        
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(ArrayList<Integer> edge:Edges){
            int src=edge.get(0);
            int des=edge.get(1);
            
            ArrayList<Integer> list = map.getOrDefault(src, new ArrayList<Integer>());
            list.add(des);
            map.put(src,list);
            
            ArrayList<Integer> list2 = map.getOrDefault(des, new ArrayList<Integer>());
            list2.add(src);
            map.put(des,list2);
        }
        
        for(int i=1;i<=N;i++){
            if(solve(i, N, visited, map)) return true;
        }
       
        return false;
    }
    
    public boolean solve(int curr, int vertex, Set<Integer> visited, Map<Integer,ArrayList<Integer>> edges){
        
        visited.add(curr);
        
        if(visited.size() == vertex) return true;

        for(int nbr: edges.get(curr)){
            if(!visited.contains(nbr)){
              if(solve(nbr, vertex, visited, edges)) return true;
            }
        
        }
        
        visited.remove(curr);
        
        return false;
        
    }
    
}
