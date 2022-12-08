import java.util.*;
public class SubarraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0,1);
        
        while(j < nums.length){
            
            sum = sum + nums[j];
            
            if(map.containsKey(sum - k)){
                ans = ans + map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
            j++;
        }   
        
        return ans;
    }
    
}
