import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        int l = nums.length;
        int j,k;
        
        for(int i = 0 ;i<l; i++){
            
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            j = i + 1; k = l - 1;
            
            while(j<k){
                
                int sum = nums[i] + nums[j] + nums[k];
                
                if( sum == 0){
                    List<Integer> in = new ArrayList();
                    in.add(nums[i]);
                    in.add(nums[j]);
                    in.add(nums[k]);
                    ans.add(in);
                    
                    // Avoid duplicate of nums[start]
                    while (j < k && nums[j] == in.get(1)) j++;
                    
                    // Avoid duplicate of nums[end]
                    while (j < k && nums[k] == in.get(2)) k--;
                    
                }else if(sum > 0){
                    k--; 
                }else if(sum < 0){
                    j++;
                }
                
            }
                
        }
        
        return ans;
        
    }

    
}
