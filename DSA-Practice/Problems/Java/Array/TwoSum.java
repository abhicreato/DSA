import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> m = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                return new int[] { m.get(nums[i]), i };
            }
            m.put(target - nums[i], i);
        }

        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {

        int[] op = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    op[0] = i;
                    op[1] = j;
                    return op;
                }
            }
        }

        return op;
    }
}
