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

public class PrimsAlgorithmMST {
    
     //Function to find sum of weights of edges of the Minimum Spanning Tree.
     static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
     {
         // Add your code here
         PriorityQueue<Pair> q = new PriorityQueue<>();
         int ans = 0;
         boolean visited[] = new boolean[V];
         
         q.add(new Pair(adj.get(0).get(0).get(0), 0));
         
         while(!q.isEmpty()){
             
             Pair curr = q.remove();
             
             if(visited[curr.val]) continue;
             
             visited[curr.val] = true;
 
             ans += curr.w;
             
             for(ArrayList<Integer> nbr : adj.get(curr.val)){
                 if(!visited[nbr.get(0)])
                 q.add(new Pair(nbr.get(0),nbr.get(1)));
             }
             
         }
 
         return ans;
     
     }
 }
 
 class Pair implements Comparable<Pair>{
         int val;
         int w;
         
         Pair(int val,int w){
             this.val = val;
             this.w = w;
         }
         
         public int compareTo(Pair p){
             return this.w - p.w;
         }
 }
