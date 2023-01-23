import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0;i<nums.length;i++){
            
            if(map.get(nums[i]) != null){
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                return ans;
            }else{
                map.put(target - nums[i], i);
            }
            
        }
        
        return new int[2];

    }
    
}
