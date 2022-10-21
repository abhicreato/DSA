package Graph;

/*
**************** Problem Description ****************
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
First line of the custom input must contain two space separated integers V denoting the number of vertices and E denoting the number of edges.
Next E lines contains two space-separated integers denoting each edge.
    
    Example : 1
    
    Input:
    5 5
    1 0
    0 2
    2 1
    0 3
    3 4
    Output: 3
    Example : 2
    
    Input:
    3 3
    0 1
    1 2
    2 0
    Output: 1
*/

import java.util.*;

public class KosarajusAlgo {
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        int numOfSCC = 0;
        
        for(int i =0;i<V; i++){
            if(!visited[i])
            dfs(i,adj,s,visited);
        }
        
        Arrays.fill(visited,false);

        ArrayList<ArrayList<Integer>> rev = reverseGraphEdge(adj,V);
        
        while(!s.isEmpty()){
 
            int curr = s.pop();

            if(!visited[curr]) 
            {
                numOfSCC = numOfSCC + 1;
            
                dfsR(curr,rev,visited);
            }            
        }
        
        return numOfSCC;
    }
    
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean[] visited){
        
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
            if(!visited[nbr])
            dfs(nbr,adj,s,visited);
        }
        
        s.push(curr);
        
    }
    
     public void dfsR(int curr, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
           if(!visited[nbr])
            dfsR(nbr,adj,visited);
        }
        
    }
    
    
    public ArrayList<ArrayList<Integer>> reverseGraphEdge (ArrayList<ArrayList<Integer>> adj, int V){
        
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            
            reverseAdj.add(new ArrayList<Integer>());
          
        }
        
        for(int i=0; i<V; i++){
            for(Integer nbr: adj.get(i)){
                reverseAdj.get(nbr).add(i);
            }
        }
        
        return reverseAdj;
    
        
    }

}

/*
**************** Logic ****************
We can find all strongly connected components in O(V+E) time using Kosaraju’s algorithm. Following is detailed Kosaraju’s algorithm.
Do a DFS on the original graph, keeping track of the finish times of each vertex. This can be done with a stack, when some DFS finishes put the source vertex on the stack. 
This way node with highest finishing time will be on top of the stack.
Reverse directions of all arcs to obtain the transpose graph.
Do DFS on the reversed graph, with the vertex on top of the stack and keep marking the vertices visited.
When DFS finishes, all vertices visited will form one Strongly Connected Component.
If any more vertex remains unvisited, this means there are more Strongly Connected Component's,
so pop vertices from top of the stack until a valid unvisited node is found. This step is repeated until all nodes are visited.
 
*/
