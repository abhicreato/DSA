package Graph;

/*
**************** Problem Description ****************
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
First line of the custom input must contain two space separated integers V denoting the number of vertices and E denoting the number of edges.
Next E lines contains three space-separated integers denoting each edge and weight between the edges.
    Example : 1
    
    Input: 
    3 3
    0 1 5
    1 2 3
    0 2 1
    
    Output: 4
*/

import java.util.*;

public class KruskalsAlgoMST {
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int ans = 0;
        int parents[] = new int[V];
        Arrays.fill(parents, -1);
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        for(int i=0;i<adj.size();i++){
            for(ArrayList<Integer> nbr : adj.get(i)){
                q.add(new Pair(i , nbr.get(0), nbr.get(1)));
            }
        }

        while(!q.isEmpty()){
            
            Pair currEdge = q.remove();
            
            int srcAbsParent = getAbsParent(currEdge.src,parents);
            int dstAbsParent = getAbsParent(currEdge.dst,parents);
            
            if(srcAbsParent != dstAbsParent){
                ans = ans + currEdge.cost;
                union(currEdge,parents);
            }
            
        }
        
        return ans;
        
    }
    
    static int getAbsParent(int node, int [] parents){
        // Get Absolute parent of the node based on Union Find Set logic
        if(parents[node] < 0) return node;
        
        // colapsing logic to reduce recursing for subsequent query requests  
        // return parents[node] = getAbsParent(parents[node],parents);
        
        // Non colapsing logic
        return getAbsParent(parents[node],parents);
       
    }
    
    static void union(Pair node, int [] parents){
        // Merge two Sets based on, Union find logic 
        // Without ranking logic ie 
        // Connect src Absolute parent to destinations Absolute parent 
        // OR destination Absolute parent to src Absolute parent 
        int srcAbsParent = getAbsParent(node.src,parents);
        int dstAbsParent = getAbsParent(node.dst,parents);
        
        //parents[srcAbsParent] = dstAbsParent;
        parents[dstAbsParent] = srcAbsParent;
        
    }
    
}

class Pair implements Comparable<Pair>{
    
    int src;
    int dst;
    int cost;
    
    Pair(int src, int dst, int cost){
        this.src = src;
        this.dst = dst;
        this.cost =cost;
    }
    
    public int compareTo(Pair p){
        return this.cost - p.cost;
    }
    
    public String toString(){
        return "[SRC : " + this.src + " DEST : " + this.dst + " COST : " + this.cost + "]";
    }
    
}
