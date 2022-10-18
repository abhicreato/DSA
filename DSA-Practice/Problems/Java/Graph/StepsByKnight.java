package Graph;

import java.util.*;

public class StepsByKnight {
    
    int steps;
    boolean visited [][];
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        steps = 0;
        
        // x and y cordinates which knight can go
        int [] dx = {2,2,-2,-2,1,-1,1,-1};
        int [] dy = {1,-1,1,-1,2,2,-2,-2};
        
        visited = new boolean[N + 1][N + 1];
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0],KnightPos[1]));
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                
                Pair curr = q.remove();
   
                if(curr.x > N  || curr.y > N  || curr.x < 1 || curr.y < 1 || visited[curr.x][curr.y]) continue;
                
                visited[curr.x][curr.y] = true;
                
                if(curr.x == TargetPos[0] && curr.y == TargetPos[1]){
                    return steps;
                }
                
                // Move in all 8 direction to which knight can go
                for(int j=0 ; j<8; j++){
                    q.add(new Pair(curr.x + dx[j], curr.y + dy[j]));
                }
                
            }
            
            steps++;
            
        }
        
        return steps;
        
    }
    
    class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    

}
