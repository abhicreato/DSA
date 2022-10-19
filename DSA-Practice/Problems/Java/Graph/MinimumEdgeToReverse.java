package Graph;

import java.util.*;

public class MinimumEdgeToReverse {
    
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // Create a modified graph 
        Map<Integer,ArrayList<Pair>> modifiedGraph = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            
            ArrayList<Pair> nbrs = modifiedGraph.getOrDefault(edges[i][0], new ArrayList<Pair>());
            nbrs.add(new Pair(edges[i][1],0));
            modifiedGraph.put(edges[i][0],nbrs);
            
            ArrayList<Pair> nbrs1 = modifiedGraph.getOrDefault(edges[i][1], new ArrayList<Pair>());
            nbrs1.add(new Pair(edges[i][0],1));
            modifiedGraph.put(edges[i][1],nbrs1);
            
        }
        
        int dist[] = new int[n + 1];
        Arrays.fill(dist, 9999); 
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        q.add(new Pair(src,0));
        
        while(!q.isEmpty()){
            
            Pair curr = q.remove();

            for(Pair nbr: modifiedGraph.get(curr.val)){
                
                if(curr.w + nbr.w < dist[nbr.val]){
                    
                    dist[nbr.val] = curr.w + nbr.w;
                    q.add(new Pair(nbr.val,dist[nbr.val]));
                    
                }

            }
            
        }
        
        if(dist[dst] < 9999) return dist[dst];
        
        return -1;
        
    }
}

class Pair implements Comparable<Pair>{
    int val;
    int w;
    
    Pair(int val, int w){
        this.val = val;
        this.w = w;
    }
    
    public int compareTo(Pair o){
        return this.w - o.w;
    }
    
    public String toString() {
        return "Val : " + this.val + "; cost : " + this.w ;
    }
    
}


