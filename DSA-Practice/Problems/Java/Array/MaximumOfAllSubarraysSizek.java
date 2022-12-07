import java.util.*;

public class MaximumOfAllSubarraysSizek {

    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        int i =0;
        int j =0;
        ArrayList<Integer> ans = new ArrayList<>();
        //Queue<Integer> max = new LinkedList<>();
        Deque<Integer> max = new ArrayDeque<Integer>();
        
        while(j<n){
            
            while(max.size()> 0 && arr[j] > max.peekLast()){
                max.removeLast();
            }
            
            max.add(arr[j]);
            
            if(j - i + 1 == k){
                
                ans.add(max.peekFirst());
                
                if(max.peekFirst() == arr[i]){
                    max.removeFirst();
                }
                
                i++;
                
            }
            
            j++;
            
        }
        
        return ans;
    }
    
}

