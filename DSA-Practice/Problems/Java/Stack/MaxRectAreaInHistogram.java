/*
**************** Problem Description ****************
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
    Example 1 : 
    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation:
    The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.
    Example 2 : 
    Input: heights = [2,4]
    Output: 4
*/

class Pair{
    int val1;
    int val2;
   
   Pair(int x,int y){
       this.val1 = x;
       this.val2 = y;
   }
}

public class MaxRectAreaInHistogram {
    
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int max = 0;
        
        
        int[] NLSA = this.NSL(heights, len);
        int[] NSRA = this.NSR(heights, len);
        int span = 0;
        
        for(int i = 0 ; i < len; i++){
            span = (NSRA[i] - NLSA[i] - 1);
            max = Math.max(max,(heights[i] * span ));
        }
        
        return max;
        
    }
    
    public int[] NSL(int[] heights,int l){
        
        int[] op = new int[l];
        
        Stack<Pair> s = new Stack<>();
        
        for(int i = 0 ; i < l ; i++){
            
            while(!s.empty() && s.peek().val1 >= heights[i]){
                s.pop();
            }
            
            if(s.empty()) op[i] = - 1;
            else op[i] = s.peek().val2;
            
            //System.out.print(op[i]+",");
            
            s.push(new Pair(heights[i],i));
        }
        
        return op;
        
    }
    
     public int[] NSR(int[] heights, int l){
         
         int op[] = new int[l];
         Stack<Pair> s = new Stack<>();
         
         for(int i = l-1 ;i>=0;i--){
             
            while(!s.empty() && s.peek().val1>=heights[i]){
                s.pop();
            }
             
            if(s.empty()) op[i] = l;           
            else op[i] = s.peek().val2;

            s.push(new Pair(heights[i],i));
             
         }
         
      return op;
        
    }
}

/*
**************** Logic ****************
Variation of Nearest Smaller to Left and Right problem.
Find nearest smaller to left and right for each index to calculate max rect width for each index.
*/
