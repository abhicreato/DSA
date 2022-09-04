/*
**************** Problem Description ****************
Given a binary matrix.
Find the maximum area of a rectangle formed only of 1s in the given matrix.
  Example : 
  Input: 
  n = 4, m = 4
  M[][] = {{0 1 1 0},
          {1 1 1 1},
          {1 1 1 1},
          {1 1 0 0}}
  
  Output: 8
  Explanation: For the above test case the matrix will look like
  
  0 1 1 0
  1 1 1 1
  1 1 1 1
  1 1 0 0
  the max size rectangle is 
  1 1 1 1
  1 1 1 1
  
  and area is 4 *2 = 8.
*/

class Pair{
    int val1;
    int val2;
    
    Pair(int x,int y){
        this.val1=x;
        this.val2=y;
    }
}

public class MaxAreaRectInBinaryMatrix {

    public int maxArea(int M[][], int n, int m) {
        // add code here.
        
        int maxA = 0;
        int[] row = new int[m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(M[i][j] !=0) row[j] = row[j] + M[i][j];
                else row[j] = 0;
            }
            
            maxA = Math.max(maxA,mAh(row,m));
        }
        
        return maxA;
    }
    
    public int mAh(int [] in, int n){
        int max = 0;
        int sL[] = nSl(in,n);
        int sR[] = nSr(in,n);
        
        for(int i=0;i<n;i++){
            max = Math.max(max,in[i] * (sR[i]-sL[i]-1));
        }
        
        return max;
    }
    
    public int[] nSl(int [] in,int n){
        int [] op = new int[n];
        Stack<Pair> s = new Stack<>();
        
        for(int i = 0; i<n;i++){
            while(!s.empty() && s.peek().val1 >= in[i]){
                s.pop();
            }
            
            if(s.empty()) op[i] = -1;
            else op[i] = s.peek().val2;
            
            s.push(new Pair(in[i],i));
        }
        
        return op;
    }
    
    public int[] nSr(int[]in,int n){
        int[] op = new int[n];
        Stack<Pair> s = new Stack<>();
        
        for(int i =n-1;i>=0;i--){
            while(!s.empty() && s.peek().val1 >= in[i]){
                s.pop();
            }
            
            if(s.empty()) op[i] = n;
            else op[i] = s.peek().val2;
            
            s.push(new Pair(in[i],i));
        }
        
        return op;
    }
    
}

/* 
**************** Logic ****************
Variation of max rectangular area in histogram.
Consider each row as a histogram and calculate max area for each row.
The max value among all the rows will be the answer.
*/
