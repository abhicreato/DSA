import java.util.*;

public class SubarrayWith0Sum {

    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<n;i++){
            
            if(arr[i] == 0) return true;
            
            sum = sum + arr[i];
            
            if(sum == 0 || map.containsKey(sum)){
                return true;
            }
            
            map.put(sum,i);
        }
        
        return false;
    }
    
}
