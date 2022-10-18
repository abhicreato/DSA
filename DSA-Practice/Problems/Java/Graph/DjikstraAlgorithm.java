package Graph;

import java.util.*;

public class DjikstraAlgorithm {

//User function Template for Java
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] ans = new int[V];

        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        boolean visited[] = new boolean[V];
        
        q.add(new Pair(S,0));
        
        while(!q.isEmpty()){
            
            Pair curr = q.remove();
            
            if(visited[curr.val]) continue;
            
            visited[curr.val] = true;
            
            ans[curr.val] = curr.w;
            
            for(ArrayList<Integer> cu : adj.get(curr.val)){
                if(!visited[cu.get(0)]){
                    q.add(new Pair(cu.get(0),curr.w + cu.get(1)));
                }
            }
            
        }
        
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int val;
    int w;
    
    public Pair(int val, int w){
        this.val = val;
        this.w = w;
    }
    
    public int compareTo(Pair p){
        return this.w - p.w;
    }
}


