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

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int i = 0;
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> op = new ArrayList<>();
        
        while(j < arr.length){
            
            if(arr[j] < 0) q.add(arr[j]);
            
            if(j - i + 1 == k){
                
                if(!q.isEmpty()){
                    op.add(q.peek());
                    if(q.peek() == arr[i]) q.poll();
                }else{
                    op.add(0);
                }
                
                i++;
            }
            
            j++;
        }
        
        return op;
    }
}

/*
**************** Logic ****************
Sliding window variation, store only essential elements in queue.
 
*/
