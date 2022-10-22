package Graph;

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
// Example 2:

// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
// So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
// Example 3:

// Input: numCourses = 1, prerequisites = []
// Output: [0]

import java.util.*;

public class CourseSchedule {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjn list
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i<prerequisites.length; i++){            
            ArrayList<Integer> list = graph.getOrDefault(prerequisites[i][1],new ArrayList<Integer>());
            list.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1],list);
        }

        // detect a cycle , if cycle exist then it is impossible to order course to take
        boolean visited[] = new boolean[numCourses];
        boolean visiDfs[] = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(detectCycle(i, graph, visited, visiDfs))return new int[0];
            }
        }
        
         // Sort Topological
        int[] ans= new int[numCourses];
        Arrays.fill(visited,false);
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0;i<numCourses;i++){
            if(!visited[i])
                topoSortGraph(i, graph , s, visited);
        }
        
        System.out.println(s);
        
        int size = s.size();
        for(int i=0;i<size;i++){
            ans[i] = s.pop();
        }
        
        return ans;  
        
    }
    
    public void topoSortGraph(int curr, Map<Integer,ArrayList<Integer>> g, Stack<Integer> s, boolean[]visisted){
        
        if(visisted[curr]) return;
        
        visisted[curr] = true;
        
        if(g.get(curr) != null){
          for(int nbr: g.get(curr)){
                topoSortGraph(nbr, g, s, visisted);
            }  
        }
        
        s.push(curr);
    }
    
    public boolean detectCycle(int curr, Map<Integer,ArrayList<Integer>> g, boolean[] visisted, boolean[] visiDfs){
        
        visisted[curr] = true;
        
        visiDfs[curr] = true;
        
        if(g.get(curr) != null){
            for(Integer nbr: g.get(curr)){
                if(!visisted[nbr]){
                    if(detectCycle(nbr, g,visisted,visiDfs)) return true;
                }else if(visiDfs[nbr]){
                    return true;
                }
                    
            }
        }
        
        visiDfs[curr] = false;
        
        return false;
        
    }
    
}


// Check if it is a cycle , if not get topological sort of graph 
