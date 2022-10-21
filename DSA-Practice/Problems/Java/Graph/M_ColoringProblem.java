package Graph;

/*
**************** Problem Description ****************
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color.
Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.
    
    Example : 1
    
    Input:
    N = 4
    M = 3
    E = 5
    Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
    
    Output: 1
    Explanation: It is possible to colour the given graph using 3 colours.
    Example : 2
    
    Input:
    N = 3
    M = 2
    E = 3
    Edges[] = {(0,1),(1,2),(0,2)}
    Output: 0
*/

public class M_ColoringProblem {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color [] = new int[n];
        
        if(possibleToColor(0,color,m,n,graph)) return true;
        
        else return false;
    }
    
    boolean possibleToColor(int currNode, int[] color, int m, int N, boolean graph[][] ){
        
        // This means all node are colored
        if(currNode == N) return true;
        
        // Try to color curr node with all possible colors possible
        for(int i=1; i<=m; i++){
            if(validToColorNode(currNode,color,graph,N,i)){
                color[currNode] = i;
                if(possibleToColor(currNode + 1, color ,m , N, graph)) return true;
                color[currNode] = 0;
            }
        }
        
        return false;
        
    }
    
    boolean validToColorNode(int node, int[] colors, boolean graph[][], int N, int color){
        
        // Check all neighbor node ans confirm if they have the same color which we are trying to give
        for(int i=0; i<N; i++){
            if(graph[node][i] && colors[i] == color){
                return false;
            }
        }
        
        return true;
    }

}

/*
**************** Logic ****************
The idea is to assign colours one by one to different vertices, starting from the vertex 0.
Before assigning a colour, we check for safety by considering already assigned colours to the adjacent vertices.
If we find a colour assignment which is safe, we mark the colour assignment as part of a solution. 
If we do not a find colour due to clashes then we backtrack and return false.
*/
