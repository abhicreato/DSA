import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        int [] op = new int [2];
        Map<Integer,Integer> m = new HashMap();

        for(int i=0;i<nums.length;i++){

            if(m.containsKey(nums[i])){
                op[0] = m.get(nums[i]);
                op[1] = i;
                return op;
            }else{
                m.put(target - nums[i], i);
            }
        }

        return op;

    }
    

    public int[] twoSum2(int[] nums, int target) {

        int [] op = new int [2];

        for(int i=0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    op[0] = i;
                    op[1] = j;
                    return op;
                }
            }
        }

        return op;
    }
}
