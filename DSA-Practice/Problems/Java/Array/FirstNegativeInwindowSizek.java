import java.util.*;

/*
**************** Problem Description ****************
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
    Example1:
    Input: nums = [1,1,1], k = 2
    Output: 2
    Example2:
    Input: nums = [1,2,3], k = 3
    Output: 2
*/

public class FirstNegativeInwindowSizek {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        
        int i = 0;
        int j = 0;
        Queue<Long> q = new LinkedList<>();
        long[] ans = new long[N - K + 1];
        int index = 0;
        
        while(j < N){
            
            if(A[j] < 0){
                q.add(A[j]);
            }
            
            if(j - i + 1 == K){
                
                if(!q.isEmpty()){
                    ans[index++] = q.peek();
                    if(A[i]==q.peek()) q.poll();
                } else{
                    ans[index++] = 0;
                }
                
                i++;
            }
            
            j++;
        }
        
        return ans;
        
     
    }

    
}

/*
**************** Logic ****************
Sliding window variation, store only essential elements in queue.
 
*/
