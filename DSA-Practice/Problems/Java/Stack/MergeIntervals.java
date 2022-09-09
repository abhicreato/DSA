/*
**************** Problem Description ****************
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
  Example : 
  Input:
  intervals = [[1,3],[2,6],[8,10],[15,18]]
  Output: [[1,6],[8,10],[15,18]]
  Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
  Input:
  intervals = [[1,4],[4,5]]
  Output: [[1,5]]
  Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
class Pair implements Comparable<Pair>{
    int x;
    int y;
    
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public int compareTo(Pair p){
        if(this.x!=p.x){
            return this.x-p.x;
        }else{
            return this.y-p.y;
        }
    }

}

public class MergeIntervals {
   
    public int[][] merge(int[][] intr) {

        int row = intr.length;
        
        Pair in[] = new Pair[row];
        
        for(int i=0;i<row;i++){
            in[i] = new Pair(intr[i][0],intr[i][1]);
        }
        
        Arrays.sort(in);
        Stack<Pair> s = new Stack<>();
        Pair tempPair = null;
        
        for(int i=0;i<row;i++){
            if(s.empty()){
                s.push(in[i]);
            }else{
                tempPair = s.peek();
                if(in[i].x <= tempPair.y){
                    s.pop();
                    s.push(new Pair(tempPair.x, Math.max(tempPair.y,in[i].y)));
                }else{
                    s.push(in[i]);
                }
            }
        }
        
        int [][] op2 = new int[s.size()][2];
        
        int size=s.size();
        
        for(int i=0;i<size;i++){
            Pair t = s.pop();
            op2[i][0] = t.x;
            op2[i][1] = t.y;
        }

        return op2;
            
    } 
}

/*
**************** Logic ****************
Sort and add new interval in stack.
If the new interval overlaps with top then merge both intervals.
*/
