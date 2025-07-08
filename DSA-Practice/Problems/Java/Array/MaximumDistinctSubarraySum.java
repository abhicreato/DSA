import java.util.HashMap;
import java.util.Map;

class MaximumDistinctSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {

        int i = 0;
        int j = 0;
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> m = new HashMap();

        while (j < nums.length) {

            sum = sum + nums[j];
            m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 == k) {
                if (m.size() == k)
                    maxSum = Math.max(sum, maxSum);

                m.put(nums[i], m.get(nums[i]) - 1);

                if (m.get(nums[i]) == 0) {
                    m.remove(nums[i]);
                }
                
                sum -= nums[i];
                i++;
            }

            j++;

        }

        return maxSum;

    }

}